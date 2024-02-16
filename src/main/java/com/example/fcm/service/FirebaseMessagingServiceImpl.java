package com.example.fcm.service;

import com.example.fcm.model.PushNotificationModel;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingServiceImpl implements FirebaseMessagingService {

    private final FirebaseMessaging firebaseMessaging;

    public FirebaseMessagingServiceImpl(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    public String sendNotification(PushNotificationModel pushNotificationModel) throws FirebaseMessagingException {

        Notification notification = Notification
                .builder()
                .setTitle(pushNotificationModel.getTitle())
                .setBody(pushNotificationModel.getBody())
                .build();

        Message message = Message
                .builder()
                .setToken(pushNotificationModel.getDeviceToken())
                .setNotification(notification)
                .putAllData(pushNotificationModel.getData())
                .build();

        return firebaseMessaging.send(message);
    }

}
