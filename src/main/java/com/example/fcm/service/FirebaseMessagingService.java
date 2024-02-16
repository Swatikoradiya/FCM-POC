package com.example.fcm.service;

import com.example.fcm.model.PushNotificationModel;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.stereotype.Service;

@Service
public interface FirebaseMessagingService {
    public String sendNotification(PushNotificationModel pushNotificationModel) throws FirebaseMessagingException;
}
