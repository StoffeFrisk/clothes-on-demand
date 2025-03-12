package com.frisk.Commands;

import com.frisk.BusinessObjects.TShirt;
import com.frisk.Enums.*;

public class CreateTShirtCommand implements Command {

    private final Size size;
    private final Material material;
    private final Colour colour;
    private final Sleeve sleeve;
    private final Neck neck;

    public CreateTShirtCommand(Size size, Material material, Colour colour, Sleeve sleeve, Neck neck) {
        this.size = size;
        this.material = material;
        this.colour = colour;
        this.sleeve = sleeve;
        this.neck = neck;
    }

    @Override
    public TShirt execute() {
        return new TShirt(1002, 399.90, "T-Shirt", size, material, colour, sleeve, neck);
    }
}