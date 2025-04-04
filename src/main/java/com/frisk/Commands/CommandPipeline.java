package com.frisk.Commands;

import com.frisk.BusinessObjects.ClothingItem;

import java.util.ArrayList;
import java.util.List;

public class CommandPipeline {

    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommands(ClothingItem clothingItem) {
        for (Command command : commands) {
            command.execute(clothingItem);
        }
    }

    public void clearCommands() {
        commands.clear();
    }
}
