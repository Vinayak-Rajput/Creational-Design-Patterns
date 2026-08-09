package com.example.creation.AbstractFactory.ConcreteFactories;

import com.example.creation.AbstractFactory.ConcreteFamilies.WinButton;
import com.example.creation.AbstractFactory.ConcreteFamilies.WinCheckBox;
import com.example.creation.AbstractFactory.FactoryInterface.UIFactory;
import com.example.creation.AbstractFactory.ProductInterfaces.Button;
import com.example.creation.AbstractFactory.ProductInterfaces.CheckBox;

public class WinUIFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WinCheckBox();
    }

}
