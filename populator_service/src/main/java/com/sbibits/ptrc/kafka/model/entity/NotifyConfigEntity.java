package com.sbibits.ptrc.kafka.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "notifyconfig", schema = "ptrc")
@NamedQueries({@NamedQuery(name = NotifyConfigEntity.FIND_ALL_QUERY,
    query = "SELECT b FROM NotifyConfigEntity b")})
public class NotifyConfigEntity {

  public static final String FIND_ALL_QUERY = "NotifyConfig.findAdd";

  public NotifyConfigEntity() {}

  public NotifyConfigEntity(String brokerId, String username,
      NotificationType type) {
    this.brokerId = brokerId;
    this.username = username;
    this.type = type;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @Column(name = "broker_id")
  private String brokerId;

  @Column(name = "username")
  private String username;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private NotificationType type;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBrokerId() {
    return this.brokerId;
  }

  public void setBrokerId(String brokerId) {
    this.brokerId = brokerId;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public NotificationType getType() {
    return this.type;
  }

  public void setType(NotificationType type) {
    this.type = type;
  }

  public enum NotificationType {
    EMAIL, SMS, PUSH
  }

}
