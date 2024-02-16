package com.example.fcm.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class PushNotificationModel {

    String title;
    String body;

    Map<String, String> data;

    String deviceToken;
}
