package com.lupa.a363.utils;

public interface AppConstants {

    enum ComponentType {
        CT_RELAY,
        CT_CONTACTOR,
        CT_SWITCH
    };

    enum CircuitType {
        HIGH_VOLTAGE,
        LOW_VOLATEG
    }

    enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    enum Direction{
        LEFT_BOTTOM,
        LEFT_CENTER,
        LEFT_TOP,
        TOP,
        RIGHT_BOTTOM,
        RIGHT_CENTER,
        RIGHT_TOP,
        BOTTOM
    }
}
