package com.frisk.Commands;

import com.frisk.BusinessObjects.Skirt;
import com.frisk.Enums.*;

public class CreateSkirtCommand implements Command {

    private final Size size;
    private final Material material;
    private final Colour colour;
    private final Waist waist;
    private final Pattern pattern;

    public CreateSkirtCommand(Size size, Material material, Colour colour, Waist waist, Pattern pattern) {
        this.size = size;
        this.material = material;
        this.colour = colour;
        this.waist = waist;
        this.pattern = pattern;
    }

    @Override
    public Skirt execute() {
        return new Skirt(1001, 299.95, "Skirt", size, material, colour, waist, pattern);
    }
}