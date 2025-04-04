package com.frisk.Commands;

import com.frisk.BusinessObjects.ClothingItem;
import com.frisk.BusinessObjects.Pants;
import com.frisk.Enums.Length;

public class LeangthCommand implements Command {

    private final Length length;

    public LeangthCommand(Length length) {
        this.length = length;
    }

    @Override
    public void execute(ClothingItem item) {
        if(item instanceof Pants) {
            Pants pants = (Pants) item;
            pants.setLength(length);
            System.out.println("Längd vald!: " + length);
        }else {
            System.out.println("Error!");
        }

    }
}
