package com.frisk.Commands;

import com.frisk.BusinessObjects.ClothingItem;
import com.frisk.Enums.*;

public class ClothingFactory {

    public static ClothingItem createSkirt(Size size, Material material, Colour colour, Waist waist, Pattern pattern) {
        ClothingCommand invoker = new ClothingCommand();
        Command command = new CreateSkirtCommand(size, material, colour, waist, pattern);
        invoker.setCommand(command);
        return invoker.executeCommand();
    }

    public static ClothingItem createPants(Size size, Material material, Colour colour, Fit fit, Length length) {
        ClothingCommand invoker = new ClothingCommand();
        Command command = new CreatePantsCommand(size, material, colour, fit, length);
        invoker.setCommand(command);
        return invoker.executeCommand();
    }

    public static ClothingItem createTShirt(Size size, Material material, Colour colour, Sleeve sleeve, Neck neck) {
        ClothingCommand invoker = new ClothingCommand();
        Command command = new CreateTShirtCommand(size, material, colour, sleeve, neck);
        invoker.setCommand(command);
        return invoker.executeCommand();
    }
}