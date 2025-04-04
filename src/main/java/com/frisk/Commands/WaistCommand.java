package com.frisk.Commands;

import com.frisk.BusinessObjects.Skirt;
import com.frisk.Enums.Waist;
import com.frisk.BusinessObjects.ClothingItem;

public class WaistCommand implements Command {

    private final Waist waist;

    public WaistCommand(Waist waist) {
        this.waist = waist;
    }

    @Override
    public void execute(ClothingItem item) {
        if (item instanceof Skirt) {
            Skirt skirt = (Skirt) item;
            skirt.setWaist(waist);
            System.out.println("Waist vald!: " + waist);
        } else {
            System.out.println("Error!");
        }
    }
}
