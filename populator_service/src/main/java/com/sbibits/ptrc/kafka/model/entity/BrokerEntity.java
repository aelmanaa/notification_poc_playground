package com.sbibits.ptrc.kafka.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "brokers", schema = "ptrc")
@NamedQueries({@NamedQuery(name = BrokerEntity.FIND_ALL_QUERY,
    query = "SELECT b FROM BrokerEntity b")})
public class BrokerEntity {

  static final public String FIND_ALL_QUERY = "Broker.findAll";

  public BrokerEntity() {}

  public BrokerEntity(String name, int partition) {
    this.brokerName = name;
    this.partition = Integer.toString(partition);
  }

  @Id
  @Column(name = "broker_id", nullable = false)
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String brokerId;

  @Column(name = "broker_name")
  private String brokerName;

  @Column(name = "partition")
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

