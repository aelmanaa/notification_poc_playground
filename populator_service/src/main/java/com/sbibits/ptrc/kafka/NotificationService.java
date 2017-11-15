package com.sbibits.ptrc.kafka;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbibits.ptrc.kafka.model.NotifyConfigDao;
import com.sbibits.ptrc.kafka.model.entity.NotifyConfigEntity;
import com.sbibits.ptrc.kafka.producer.NotifyConfigSender;

@Component("NotificationService")
@Transactional
@RestController
@RequestMapping("/notification")
public class NotificationService {

  static final Logger LOGGER =
      LoggerFactory.getLogger(NotificationService.class);

  // @Autowired
  // private BrokerDao brokerDao;

  @Autowired
  private NotifyConfigDao notifyConfigDao;

  @Autowired
  private NotifyConfigSender sender;

  @RequestMapping(method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<NotifyConfigEntity> getAllConfigs() {
    return this.notifyConfigDao.getAll();
  }

  @RequestMapping(path = "/populate", method = RequestMethod.GET)
  public void populate() {
    this.getAllConfigs().stream().forEach(c -> {
      this.sender.send(c);
    });
  }

  @RequestMapping(path = "/{id}/populate", method = RequestMethod.GET)
  public void populate(String id) {
    this.sender.send(this.notifyConfigDao.find(id));
  }

  @RequestMapping(path = "/remove", method = RequestMethod.GET)
  public void remove() {
    LOGGER.info("Removing all configs from topic.");
    this.getAllConfigs().stream().map(b -> b.getBrokerId()).forEach(id -> {
      this.remove(id);
    });
  }

  @RequestMapping(path = "/{id}/remove", method = RequestMethod.GET)
  public void remove(@PathVariable("id") String id) {
    LOGGER.info(String.format("Removing [%s] from topic.", id));
    this.sender.overwriteWithNull(id);
  }

  @RequestMapping(path = "/help", method = RequestMethod.GET)
  public ResponseEntity<String> serviceHelp() {
    return ResponseEntity.status(HttpStatus.OK)
        .contentType(MediaType.TEXT_PLAIN)
        .body("Notification config service API:\n" + "base endpoint:\n"
            + "/notification - return all notification configs in db\n"
            + "sub endpoints:\n"
            + "\t/{id} - returns the notification config with the specified ID\n"
            + "\t/populate - populates kafka topic with all notification config info existing in db\n"
            + "\t/{id}/populate - populate kafka topic with notification config with specified id\n"
            + "\t/remove - remove all notification configs from kafka topic\n"
            + "\t/{id}/remove - Remove notification config with specified id from topic\n");
  }

  // @RequestMapping(path = "/generate", method = RequestMethod.GET)
  public void generateConfigs() {
    // NotificationType types[] =
    // {NotificationType.EMAIL, NotificationType.PUSH, NotificationType.SMS};
    // String names[] = {"Jon", "Slow", "Private", "Big", "Peter", "High", "Frodo",
    // "Jennifer", "Gonzo", "Christoph"};
    // String surnames[] = {"Schmidt", "Gonzalez", "Garcia", "Peterson", "Snow",
    // "Beutlin", "Five", "Impact", "Thinker", "Dancer"};
    // Random rand = new Random();
    //
    // this.brokerDao.getAll().stream().map(b -> b.getBrokerId()).forEach(id -> {
    // String name = new StringJoiner(" ").add(names[rand.nextInt(names.length)])
    // .add(surnames[rand.nextInt(surnames.length)]).toString();
    // NotificationType type = types[rand.nextInt(types.length)];
    // this.notifyConfigDao.create(id, name, type);
    // });
  }

}
