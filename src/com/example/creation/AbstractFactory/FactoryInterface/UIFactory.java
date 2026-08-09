package com.example.creation.AbstractFactory.FactoryInterface;

import com.example.creation.AbstractFactory.ProductInterfaces.Button;
import com.example.creation.AbstractFactory.ProductInterfaces.CheckBox;

public interface UIFactory {
    Button createButton();
    CheckBox createCheckBox();
}
