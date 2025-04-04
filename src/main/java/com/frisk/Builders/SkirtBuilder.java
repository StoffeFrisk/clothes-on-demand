package com.frisk.Builders;

import com.frisk.BusinessObjects.Skirt;
import com.frisk.Enums.Pattern;
import com.frisk.Enums.Waist;

public class SkirtBuilder extends ClothingBuilder {

    private Waist waist;
    private Pattern pattern;

    public SkirtBuilder setWaist(Waist waist) {
        this.waist = waist;
        return this;
    }

    public SkirtBuilder setPattern(Pattern pattern) {
        this.pattern = pattern;
        return this;
    }

    public Skirt build() {
        return new Skirt(id, price, name, size, material, colour, waist, pattern);
    }
}