package com.example.creation.AbstractFactory.ConcreteFactories;

import com.example.creation.AbstractFactory.ConcreteFamilies.MacButton;
import com.example.creation.AbstractFactory.ConcreteFamilies.MacCheckBox;
import com.example.creation.AbstractFactory.FactoryInterface.UIFactory;
import com.example.creation.AbstractFactory.ProductInterfaces.Button;
import com.example.creation.AbstractFactory.ProductInterfaces.CheckBox;

public class MacUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
