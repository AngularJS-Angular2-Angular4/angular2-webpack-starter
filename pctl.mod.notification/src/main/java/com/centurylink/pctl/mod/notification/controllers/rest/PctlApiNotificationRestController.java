package com.centurylink.pctl.mod.notification.controllers.rest;


import com.centurylink.pctl.mod.core.utils.Response;
import com.centurylink.pctl.mod.core.utils.StatusCode;
import com.centurylink.pctl.mod.notification.domain.Notification;
import com.centurylink.pctl.mod.notification.domain.NotificationResponse;
import com.centurylink.pctl.mod.notification.domain.PctlApiNotificationService;
import com.centurylink.pctl.mod.notification.domain.utils.DeliveryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * PctlApiNotificationRestController is a controller class configured using SpringMVC concept
 * uses @RequestMapping as "/notification/{type}"
 * <br> PctlApiNotificationRestController class Contains one method
 *  <br>    - notificationType()
 *
 * @author srinivas
 */

@Transactional
@RestController
@RequestMapping("/notification")
public class PctlApiNotificationRestController {


    private static final Logger log = LoggerFactory.getLogger(PctlApiNotificationRestController.class);

    /**
     * PctlApiNotificationService is autowired to make service call to NotificationRepository
     */
    @Autowired
    private PctlApiNotificationService pctlApiNotificationService;
    /**
     * notificationType() identifies whether email or message or any other delivery type
     * If deliveryType is null, notificationType() method will set status as N401
     * notificationType() method configured for @RequestMapping as  "/{type}"
     * @param type, Either email or message type has to be given as input parameter in url.
     * @return NotificationResponse is response object
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{type}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Response<NotificationResponse>> notificationType(@PathVariable String type) {
        Response<NotificationResponse> responseList = new Response<NotificationResponse>();
        DeliveryType deliveryType = DeliveryType.getValueOf(type);
        if (deliveryType == null) {
            responseList.setStatus(StatusCode.N401);
            return new ResponseEntity<Response<NotificationResponse>>(responseList, HttpStatus.BAD_REQUEST);
        }
        List<Notification> response = pctlApiNotificationService.findNotificationByDeliveryType(deliveryType.name());
        NotificationResponse notResponse = new NotificationResponse();
        notResponse.setResponse(response);
        responseList.setContent(notResponse);
        responseList.setStatus(StatusCode.E200);
        return new ResponseEntity<Response<NotificationResponse>>(responseList, HttpStatus.OK);
    }


}



