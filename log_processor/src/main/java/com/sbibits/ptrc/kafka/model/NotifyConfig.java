package com.sbibits.ptrc.kafka.model;

public class NotifyConfig {

  public NotifyConfig() {}

  public NotifyConfig(String brokerId, String username, NotificationType type) {
    this.brokerId = brokerId;
    this.username = username;
    this.type = type;
  }

  private String id;

  private String brokerId;

  private String username;

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
