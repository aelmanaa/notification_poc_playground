package com.sbibits.ptrc.kafka.model;

public class Broker {

  static final public String FIND_ALL_QUERY = "Broker.findAll";

  public Broker() {}

  public Broker(String name, int partition) {
    this.brokerName = name;
    this.partition = Integer.toString(partition);
  }

  private String brokerId;

  private String brokerName;

  private String partition;

  public String getBrokerId() {
    return this.brokerId;
  }

  public void setBrokerId(String brokerId) {
    this.brokerId = brokerId;
  }

  public String getBrokerName() {
    return this.brokerName;
  }

  public void setBrokerName(String brokerName) {
    this.brokerName = brokerName;
  }

  public String getPartition() {
    return this.partition;
  }

  public void setPartition(String partition) {
    this.partition = partition;
  }

  @Override
  public String toString() {
    return String.format("Broker: {id: %s, name: %s, partitions: %s}",
        this.brokerId, this.brokerName, this.partition);
  }

}

