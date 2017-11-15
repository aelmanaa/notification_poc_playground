package com.sbibits.ptrc.kafka.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sbibits.ptrc.kafka.model.entity.BrokerEntity;

@Repository
public class BrokerDao {

  @PersistenceContext
  private EntityManager em;

  @Transactional
  public BrokerEntity create(String brokerName, int partitions) {
    BrokerEntity broker = new BrokerEntity(brokerName, partitions);

    this.em.persist(broker);
    return broker;
  }

  public BrokerEntity find(String id) {
    return this.em.find(BrokerEntity.class, id);
  }

  public List<BrokerEntity> getAll() {
    return this.em.createNamedQuery(BrokerEntity.FIND_ALL_QUERY)
        .getResultList();
  }

}
