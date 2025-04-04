package com.frisk.Commands;

import com.frisk.BusinessObjects.ClothingItem;
import com.frisk.BusinessObjects.TShirt;
import com.frisk.Enums.Sleeve;

public class SleeveCommand implements Command {

    private final Sleeve sleeve;

    public SleeveCommand(Sleeve sleeve) {
        this.sleeve = sleeve;
    }

    @Override
    public void execute(ClothingItem item) {
        if (item instanceof TShirt) {
            TShirt tShirt = (TShirt) item;
            tShirt.setSleeve(sleeve);
            System.out.println("Sleeve vald!: " + sleeve);
        } else {
            throw new IllegalArgumentException("Error!");
        }
    }
}
