package com.centurylink.pctl.mod.notification.domain;



import com.centurylink.pctl.mod.core.utils.Response;

import java.util.List;

/**
 * @author pulapakas
 */
public class NotificationResponse {
    /**
     * messageNotification in NotificationResponse
     */
    public Response<Notification> messageNotification;
    /**
     * emailNotification in NotificationResponse
     */
    public Response<Notification> emailNotification;
    /**
     * response in NotificationResponse
     */
    List<Notification> response;

    /**
     *  Notification list response in NotificationResponse
     * @return messageNotification
     */
    public Response<Notification> getMessageNotification() {
        return messageNotification;
    }

    /**
     *  set method Notification list response in NotificationResponse
     * @param messageNotification
     */
    public void setMessageNotification(Response<Notification> messageNotification) {
        this.messageNotification = messageNotification;
    }

    /**
     * emailNotification in NotificationResponse
     * @return emailNotification
     */
    public Response<Notification> getEmailNotification() {
        return emailNotification;
    }

    /**
     * set method for emailNotification in NotificationResponse
     * @param emailNotification
     */
    public void setEmailNotification(Response<Notification> emailNotification) {
        this.emailNotification = emailNotification;
    }

    /**
     * list of notification in NotificationResponse
     * @return
     */
    public List<Notification> getResponse() {
        return response;
    }

    /**
     * set method for NotificationResponse
     * @param response
     */
    public void setResponse(List<Notification> response) {
        this.response = response;
    }


}
