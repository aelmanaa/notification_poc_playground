package com.sbibits.ptrc.kafka;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbibits.ptrc.kafka.model.BrokerDao;
import com.sbibits.ptrc.kafka.model.entity.BrokerEntity;
import com.sbibits.ptrc.kafka.producer.BrokerSender;

@Component("BrokerService")
@Transactional
@RestController
@RequestMapping("/broker")
public class BrokerService {

  static final Logger LOGGER = LoggerFactory.getLogger(BrokerService.class);

  @Autowired
  private BrokerDao brokerDao;

  @Autowired
  private BrokerSender sender;

  @RequestMapping(method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<BrokerEntity> getAllBrokers() {
    return this.brokerDao.getAll();
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public BrokerEntity getBroker(@PathVariable("id") String id) {
    return this.brokerDao.find(id);
  }

  @RequestMapping(path = "/create", method = RequestMethod.GET)
  public void createBroker(@RequestParam("name") String name,
      @RequestParam(value = "partition", required = false,
          defaultValue = "33") String partition) {
    LOGGER.info(String.format(
        "Create broker with [name=%s] and [partition=%s].", name, partition));
    this.sender.send(this.brokerDao.create(name, Integer.parseInt(partition)));
  }

  @RequestMapping(path = "/populate", method = RequestMethod.GET)
  public void populate() {
    this.getAllBrokers().forEach(b -> {
      LOGGER.info(String.format("Put broker [%s] on topic.", b));
      this.sender.send(b);
    });;
  }

  @RequestMapping(path = "/{id}/populate", method = RequestMethod.GET)
  public void populate(@PathVariable("id") String id) {
    BrokerEntity broker = this.brokerDao.find(id);
    LOGGER.info(String.format("Put broker [%s] on topic.", broker));
    this.sender.send(broker);
  }

  @RequestMapping(path = "/remove", method = RequestMethod.GET)
  public void remove() {
    LOGGER.info("Removing all brokers from topic.");
    this.getAllBrokers().stream().map(b -> b.getBrokerId()).forEach(id -> {
      this.remove(id);
    });
  }

  @RequestMapping(path = "/{id}/remove", method = RequestMethod.GET)
  public void remove(@PathVariable("id") String id) {
    LOGGER.info(String.format("Removing [%s] from topic.", id));
    this.sender.overwriteWithNull(id);
  }

  @RequestMapping(path = "/help", method = RequestMethod.GET)
  public ResponseEntity<String> serviceHelp() {
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.TEXT_PLAIN)
        .body("Broker service API:\n" + "base endpoint:\n"
            + "/broker - return all brokers in db\n" + "sub endpoints:\n"
            + "\t/{id} - returns the broker with the specified ID\n"
            + "\t/create?name={name}&partition={partition} - create new broker with specified properties\n"
            + "\t/populate - populates kafka topic with all broker info existing in db\n"
            + "\t/{id}/populate - populate kafka topic with broker with specified id\n"
            + "\t/remove - remove all brokers from kafka topic\n"
            + "\t/{id}/remove - Remove broker with specified id from topic\n");
  }

}
