package com.frisk.Builders;

import com.frisk.BusinessObjects.Pants;
import com.frisk.Enums.*;

public class PantsBuilder extends ClothingBuilder {

    private Fit fit;
    private Length length;

    public PantsBuilder setFit(Fit fit) {
        this.fit = fit;
        return this;
    }

    public PantsBuilder setLength(Length length) {
        this.length = length;
        return this;
    }

    public Pants build() {
        return new Pants(id, price, name, size, material, colour, fit, length);
    }
}