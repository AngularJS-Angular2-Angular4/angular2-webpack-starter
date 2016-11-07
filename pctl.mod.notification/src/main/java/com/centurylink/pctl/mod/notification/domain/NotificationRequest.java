package com.centurylink.pctl.mod.notification.domain;

/**
 * NotificationRequest class
 * @author pulapakas.
 */
public class NotificationRequest {

    /**
     * messageNotification of NotificationRequest
     */
    private Notification messageNotification;

    /**
     * emailNotification of NotificationRequest
     */
    private Notification emailNotification;

    /**
     *  no- args constructor of NotificationRequest
     */
    public NotificationRequest() {
    }

    /**
     * emailNotification and messageNotification in NotificationRequest
     * @param messageNotification
     * @param emailNotification
     */
    public NotificationRequest(Notification messageNotification, Notification emailNotification) {
        this.emailNotification = messageNotification;
        this.messageNotification = messageNotification;
    }

    /**
     * emailNotification in NotificationRequest
     * @return emailNotification
     */
    public Notification getEmailNotification() {
        return emailNotification;
    }

    /**
     * set method for emailNotification
     * @param emailNotification
     */
    public void setEmailNotification(Notification emailNotification) {
        this.emailNotification = emailNotification;
    }

    /**
     *  messageNotification in NotificationRequest
     * @return messageNotification
     */
    public Notification getMessageNotification() {
        return messageNotification;
    }

    /**
     * set method for messageNotification in NotificationRequest
     * @param messageNotification
     */
    public void setMessageNotification(Notification messageNotification) {
        this.messageNotification = messageNotification;
    }
}
