package com.example.fcm.controller;

import com.example.fcm.model.PushNotificationModel;
import com.example.fcm.service.FirebaseMessagingService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fcm")
public class PushNotificationController {

    @Autowired
    FirebaseMessagingService firebaseMessagingService;

    @PostMapping("/send")
    public Object sendFcmNotification(@RequestBody PushNotificationModel pushNotificationModel){
        try {
            return firebaseMessagingService.sendNotification(pushNotificationModel);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
        return "Something went wrong";
    }
}
