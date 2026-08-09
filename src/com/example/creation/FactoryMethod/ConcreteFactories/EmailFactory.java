package com.example.creation.FactoryMethod.ConcreteFactories;

import com.example.creation.FactoryMethod.ConcreteCreator.EmailNotification;
import com.example.creation.FactoryMethod.ProductInterface.Notification;
import com.example.creation.FactoryMethod.CreatorFactory.NotificationFactory;

public class EmailFactory implements NotificationFactory {
    @Override
    public Notification createNotification(){
        return new EmailNotification();
    }
}
