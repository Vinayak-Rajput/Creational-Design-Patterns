package com.example.creation.FactoryMethod.ConcreteFactories;

import com.example.creation.FactoryMethod.ProductInterface.Notification;
import com.example.creation.FactoryMethod.CreatorFactory.NotificationFactory;
import com.example.creation.FactoryMethod.ConcreteCreator.SMSNotification;

public class SMSNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
