package com.frisk.Enums;

public enum Length {
    LENGTH_100(100), LENGTH_110(110), LENGTH_120(120);

    private final int value;

    Length(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
