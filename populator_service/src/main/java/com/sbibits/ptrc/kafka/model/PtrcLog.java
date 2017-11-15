package com.sbibits.ptrc.kafka.model;

public class PtrcLog {

  private String brokerId;
  private int group;
  private boolean if_ff_limit;
  private boolean if_ff_warning;
  private boolean if_ff_notice;
  private boolean if_co_limit;
  private boolean if_co_warning;
  private boolean if_co_notice;
  private boolean if_ce_limit;
  private boolean if_ce_warning;
  private boolean if_ce_notice;
  private int order_token;
  private int former_order_token;
  private String side;
  private int price;
  private int share;
  private int firm;
  private double ff_value;
  private double co_value;
  private double ce_value;
  private int source_ip;
  private int source_port;
  private long source_mac;
  private int dest_ip;
  private int dest_port;
  private long dest_mac;
  private String session_id;
  private double ff_limit;
  private double co_limit;
  private double ce_limit;
  private double co_part_limit1;
  private double co_part_limit2;
  private double ce_part_limit1;
  private double ce_part_limit2;
  private int time_configured;
  private double internal_timestamp;
  private String connector_timestamp;
  private String order_type;
  private double ouch_timestamp;
  private String client_ref;
  private int security_id;
  private boolean if_kill_switch;
  private boolean if_bypass;
  private boolean if_modify;
  private boolean if_from_exchange;
  private boolean if_replay;
  private String group_reason;
  private double match_number;
  private String username;
  private int partition;
  private int location;

  private PtrcLog() {}

  public String getBrokerId() {
    return this.brokerId;
  }

  public void setBrokerId(String brokerId) {
    this.brokerId = brokerId;
  }

  public int getGroup() {
    return this.group;
  }

  public void setGroup(int group) {
    this.group = group;
  }

  public boolean isIf_ff_limit() {
    return this.if_ff_limit;
  }

  public void setIf_ff_limit(boolean if_ff_limit) {
    this.if_ff_limit = if_ff_limit;
  }

  public boolean isIf_ff_warning() {
    return this.if_ff_warning;
  }

  public void setIf_ff_warning(boolean if_ff_warning) {
    this.if_ff_warning = if_ff_warning;
  }

  public boolean isIf_ff_notice() {
    return this.if_ff_notice;
  }

  public void setIf_ff_notice(boolean if_ff_notice) {
    this.if_ff_notice = if_ff_notice;
  }

  public boolean isIf_co_limit() {
    return this.if_co_limit;
  }

  public void setIf_co_limit(boolean if_co_limit) {
    this.if_co_limit = if_co_limit;
  }

  public boolean isIf_co_warning() {
    return this.if_co_warning;
  }

  public void setIf_co_warning(boolean if_co_warning) {
    this.if_co_warning = if_co_warning;
  }

  public boolean isIf_co_notice() {
    return this.if_co_notice;
  }

  public void setIf_co_notice(boolean if_co_notice) {
    this.if_co_notice = if_co_notice;
  }

  public boolean isIf_ce_limit() {
    return this.if_ce_limit;
  }

  public void setIf_ce_limit(boolean if_ce_limit) {
    this.if_ce_limit = if_ce_limit;
  }

  public boolean isIf_ce_warning() {
    return this.if_ce_warning;
  }

  public void setIf_ce_warning(boolean if_ce_warning) {
    this.if_ce_warning = if_ce_warning;
  }

  public boolean isIf_ce_notice() {
    return this.if_ce_notice;
  }

  public void setIf_ce_notice(boolean if_ce_notice) {
    this.if_ce_notice = if_ce_notice;
  }

  public int getOrder_token() {
    return this.order_token;
  }

  public void setOrder_token(int order_token) {
    this.order_token = order_token;
  }

  public int getFormer_order_token() {
    return this.former_order_token;
  }

  public void setFormer_order_token(int former_order_token) {
    this.former_order_token = former_order_token;
  }

  public String getSide() {
    return this.side;
  }

  public void setSide(String side) {
    this.side = side;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getShare() {
    return this.share;
  }

  public void setShare(int share) {
    this.share = share;
  }

  public int getFirm() {
    return this.firm;
  }

  public void setFirm(int firm) {
    this.firm = firm;
  }

  public double getFf_value() {
    return this.ff_value;
  }

  public void setFf_value(double ff_value) {
    this.ff_value = ff_value;
  }

  public double getCo_value() {
    return this.co_value;
  }

  public void setCo_value(double co_value) {
    this.co_value = co_value;
  }

  public double getCe_value() {
    return this.ce_value;
  }

  public void setCe_value(double ce_value) {
    this.ce_value = ce_value;
  }

  public int getSource_ip() {
    return this.source_ip;
  }

  public void setSource_ip(int source_ip) {
    this.source_ip = source_ip;
  }

  public int getSource_port() {
    return this.source_port;
  }

  public void setSource_port(int source_port) {
    this.source_port = source_port;
  }

  public long getSource_mac() {
    return this.source_mac;
  }

  public void setSource_mac(long source_mac) {
    this.source_mac = source_mac;
  }

  public int getDest_ip() {
    return this.dest_ip;
  }

  public void setDest_ip(int dest_ip) {
    this.dest_ip = dest_ip;
  }

  public int getDest_port() {
    return this.dest_port;
  }

  public void setDest_port(int dest_port) {
    this.dest_port = dest_port;
  }

  public long getDest_mac() {
    return this.dest_mac;
  }

  public void setDest_mac(long dest_mac) {
    this.dest_mac = dest_mac;
  }

  public String getSession_id() {
    return this.session_id;
  }

  public void setSession_id(String session_id) {
    this.session_id = session_id;
  }

  public double getFf_limit() {
    return this.ff_limit;
  }

  public void setFf_limit(double ff_limit) {
    this.ff_limit = ff_limit;
  }

  public double getCo_limit() {
    return this.co_limit;
  }

  public void setCo_limit(double co_limit) {
    this.co_limit = co_limit;
  }

  public double getCe_limit() {
    return this.ce_limit;
  }

  public void setCe_limit(double ce_limit) {
    this.ce_limit = ce_limit;
  }

  public double getCo_part_limit1() {
    return this.co_part_limit1;
  }

  public void setCo_part_limit1(double co_part_limit1) {
    this.co_part_limit1 = co_part_limit1;
  }

  public double getCo_part_limit2() {
    return this.co_part_limit2;
  }

  public void setCo_part_limit2(double co_part_limit2) {
    this.co_part_limit2 = co_part_limit2;
  }

  public double getCe_part_limit1() {
    return this.ce_part_limit1;
  }

  public void setCe_part_limit1(double ce_part_limit1) {
    this.ce_part_limit1 = ce_part_limit1;
  }

  public double getCe_part_limit2() {
    return this.ce_part_limit2;
  }

  public void setCe_part_limit2(double ce_part_limit2) {
    this.ce_part_limit2 = ce_part_limit2;
  }

  public int getTime_configured() {
    return this.time_configured;
  }

  public void setTime_configured(int time_configured) {
    this.time_configured = time_configured;
  }

  public double getInternal_timestamp() {
    return this.internal_timestamp;
  }

  public void setInternal_timestamp(double internal_timestamp) {
    this.internal_timestamp = internal_timestamp;
  }

  public String getConnector_timestamp() {
    return this.connector_timestamp;
  }

  public void setConnector_timestamp(String connector_timestamp) {
    this.connector_timestamp = connector_timestamp;
  }

  public String getOrder_type() {
    return this.order_type;
  }

  public void setOrder_type(String order_type) {
    this.order_type = order_type;
  }

  public double getOuch_timestamp() {
    return this.ouch_timestamp;
  }

  public void setOuch_timestamp(double ouch_timestamp) {
    this.ouch_timestamp = ouch_timestamp;
  }

  public String getClient_ref() {
    return this.client_ref;
  }

  public void setClient_ref(String client_ref) {
    this.client_ref = client_ref;
  }

  public int getSecurity_id() {
    return this.security_id;
  }

  public void setSecurity_id(int security_id) {
    this.security_id = security_id;
  }

  public boolean isIf_kill_switch() {
    return this.if_kill_switch;
  }

  public void setIf_kill_switch(boolean if_kill_switch) {
    this.if_kill_switch = if_kill_switch;
  }

  public boolean isIf_bypass() {
    return this.if_bypass;
  }

  public void setIf_bypass(boolean if_bypass) {
    this.if_bypass = if_bypass;
  }

  public boolean isIf_modify() {
    return this.if_modify;
  }

  public void setIf_modify(boolean if_modify) {
    this.if_modify = if_modify;
  }

  public boolean isIf_from_exchange() {
    return this.if_from_exchange;
  }

  public void setIf_from_exchange(boolean if_from_exchange) {
    this.if_from_exchange = if_from_exchange;
  }

  public boolean isIf_replay() {
    return this.if_replay;
  }

  public void setIf_replay(boolean if_replay) {
    this.if_replay = if_replay;
  }

  public String getGroup_reason() {
    return this.group_reason;
  }

  public void setGroup_reason(String group_reason) {
    this.group_reason = group_reason;
  }

  public double getMatch_number() {
    return this.match_number;
  }

  public void setMatch_number(double match_number) {
    this.match_number = match_number;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getPartition() {
    return this.partition;
  }

  public void setPartition(int partition) {
    this.partition = partition;
  }

  public int getLocation() {
    return this.location;
  }

  public void setLocation(int location) {
    this.location = location;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(PtrcLog log) {
    return new Builder(log);
  }

  public static class Builder {

    private String brokerId;
    private int group;
    private boolean if_ff_limit = false;
    private boolean if_ff_warning = false;
    private boolean if_ff_notice = false;
    private boolean if_co_limit = false;
    private boolean if_co_warning = false;
    private boolean if_co_notice = false;
    private boolean if_ce_limit = false;
    private boolean if_ce_warning = false;
    private boolean if_ce_notice = false;
    private int order_token;
    private int former_order_token;
    private String side;
    private int price;
    private int share;
    private int firm;
    private double ff_value;
    private double co_value;
    private double ce_value;
    private int source_ip;
    private int source_port;
    private long source_mac;
    private int dest_ip;
    private int dest_port;
    private long dest_mac;
    private String session_id;
    private double ff_limit;
    private double co_limit;
    private double ce_limit;
    private double co_part_limit1;
    private double co_part_limit2;
    private double ce_part_limit1;
    private double ce_part_limit2;
    private int time_configured;
    private double internal_timestamp;
    private String connector_timestamp;
    private String order_type;
    private double ouch_timestamp;
    private String client_ref;
    private int security_id;
    private boolean if_kill_switch = false;
    private boolean if_bypass = false;
    private boolean if_modify = false;
    private boolean if_from_exchange = false;
    private boolean if_replay = false;
    private String group_reason;
    private double match_number;
    private String username;
    private int partition;
    private int location;

    public Builder() {}

    public Builder(PtrcLog log) {
      this.brokerId = log.brokerId;
      this.group = log.group;
      this.if_ff_limit = log.if_ff_limit;
      this.if_ff_warning = log.if_ff_warning;
      this.if_ff_notice = log.if_ff_notice;
      this.if_co_limit = log.if_co_limit;
      this.if_co_warning = log.if_co_warning;
      this.if_co_notice = log.if_co_notice;
      this.if_ce_limit = log.if_ce_limit;
      this.if_ce_warning = log.if_ce_warning;
      this.order_token = log.order_token;
      this.former_order_token = log.former_order_token;
      this.side = log.side;
      this.price = log.price;
      this.share = log.share;
      this.firm = log.firm;
      this.ff_value = log.ff_value;
      this.co_value = log.co_value;
      this.ce_value = log.ce_value;
      this.source_ip = log.source_ip;
      this.source_port = log.source_port;
      this.source_mac = log.source_mac;
      this.dest_ip = log.dest_ip;
      this.dest_port = log.dest_port;
      this.dest_mac = log.dest_mac;
      this.session_id = log.session_id;
      this.ff_limit = log.ff_limit;
      this.co_limit = log.co_limit;
      this.ce_limit = log.ce_limit;
      this.co_part_limit1 = log.co_part_limit1;
      this.co_part_limit2 = log.co_part_limit2;
      this.ce_part_limit1 = log.ce_part_limit1;
      this.ce_part_limit2 = log.ce_part_limit2;
      this.time_configured = log.time_configured;
      this.internal_timestamp = log.internal_timestamp;
      this.connector_timestamp = log.connector_timestamp;
      this.order_type = log.order_type;
      this.ouch_timestamp = log.ouch_timestamp;
      this.client_ref = log.client_ref;
      this.security_id = log.security_id;
      this.if_kill_switch = log.if_kill_switch;
      this.if_bypass = log.if_bypass;
      this.if_modify = log.if_modify;
      this.if_from_exchange = log.if_from_exchange;
      this.if_replay = log.if_replay;
      this.group_reason = log.group_reason;
      this.match_number = log.match_number;
      this.username = log.username;
      this.partition = log.partition;
      this.location = log.location;
    }

    public Builder setBrokerId(String brokerId) {
      this.brokerId = brokerId;

      return this;
    }

    public Builder setGroup(int group) {
      this.group = group;

      return this;
    }

    public Builder setIf_ff_limit(boolean if_ff_limit) {
      this.if_ff_limit = if_ff_limit;

      return this;
    }

    public Builder setIf_ff_warning(boolean if_ff_warning) {
      this.if_ff_warning = if_ff_warning;

      return this;
    }

    public Builder setIf_ff_notice(boolean if_ff_notice) {
      this.if_ff_notice = if_ff_notice;

      return this;
    }

    public Builder setIf_co_limit(boolean if_co_limit) {
      this.if_co_limit = if_co_limit;

      return this;
    }

    public Builder setIf_co_warning(boolean if_co_warning) {
      this.if_co_warning = if_co_warning;

      return this;
    }

    public Builder setIf_co_notice(boolean if_co_notice) {
      this.if_co_notice = if_co_notice;

      return this;
    }

    public Builder setIf_ce_limit(boolean if_ce_limit) {
      this.if_ce_limit = if_ce_limit;

      return this;
    }

    public Builder setIf_ce_warning(boolean if_ce_warning) {
      this.if_ce_warning = if_ce_warning;

      return this;
    }

    public Builder setIf_ce_notice(boolean if_ce_notice) {
      this.if_ce_notice = if_ce_notice;

      return this;
    }

    public Builder setOrder_token(int order_token) {
      this.order_token = order_token;

      return this;
    }

    public Builder setFormer_order_token(int former_order_token) {
      this.former_order_token = former_order_token;

      return this;
    }

    public Builder setSide(String side) {
      this.side = side;

      return this;
    }

    public Builder setPrice(int price) {
      this.price = price;

      return this;
    }

    public Builder setShare(int share) {
      this.share = share;

      return this;
    }

    public Builder setFirm(int firm) {
      this.firm = firm;

      return this;
    }

    public Builder setFf_value(double ff_value) {
      this.ff_value = ff_value;

      return this;
    }

    public Builder setCo_value(double co_value) {
      this.co_value = co_value;

      return this;
    }

    public Builder setCe_value(double ce_value) {
      this.ce_value = ce_value;

      return this;
    }

    public Builder setSource_ip(int source_ip) {
      this.source_ip = source_ip;

      return this;
    }

    public Builder setSource_port(int source_port) {
      this.source_port = source_port;

      return this;
    }

    public Builder setSource_mac(long source_mac) {
      this.source_mac = source_mac;

      return this;
    }

    public Builder setDest_ip(int dest_ip) {
      this.dest_ip = dest_ip;

      return this;
    }

    public Builder setDest_port(int dest_port) {
      this.dest_port = dest_port;

      return this;
    }

    public Builder setDest_mac(long dest_mac) {
      this.dest_mac = dest_mac;

      return this;
    }

    public Builder setSession_id(String session_id) {
      this.session_id = session_id;

      return this;
    }

    public Builder setFf_limit(double ff_limit) {
      this.ff_limit = ff_limit;

      return this;
    }

    public Builder setCo_limit(double co_limit) {
      this.co_limit = co_limit;

      return this;
    }

    public Builder setCe_limit(double ce_limit) {
      this.ce_limit = ce_limit;

      return this;
    }

    public Builder setCo_part_limit1(double co_part_limit1) {
      this.co_part_limit1 = co_part_limit1;

      return this;
    }

    public Builder setCo_part_limit2(double co_part_limit2) {
      this.co_part_limit2 = co_part_limit2;

      return this;
    }

    public Builder setCe_part_limit1(double ce_part_limit1) {
      this.ce_part_limit1 = ce_part_limit1;

      return this;
    }

    public Builder setCe_part_limit2(double ce_part_limit2) {
      this.ce_part_limit2 = ce_part_limit2;

      return this;
    }

    public Builder setTime_configured(int time_configured) {
      this.time_configured = time_configured;

      return this;
    }

    public Builder setInternal_timestamp(double internal_timestamp) {
      this.internal_timestamp = internal_timestamp;

      return this;
    }

    public Builder setConnector_timestamp(String connector_timestamp) {
      this.connector_timestamp = connector_timestamp;

      return this;
    }

    public Builder setOrder_type(String order_type) {
      this.order_type = order_type;

      return this;
    }

    public Builder setOuch_timestamp(double ouch_timestamp) {
      this.ouch_timestamp = ouch_timestamp;

      return this;
    }

    public Builder setClient_ref(String client_ref) {
      this.client_ref = client_ref;

      return this;
    }

    public Builder setSecurity_id(int security_id) {
      this.security_id = security_id;

      return this;
    }

    public Builder setIf_kill_switch(boolean if_kill_switch) {
      this.if_kill_switch = if_kill_switch;

      return this;
    }

    public Builder setIf_bypass(boolean if_bypass) {
      this.if_bypass = if_bypass;

      return this;
    }

    public Builder setIf_modify(boolean if_modify) {
      this.if_modify = if_modify;

      return this;
    }

    public Builder setIf_from_exchange(boolean if_from_exchange) {
      this.if_from_exchange = if_from_exchange;

      return this;
    }

    public Builder setIf_replay(boolean if_replay) {
      this.if_replay = if_replay;

      return this;
    }

    public Builder setGroup_reason(String group_reason) {
      this.group_reason = group_reason;

      return this;
    }

    public Builder setMatch_number(double match_number) {
      this.match_number = match_number;

      return this;
    }

    public Builder setUsername(String username) {
      this.username = username;

      return this;
    }

    public Builder setPartition(int partition) {
      this.partition = partition;

      return this;
    }

    public Builder setLocation(int location) {
      this.location = location;

      return this;
    }

    public PtrcLog build() {
      return this.build(new PtrcLog());
    }

    private PtrcLog build(PtrcLog log) {
      log.brokerId = this.brokerId;
      log.group = this.group;
      log.if_ff_limit = this.if_ff_limit;
      log.if_ff_warning = this.if_ff_warning;
      log.if_ff_notice = this.if_ff_notice;
      log.if_co_limit = this.if_co_limit;
      log.if_co_warning = this.if_co_warning;
      log.if_co_notice = this.if_co_notice;
      log.if_ce_limit = this.if_ce_limit;
      log.if_ce_warning = this.if_ce_warning;
      log.order_token = this.order_token;
      log.former_order_token = this.former_order_token;
      log.side = this.side;
      log.price = this.price;
      log.share = this.share;
      log.firm = this.firm;
      log.ff_value = this.ff_value;
      log.co_value = this.co_value;
      log.ce_value = this.ce_value;
      log.source_ip = this.source_ip;
      log.source_port = this.source_port;
      log.source_mac = this.source_mac;
      log.dest_ip = this.dest_ip;
      log.dest_port = this.dest_port;
      log.dest_mac = this.dest_mac;
      log.session_id = this.session_id;
      log.ff_limit = this.ff_limit;
      log.co_limit = this.co_limit;
      log.ce_limit = this.ce_limit;
      log.co_part_limit1 = this.co_part_limit1;
      log.co_part_limit2 = this.co_part_limit2;
      log.ce_part_limit1 = this.ce_part_limit1;
      log.ce_part_limit2 = this.ce_part_limit2;
      log.time_configured = this.time_configured;
      log.internal_timestamp = this.internal_timestamp;
      log.connector_timestamp = this.connector_timestamp;
      log.order_type = this.order_type;
      log.ouch_timestamp = this.ouch_timestamp;
      log.client_ref = this.client_ref;
      log.security_id = this.security_id;
      log.if_kill_switch = this.if_kill_switch;
      log.if_bypass = this.if_bypass;
      log.if_modify = this.if_modify;
      log.if_from_exchange = this.if_from_exchange;
      log.if_replay = this.if_replay;
      log.group_reason = this.group_reason;
      log.match_number = this.match_number;
      log.username = this.username;
      log.partition = this.partition;
      log.location = this.location;

      return log;
    }

  }
}

