package com.frisk.Commands;

import com.frisk.BusinessObjects.ClothingItem;
import com.frisk.BusinessObjects.Skirt;
import com.frisk.Enums.Pattern;

public class PatternCommand implements Command {

    private final Pattern pattern;

    public PatternCommand(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public void execute(ClothingItem item) {
        if (item instanceof Skirt) {
            Skirt skirt = (Skirt) item;
            skirt.setPattern(pattern);
            System.out.println("Mönster vald!: " + pattern);
        } else {
            System.out.println("Error!");
        }
    }
}