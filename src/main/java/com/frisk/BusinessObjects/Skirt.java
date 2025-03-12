package com.frisk.BusinessObjects;

import com.frisk.Enums.*;

public class Skirt extends ClothingItem {

    private Waist waist;
    private Pattern pattern;

    public Skirt() {}

    public Skirt(int id, double price, String name, Size size, Material material, Colour colour, Waist waist, Pattern pattern) {
        super(1001, 299.95, "Skirt", size, material, colour);
        this.waist = waist;
        this.pattern = pattern;
    }

    public Waist getWaist() {
        return waist;
    }

    public void setWaist(Waist waist) {
        this.waist = waist;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "Skirt{" +
                "waist=" + waist +
                ", pattern=" + pattern +
                '}';
    }
}
