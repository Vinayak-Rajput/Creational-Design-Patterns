package com.example.creation.FactoryMethod.ConcreteCreator;

import com.example.creation.FactoryMethod.ProductInterface.Notification;

public class EmailNotification implements Notification {
    @Override
    public void send(){
        System.out.println("Notification send via Email.");
    }
}
