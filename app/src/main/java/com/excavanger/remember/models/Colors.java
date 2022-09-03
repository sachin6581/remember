package com.excavanger.remember.models;

public enum Colors {
    RED("c62828"),
    PINK("ad1457"),
    PURPLE("6a1b9a"),
    DEEP_PURPLE("4527a0"),
    ORANGE("ef6c00"),
    DEEP_ORANGE("d84315")
    ;

    private final String hexValue;

    Colors(String s) {
        this.hexValue = s;
    }

    public String getHexValue() {
        return hexValue;
    }
}
