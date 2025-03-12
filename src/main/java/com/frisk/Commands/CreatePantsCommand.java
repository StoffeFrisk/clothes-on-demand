package com.frisk.Commands;

import com.frisk.BusinessObjects.Pants;
import com.frisk.Enums.*;

public class CreatePantsCommand implements Command {

    private final Size size;
    private final Material material;
    private final Colour colour;
    private final Fit fit;
    private final Length length;

    public CreatePantsCommand(Size size, Material material, Colour colour, Fit fit, Length length) {
        this.size = size;
        this.material = material;
        this.colour = colour;
        this.fit = fit;
        this.length = length;
    }

    @Override
    public Pants execute() {
        return new Pants(1003, 599.50, "Pants", size, material, colour, fit, length);
    }
}