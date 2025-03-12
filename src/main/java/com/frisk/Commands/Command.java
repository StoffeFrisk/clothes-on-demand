package com.frisk.Commands;

import com.frisk.BusinessObjects.ClothingItem;

public interface Command {
    ClothingItem execute();
}