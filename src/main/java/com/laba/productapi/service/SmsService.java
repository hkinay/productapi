package com.laba.productapi.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Async
    public void sendSms(String phoneNumber, String message) {

        System.out.println("SMS gönderiliyor: " + message + " to " + phoneNumber);
        // SMS gönderme işlemi...
    }
}
