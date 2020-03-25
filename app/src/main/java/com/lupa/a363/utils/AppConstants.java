package com.lupa.a363.utils;

public interface AppConstants {

    String FRAGMENT_STATUS_DISPLAY = "FragmentStatusDisplay";
    String FRAGMENT_MAIN = "FragmentMain";
    String FRAGMENT_ITEM_STATUS_DETAIL = "FragmentItemStatusDetail";

    enum ComponentType {
        CT_RELAY,
        CT_CONTACTOR,
        CT_SWITCH
    }

    enum CircuitType {
        HIGH_VOLTAGE,
        LOW_VOLATEG
    }

    enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    enum Direction {
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

    enum ContactType {
        NORMAL,
        IDLE
    }

    //Měřítka pro výpočet rozměrů
    float SCALE_CONDUCTOR_WIDTH = 0.01f;            //Tloušťka vodiče
    float SCALE_BLANK_POINT_RADIUS = 0.04f;         //Poloměr prázdného kroužku
    float SCALE_BLANK_POINT_LINE_WIDTH = 2f;        //Tloušťka čáry kroužku
    float SCALE_NODE_RADIUS = 0.06f;                //Poloměr bodu uzlu
    float SCALE_COMPONENT_PADDING = 0.1f;           //Padding komponenty
    float SCALE_RELAY_BORDER_WIDTH = 3f;            //Tloušťka čáry kroužku

    //Rozměry komponenty - po hranách tohoto prostoru budou procházet propojovací vodiče
    int COMPONENT_WIDTH = 200;
    int COMPONENT_HEIGHT = 200;

    //Rámec kolem komponenty - prostor, kterým se všechny komponenty překrývají kvůli napojování
    int COMPONENT_FRAME = (int) ((float) COMPONENT_HEIGHT * 0.5);

    //Odsazení od hran, po kterých probíhají propojovací vodiče
    int COMPONENT_PADDING = (int) (COMPONENT_WIDTH * SCALE_COMPONENT_PADDING);

    //Šířka propojovacích vodičů
    int CONDUCTOR_WIDTH = (int) ((float) COMPONENT_WIDTH * SCALE_CONDUCTOR_WIDTH);

    //Poloměr prázdných kruhů (např. pro kontakty)
    int BLANK_POINT_RADIUS = (int) ((float) COMPONENT_WIDTH * SCALE_BLANK_POINT_RADIUS);

    //Tloušťka čáry prázdného kruhu
    int BLANK_POINT_LINE_WIDTH = (int) ((float) CONDUCTOR_WIDTH * SCALE_BLANK_POINT_LINE_WIDTH);

    //Poloměr bodu uzlu
    int NODE_POINT_RADIUS = (int) ((float) COMPONENT_WIDTH * SCALE_NODE_RADIUS);

    //Velikost otevření rozepnutého kontaktu
    int CONTACT_OPENING_WIDTH = (int) ((float) COMPONENT_WIDTH * 0.1);

    //Délka pohyblivé části kontaktu
    int CONTACT_LENGTH = (int) ((float) COMPONENT_WIDTH * 0.5);

    //Velikost textu pinů u kontaktu
    int CONTACT_PIN_LABEL_SIZE = (int) ((float) COMPONENT_WIDTH * 0.1);

    //Šířka obvodu relé
    int RELAY_BORDER_WIDTH = (int) ((float) CONDUCTOR_WIDTH * SCALE_RELAY_BORDER_WIDTH);
}
