package com.frisk.Commands;

import com.frisk.BusinessObjects.ClothingItem;
import com.frisk.BusinessObjects.Pants;
import com.frisk.Enums.Fit;

public class FitCommand implements Command {

    private final Fit fit;

    public FitCommand(Fit fit) {
        this.fit = fit;
    }

    @Override
    public void execute(ClothingItem item) {
        if (item instanceof Pants) {
            Pants pants = (Pants) item;
            pants.setFit(fit);
            System.out.println("Fit vald!: " + fit);
        } else {
            throw new IllegalArgumentException("Error!");
        }
    }
}