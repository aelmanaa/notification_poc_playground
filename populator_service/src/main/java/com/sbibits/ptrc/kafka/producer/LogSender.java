package com.sbibits.ptrc.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import com.sbibits.ptrc.kafka.model.PtrcLog;

public class LogSender {

  private static final Logger LOGGER = LoggerFactory.getLogger(LogSender.class);

  @Value("${kafka.topic.log}")
  private String logTopic;

  @Autowired
  private KafkaTemplate<String, PtrcLog> kafkaTemplate;

  private void send(String id, PtrcLog log) {
    LOGGER.info("Sending log for broker [{}]", id);
    this.kafkaTemplate.send(this.logTopic, id, log);
  }

  public void send(PtrcLog log) {
    this.send(log.getBrokerId(), log);
  }

  public void overwriteWithNull(String id) {
    this.send(id, null);
  }

}
