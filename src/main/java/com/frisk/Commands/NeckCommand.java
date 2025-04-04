package com.frisk.Commands;

import com.frisk.BusinessObjects.ClothingItem;
import com.frisk.BusinessObjects.TShirt;
import com.frisk.Enums.Neck;

public class NeckCommand implements Command {

    private final Neck neck;

    public NeckCommand(Neck neck) {
        this.neck = neck;
    }

    @Override
    public void execute(ClothingItem item) {
        if (item instanceof TShirt) {
            TShirt tShirt = (TShirt) item;
            tShirt.setNeck(neck);
            System.out.println("Neck vald!: " + neck);
        } else {
            throw new IllegalArgumentException("Error!");
        }
    }
}