package com.frisk.BusinessObjects;

import com.frisk.Enums.Colour;
import com.frisk.Enums.Material;
import com.frisk.Enums.Size;

public class ClothingItem {

    private int id;
    private double price;
    private String name;
    private Size size;
    private Material material;
    private Colour colour;

    public ClothingItem() {
    }

    public ClothingItem(int id, double price, String name, Size size, Material material, Colour colour) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.size = size;
        this.material = material;
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public Material getMaterial() {
        return material;
    }

    public Colour getColour() {
        return colour;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return name + " (Size: " + size + ", Material: " + material + ", Colour: " + colour + ")";
    }
}