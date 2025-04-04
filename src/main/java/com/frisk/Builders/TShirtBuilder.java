package com.frisk.Builders;

import com.frisk.BusinessObjects.TShirt;
import com.frisk.Enums.*;

public class TShirtBuilder extends ClothingBuilder {

    private Sleeve sleeve;
    private Neck neck;

    public TShirtBuilder setSleeve(Sleeve sleeve) {
        this.sleeve = sleeve;
        return this;
    }

    public TShirtBuilder setNeck(Neck neck) {
        this.neck = neck;
        return this;
    }

    public TShirt build() {
        return new TShirt(id, price, name, size, material, colour, sleeve, neck);
    }
}