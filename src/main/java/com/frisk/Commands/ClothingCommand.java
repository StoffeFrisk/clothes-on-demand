package com.frisk.Commands;

import com.frisk.BusinessObjects.ClothingItem;
import com.frisk.Commands.Command;

public class ClothingCommand {

    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public ClothingItem executeCommand(){
        if(command == null){
            throw new IllegalStateException("Inget commando satt");
        }
        return command.execute();
    }
}
