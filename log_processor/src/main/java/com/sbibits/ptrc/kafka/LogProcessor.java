package com.sbibits.ptrc.kafka;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.kstream.KTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

import com.sbibits.ptrc.kafka.model.Broker;
import com.sbibits.ptrc.kafka.model.NotifyConfig;
import com.sbibits.ptrc.kafka.model.PtrcLog;

@Component("LogProcessor")
public class LogProcessor {

  Logger LOGGER = LoggerFactory.getLogger(LogProcessor.class);

  @Value("${kafka.topic.log}")
  private String logTopic;
  @Value("${kafka.topic.broker}")
  private String brokerTopic;
  @Value("${kafka.topic.notifyconfig}")
  private String notifyConfigTopic;
  @Value("${kafka.topic.notification}")
  private String notificationTopic;
  @Value("${kafka.streams-config.bootstrap-servers}")
  private String bootstrapServers;
  @Value("${kafka.streams-config.zookeeper-connect}")
  private String zookeeperConnect;


  private KafkaStreams streams;

  @PostConstruct
  public void runStream() {
    Serde<String> stringSerde = Serdes.String();
    Serde<Broker> brokerSerde = new JsonSerde<>(Broker.class);
    Serde<NotifyConfig> configSerde = new JsonSerde<>(NotifyConfig.class);
    Serde<PtrcLog> logSerde = new JsonSerde<>(PtrcLog.class);

    Properties streamsConfig = new Properties();
    final String version = "0.3";
    streamsConfig.put(StreamsConfig.APPLICATION_ID_CONFIG,
        "kafka-streams-test-" + version);
    streamsConfig.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    streamsConfig.put(StreamsConfig.ZOOKEEPER_CONNECT_CONFIG, zookeeperConnect);

    KStreamBuilder builder = new KStreamBuilder();
    KTable<String, Broker> brokers =
        builder.table(stringSerde, brokerSerde, this.brokerTopic);
    KTable<String, NotifyConfig> configs =
        builder.table(stringSerde, configSerde, this.notifyConfigTopic);
    KStream<String, PtrcLog> logs =
        builder.stream(stringSerde, logSerde, this.logTopic);

    logs.leftJoin(brokers, (log, broker) -> {
      LOGGER.info("join on log for broker [{}]", broker.getBrokerId());
      log.setPartition(Integer.parseInt(broker.getPartition()));
      return log;
    }).leftJoin(configs, (log, config) -> {
      LOGGER.info("join on log for user [{}]", config.getUsername());
      log.setUsername(config.getUsername());
      return "Notification for user [" + log.getUsername() + "]";
    }).to(stringSerde, stringSerde, this.notificationTopic);

    streams = new KafkaStreams(builder, streamsConfig);
    streams.start();

    Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
  }

  @PreDestroy
  public void closeStream() {}

}
