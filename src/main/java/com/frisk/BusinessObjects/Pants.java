package com.frisk.BusinessObjects;

import com.frisk.Enums.*;

public class Pants extends ClothingItem {

    private Fit fit;
    private Length length;

    public Pants() {
        super();
    }

    public Pants(int id, double price, String name, Size size, Material material, Colour colour, Fit fit, Length length) {
        super(1003, 599.50, "Pants", size, material, colour);
        this.fit = fit;
        this.length = length;
    }

    public Fit getFit() {
        return fit;
    }

    public void setFit(Fit fit) {
        this.fit = fit;
    }

    public Length getLength() {
        return length;
    }

    public void setLength(Length length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Pants{" +
                "fit=" + fit +
                ", length=" + length +
                '}';
    }
}