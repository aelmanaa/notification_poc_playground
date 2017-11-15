package com.sbibits.ptrc.kafka.producer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.sbibits.ptrc.kafka.model.PtrcLog;
import com.sbibits.ptrc.kafka.model.entity.BrokerEntity;
import com.sbibits.ptrc.kafka.model.entity.NotifyConfigEntity;


@Configuration
public class SenderConfig {

  @Value("${kafka.bootstrap-servers}")
  private String bootstrapServers;

  @Bean
  public Map<String, Object> producerConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
        StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        JsonSerializer.class);

    return props;
  }

  @Bean
  public ProducerFactory<String, NotifyConfigEntity> configProducerFactory() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  @Bean
  public ProducerFactory<String, BrokerEntity> brokerProducerFactory() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  @Bean
  public ProducerFactory<String, PtrcLog> logProducerFactory() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  @Bean
  public KafkaTemplate<String, NotifyConfigEntity> configKafkaTemplate() {
    return new KafkaTemplate<>(configProducerFactory());
  }

  @Bean
  public KafkaTemplate<String, BrokerEntity> brokerKafkaTemplate() {
    return new KafkaTemplate<>(brokerProducerFactory());
  }

  @Bean
  public KafkaTemplate<String, PtrcLog> logKafkaTemplate() {
    return new KafkaTemplate<>(logProducerFactory());
  }

  @Bean
  public BrokerSender brokerSender() {
    return new BrokerSender();
  }

  @Bean
  public NotifyConfigSender configSender() {
    return new NotifyConfigSender();
  }

  @Bean
  public LogSender logSender() {
    return new LogSender();
  }

}
