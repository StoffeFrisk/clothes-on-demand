package com.frisk.Builders;

import com.frisk.Enums.*;

public class ClothingBuilder {

    protected int id;
    protected double price;
    protected String name;
    protected Size size;
    protected Material material;
    protected Colour colour;


    public ClothingBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ClothingBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public ClothingBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ClothingBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

    public ClothingBuilder setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public ClothingBuilder setColour(Colour colour) {
        this.colour = colour;
        return this;
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
}