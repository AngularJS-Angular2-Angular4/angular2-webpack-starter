package com.centurylink.pctl.mod.notification.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * NotificationRepository interface configured with notification table in database
 * @author  pulapakas
 */
@RepositoryRestResource(collectionResourceRel = "notification", path = "notification")
public interface NotificationRepository extends MongoRepository<Notification, String> {

    /**
     * configured with "entityId" data in database
     * @param entityId is input parameter
     * @return Notification list
     */
    @Query(value = "{ 'entityId' : ?0 }")
    public List<Notification> findNotificationByEntityId(String entityId);

    /**
     * configured with "deliveryType" data in database
     * @param deliveryType is input parameter
     * @return Notification list
     */
    @Query(value = "{ 'deliveryType' : ?0 }")
    public List<Notification> findNotificationByDeliveryType(String deliveryType);

}


