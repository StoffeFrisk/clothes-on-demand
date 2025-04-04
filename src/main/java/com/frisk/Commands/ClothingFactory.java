package com.frisk.Commands;

import com.frisk.Builders.ClothingBuilder;
import com.frisk.BusinessObjects.Pants;
import com.frisk.BusinessObjects.Skirt;
import com.frisk.BusinessObjects.TShirt;
import com.frisk.Enums.*;

public class ClothingFactory {

    public static Skirt createSkirt(ClothingBuilder builder, Waist waist, Pattern pattern) {
        Skirt skirt = new Skirt();

        skirt.setId(builder.getId());
        skirt.setName(builder.getName());
        skirt.setPrice(builder.getPrice());
        skirt.setSize(builder.getSize());
        skirt.setMaterial(builder.getMaterial());
        skirt.setColour(builder.getColour());

        CommandPipeline pipeline = new CommandPipeline();
        pipeline.addCommand(new WaistCommand(waist));
        pipeline.addCommand(new PatternCommand(pattern));
        pipeline.executeCommands(skirt);

        return skirt;
    }

    public static Pants createPants(ClothingBuilder builder, Fit fit, Length length) {
        Pants pants = new Pants();

        pants.setId(builder.getId());
        pants.setName(builder.getName());
        pants.setPrice(builder.getPrice());
        pants.setSize(builder.getSize());
        pants.setMaterial(builder.getMaterial());
        pants.setColour(builder.getColour());

        CommandPipeline pipeline = new CommandPipeline();
        pipeline.addCommand(new FitCommand(fit));
        pipeline.addCommand(new LengthCommand(length));
        pipeline.executeCommands(pants);

        return pants;
    }

    public static TShirt createTShirt(ClothingBuilder builder, Sleeve sleeve, Neck neck) {
        TShirt tShirt = new TShirt();

        tShirt.setId(builder.getId());
        tShirt.setName(builder.getName());
        tShirt.setPrice(builder.getPrice());
        tShirt.setSize(builder.getSize());
        tShirt.setMaterial(builder.getMaterial());
        tShirt.setColour(builder.getColour());

        CommandPipeline pipeline = new CommandPipeline();
        pipeline.addCommand(new SleeveCommand(sleeve));
        pipeline.addCommand(new NeckCommand(neck));
        pipeline.executeCommands(tShirt);

        return tShirt;
    }
}