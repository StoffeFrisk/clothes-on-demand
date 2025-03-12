package com.frisk.Enums;

public enum Waist {
    WAIST_80(80), WAIST_90(90), WAIST_100(100);

    private final int value;

    Waist(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
