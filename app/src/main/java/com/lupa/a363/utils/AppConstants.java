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
        NONE,
        LEFT_BOTTOM,
        LEFT_CENTER,
        LEFT_TOP,
        TOP,
        RIGHT_BOTTOM,
        RIGHT_CENTER,
        RIGHT_TOP,
        BOTTOM
    }

    int COMPONENT_WIDTH = 100;
    int COMPONENT_HEIGHT = 100;
    int COMPONENT_FRAME = 50;
    int COMPONENT_PADDING = 10;

    int CONDUCTOR_WIDTH = 1;

    int BLANK_POINT_RADIUS = (int)((float)COMPONENT_WIDTH * 0.06);

    int CONTACT_OPENING_WIDTH = (int)((float)COMPONENT_WIDTH * 0.1);
    int CONTACT_LENGTH = (int)((float)COMPONENT_WIDTH * 0.5);
    int CONTACT_PIN_LABEL_SIZE = (int)((float)COMPONENT_WIDTH * 0.1);
}
