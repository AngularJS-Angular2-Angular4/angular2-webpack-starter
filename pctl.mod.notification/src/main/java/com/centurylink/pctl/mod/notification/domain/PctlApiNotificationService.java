package com.centurylink.pctl.mod.notification.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class PctlApiNotificationService is a service class for PctlApiNotificationRestController.
 * <br>This class PctlApiNotificationService makes a call to the NotificationRepository class methods.
 * @author pulapakas
 */
@Service
public class PctlApiNotificationService {
    private final Logger log = LoggerFactory.getLogger(PctlApiNotificationService.class);


    @Autowired
    private NotificationRepository notificationRepository;

    /**
     * This findNotificationByEntityId() method accepts entityId as input and returns respective Notification Lists from database.
     * This findNotificationByEntityId() method calls notificationRepository classes findNotificationByEntityId () method
     * @param entityId, available entityId from database
     * @return Notification list , returns respective List of Notification for the given entityId available in database
     */
    public List<Notification> findNotificationByEntityId(String entityId) {
        return notificationRepository.findNotificationByEntityId(entityId);
    }

    /**
     *
     * This findAll() method calls notificationRepository classes findAll () method and fetches all available Notification from database
     * @return Notification list, returns all available Notification list from database.
     */
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    /**
     *
     * This findAll() method calls notificationRepository classes findAll () method and fetches all available Notification from database
     * @return Notification list, returns all available Notification list from database.
     */
    public List<Notification> findAllNotification() {
        return notificationRepository.findAll();
    }

    /**
     * This findNotificationByDeliveryType() method accepts deliveryType as input and returns respective Notification Lists from database.
     * This findNotificationByDeliveryType() method calls notificationRepository classes findNotificationByDeliveryType () method
     * @param deliveryType, available deliveryType from database
     * @return Notification list , returns respective List of Notification for the given deliveryType available in database
     */
    public List<Notification> findNotificationByDeliveryType(String deliveryType) {
        log.info("findNotificationByDeliveryType" + deliveryType);
        return notificationRepository.findNotificationByDeliveryType(deliveryType);
    }
}
