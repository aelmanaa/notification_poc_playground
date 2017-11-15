package com.sbibits.ptrc.kafka.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sbibits.ptrc.kafka.model.entity.NotifyConfigEntity;
import com.sbibits.ptrc.kafka.model.entity.NotifyConfigEntity.NotificationType;

@Repository
public class NotifyConfigDao {

  @PersistenceContext
  private EntityManager em;

  @Transactional
  public NotifyConfigEntity create(String brokerId, String username,
      NotificationType type) {
    NotifyConfigEntity config =
        new NotifyConfigEntity(brokerId, username, type);

    this.em.persist(config);
    return config;
  }

  public NotifyConfigEntity find(String id) {
    return this.em.find(NotifyConfigEntity.class, id);
  }

  public List<NotifyConfigEntity> getAll() {
    return this.em.createNamedQuery(NotifyConfigEntity.FIND_ALL_QUERY)
        .getResultList();
  }

}
