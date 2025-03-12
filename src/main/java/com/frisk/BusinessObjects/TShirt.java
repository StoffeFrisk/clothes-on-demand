package com.frisk.BusinessObjects;

import com.frisk.Enums.*;

public class TShirt extends ClothingItem {

    private Sleeve sleeve;
    private Neck neck;

    public TShirt() {}

    public TShirt(int id, double price, String name, Size size, Material material, Colour colour, Sleeve sleeve, Neck neck) {
        super(1002, 399.90, "T-Shirt", size, material, colour);
        this.sleeve = sleeve;
        this.neck = neck;
    }

    public Sleeve getSleeve() {
        return sleeve;
    }

    public void setSleeve(Sleeve sleeve) {
        this.sleeve = sleeve;
    }

    public Neck getNeck() {
        return neck;
    }

    public void setNeck(Neck neck) {
        this.neck = neck;
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "sleeve=" + sleeve +
                ", neck=" + neck +
                '}';
    }
}