package com.sbibits.ptrc.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import com.sbibits.ptrc.kafka.model.entity.NotifyConfigEntity;

public class NotifyConfigSender {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(NotifyConfigSender.class);

  @Value("${kafka.topic.notifyconfig}")
  private String configTopic;

  @Autowired
  private KafkaTemplate<String, NotifyConfigEntity> kafkaTemplate;

  private void send(String id, NotifyConfigEntity config) {
    LOGGER.info("Sending config with ID [{}]", id);
    this.kafkaTemplate.send(this.configTopic, id, config);
  }

  public void send(NotifyConfigEntity config) {
    this.send(config.getBrokerId(), config);
  }

  public void overwriteWithNull(String id) {
    this.send(id, null);
  }

}
