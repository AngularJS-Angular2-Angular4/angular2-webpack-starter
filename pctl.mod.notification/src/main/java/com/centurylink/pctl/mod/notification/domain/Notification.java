package com.centurylink.pctl.mod.notification.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Notification bean class
 * @author pulapakas
 */
@Document(collection = "notification")
public class Notification implements Serializable {

    /**
     * id of Notification
     */
    @Id
    private String _id;
    /**
     * subject of Notification
     */
    private String subject;
    /**
     * message of Notification
     */
    private String message;
    /**
     * email of Notification
     */
    private String email;
    /**
     * fromAddress of Notification
     */
    private String fromAddress;
    /**
     * toAddress of Notification
     */
    private List<String> toAddress;
    /**
     * notificationType of Notification
     */
    private EventType notificationType;
    /**
     * deliveryType of Notification
     */
    private String deliveryType;
    /**
     * CreatedDate of Notification
     */
    private String CreatedDate;
    /**
     * deliveryDate of Notification
     */
    private String deliveryDate;
    /**
     * deliveryStatus of Notification
     */
    private String deliveryStatus;
    /**
     * entityId of Notification
     */
    private String entityId;
    /**
     * emailId of Notification
     */
    private String emailId;
    /**
     * entityType of Notification
     */
    private String entityType;
    /**
     * constructor of Notification
     */

    public Notification() {
    }

    /**
     *  get method for email in Notification
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * set method for email in Notification
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *  entityId in Notification
     * @return entityId
     */
    public String getEntityId() {
        return entityId;
    }

    /**
     * set method for entityId in Notification
     * @param entityId
     */
    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
    /**
     *  entityType in Notification
     * @return entityType
     */
    public String getEntityType() {
        return entityType;
    }
    /**
     * set method for entityType in Notification
     * @param entityType
     */
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }
    /**
     *  id in Notification
     * @return id
     */
    public String get_id() {
        return _id;
    }
    /**
     * set method for id in Notification
     * @param _id
     */
    public void set_id(String _id) {
        this._id = _id;
    }
    /**
     *  deliveryStatus in Notification
     * @return deliveryStatus
     */
    public String getDeliveryStatus() {
        return deliveryStatus;
    }
    /**
     * set method for deliveryStatus in Notification
     * @param deliveryStatus
     */
    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    /**
     *  subject in Notification
     * @return subject
     */
    public String getSubject() {
        return subject;
    }
    /**
     * set method for subject in Notification
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    /**
     *  message in Notification
     * @return message
     */
    public String getMessage() {
        return message;
    }
    /**
     * set method for message in Notification
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     *  fromAddress in Notification
     * @return fromAddress
     */
    public String getFromAddress() {
        return fromAddress;
    }
    /**
     * set method for fromAddress in Notification
     * @param fromAddress
     */
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }
    /**
     *  toAddress in Notification
     * @return toAddress
     */
    public List<String> getToAddress() {
        return toAddress;
    }
    /**
     * set method for toAddress in Notification
     * @param toAddress
     */
    public void setToAddress(List<String> toAddress) {
        this.toAddress = toAddress;
    }
    /**
     *  notificationType in Notification
     * @return notificationType
     */
    public EventType getNotificationType() {
        return notificationType;
    }
    /**
     * set method for notificationType in Notification
     * @param notificationType
     */
    public void setNotificationType(EventType notificationType) {
        this.notificationType = notificationType;
    }
    /**
     *  deliveryType in Notification
     * @return deliveryType
     */
    public String getDeliveryType() {
        return deliveryType;
    }
    /**
     * set method for deliveryType in Notification
     * @param deliveryType
     */
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
    /**
     *  CreatedDate in Notification
     * @return CreatedDate
     */
    public String getCreatedDate() {
        return CreatedDate;
    }
    /**
     * set method for createdDate in Notification
     * @param createdDate
     */
    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }
    /**
     *  deliveryDate in Notification
     * @return deliveryDate
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }
    /**
     * set method for deliveryDate in Notification
     * @param deliveryDate
     */
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
