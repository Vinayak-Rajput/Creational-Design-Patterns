package com.example.creation.FactoryMethod.ConcreteCreator;

import com.example.creation.FactoryMethod.ProductInterface.Notification;

public class PushNotification implements Notification {
    @Override
    public void send(){
        System.out.println("Notification via push.");
    }
}
