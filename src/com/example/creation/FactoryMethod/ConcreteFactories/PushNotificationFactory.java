package com.example.creation.FactoryMethod.ConcreteFactories;

import com.example.creation.FactoryMethod.ProductInterface.Notification;
import com.example.creation.FactoryMethod.CreatorFactory.NotificationFactory;
import com.example.creation.FactoryMethod.ConcreteCreator.PushNotification;

public class PushNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}
