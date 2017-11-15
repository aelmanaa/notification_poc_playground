package com.sbibits.ptrc.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import com.sbibits.ptrc.kafka.model.entity.BrokerEntity;

public class BrokerSender {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(BrokerSender.class);

  @Value("${kafka.topic.broker}")
  private String brokerTopic;

  @Autowired
  private KafkaTemplate<String, BrokerEntity> kafkaTemplate;

  private void send(String id, BrokerEntity broker) {
    LOGGER.info("Sending broker with ID [{}]", id);
    this.kafkaTemplate.send(this.brokerTopic, id, broker);
  }

  public void send(BrokerEntity broker) {
    this.send(broker.getBrokerId(), broker);
  }

  public void overwriteWithNull(String id) {
    this.send(id, null);
  }

}
