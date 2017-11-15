package com.sbibits.ptrc.kafka;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbibits.ptrc.kafka.model.BrokerDao;
import com.sbibits.ptrc.kafka.model.PtrcLog;
import com.sbibits.ptrc.kafka.model.entity.BrokerEntity;
import com.sbibits.ptrc.kafka.producer.LogSender;

@Component("LogSerivce")
@Transactional
@RestController
@RequestMapping("/log")
public class LogService {

  static private final Logger LOGGER =
      LoggerFactory.getLogger(LogService.class);

  static private final PtrcLog baseLog = PtrcLog.builder().setGroup(1)
      .setOrder_token(2).setFormer_order_token(1).setSide("BUY").setPrice(1000)
      .setShare(100).setFirm(12).setFf_value(100000F).setCo_value(100000)
      .setCe_value(100000).setSource_ip(1112223334).setSource_port(1234)
      .setSource_mac(444433332).setDest_ip(1234123412).setDest_port(4321)
      .setDest_mac(432143214).setSession_id("sessionid").setFf_limit(999999999)
      .setCo_limit(999999999).setCe_limit(999999999).setCo_part_limit1(99999)
      .setCo_part_limit2(9999).setCe_part_limit1(99999).setCe_part_limit2(9999)
      .setTime_configured(1234345123).setInternal_timestamp(12323423)
      .setConnector_timestamp("conntimestamp").setOrder_type("ordertype")
      .setClient_ref("clientref").setOuch_timestamp(123143232)
      .setSecurity_id(123123123).setGroup_reason("groupreason")
      .setMatch_number(42).setUsername("username").setPartition(12312312)
      .setLocation(123).build();

  @Autowired
  private BrokerDao brokerDao;

  @Autowired
  private LogSender sender;

  private List<BrokerEntity> brokers;

  @PostConstruct
  public void setup() {
    // load all broker info
    this.brokers = this.brokerDao.getAll();
  }

  @RequestMapping(path = "/generate", method = RequestMethod.GET)
  public void generate(
      @RequestParam(value = "broker", required = false) String brokerId,
      @RequestParam(value = "amount", required = false,
          defaultValue = "1") int amount) {
    Stream<String> idStream;
    if (brokerId == null) {
      LOGGER.info("Generate [{}] logs for random brokers.", amount);
      // generate random broker ID stream
      idStream = new Random().ints(amount, 0, this.brokers.size())
          .mapToObj(this.brokers::get).map(BrokerEntity::getBrokerId);
    } else {
      LOGGER.info("Generate [{}] logs for broker [{}].", amount, brokerId);
      // generate broker ID stream containing same ID repeatedly
      idStream = IntStream.range(0, amount).mapToObj(i -> brokerId);
    }

    idStream.map(this::getLog).forEach(this.sender::send);
  }

  @RequestMapping(path = "/help", method = RequestMethod.GET)
  public ResponseEntity<String> serviceHelp() {
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.TEXT_PLAIN)
        .body("Log service API:\n" + "base endpoint:\n" + "/log\n"
            + "sub endpoints:\n"
            + "\t/generate[?broker=<brokerId>][&amount=<amount>] - generates logs for specified broker"
            + "if specified, for random brokers otherwise.\n");
  }

  private PtrcLog getLog(String brokerId) {
    return PtrcLog.builder(LogService.baseLog).setBrokerId(brokerId).build();
  }

}
