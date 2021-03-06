package com.lupa.a363.utils;

public interface AppConstants {

    String FRAGMENT_STATUS_DISPLAY = "FragmentStatusDisplay";
    String FRAGMENT_MAIN = "FragmentMain";
    String FRAGMENT_ITEM_STATUS_DETAIL = "FragmentItemStatusDetail";

    int SERIES_1 = 1;   //003 - 012
    int SERIES_2 = 2;   //013 - 042
    int SERIES_3 = 3;   //043 - 082
    int SERIES_4 = 4;   //083 - 147
    int SERIES_5 = 5;   //148 - 181

    String PREFS_NAME = "prefs_363";
    String PREFS_SERIES_NAME = "series";

    enum ComponentType {
        CT_RELAY,
        CT_CONTACTOR,
        CT_SWITCH
    }

    enum CircuitType {
        HIGH_VOLTAGE,
        LOW_VOLATEG
    }

    enum Side {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
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
        IDLE,
        BREAKER
    }

    //Měřítka pro výpočet rozměrů
    float SCALE_CONDUCTOR_WIDTH = 0.01f;            //Tloušťka vodiče
    float SCALE_BLANK_POINT_RADIUS = 0.04f;         //Poloměr prázdného kroužku
    float SCALE_BLANK_POINT_LINE_WIDTH = 1f;        //Tloušťka čáry kroužku
    float SCALE_NODE_RADIUS = 0.06f;                //Poloměr bodu uzlu
    float SCALE_TIME_RELAY_WIDTH = 0.9f;            //Šířka časového relé
    float SCALE_TIME_RELAY_HEIGHT = 0.25f;          //Výška časového relé (poměr jeho výšky)
    float SCALE_COMPONENT_PADDING = 0.1f;           //Padding komponenty
    float SCALE_RELAY_BORDER_WIDTH = 3f;            //Tloušťka čáry kroužku
    float SCALE_BREAKER_RECT_WIDTH = 0.3f;          //Kostička na kontaktu jističe - délka
    float SCALE_BREAKER_RECT_HEIGHT = 0.3f;         //Kostička na kontaktu jističe - výška

    //Rozměry komponenty - po hranách tohoto prostoru budou procházet propojovací vodiče
    float COMPONENT_WIDTH = 500f;
    float COMPONENT_HEIGHT = 500f;

    //Rámec kolem komponenty - prostor, kterým se všechny komponenty překrývají kvůli napojování
    int COMPONENT_FRAME = (int) ((float) COMPONENT_HEIGHT * 0.5);

    //Odsazení od hran, po kterých probíhají propojovací vodiče
    int COMPONENT_PADDING = (int) (COMPONENT_WIDTH * SCALE_COMPONENT_PADDING);

    //Šířka propojovacích vodičů
    int CONDUCTOR_WIDTH = (int) ((float) COMPONENT_WIDTH * SCALE_CONDUCTOR_WIDTH);

    //Délka pohyblivé části kontaktu
    float CONTACT_LENGTH = 80;

    //Otevření kontaktu ve stupních
    float CONTACT_OPENING = -15f;

    //Velikost textu pinů u kontaktu
    int CONTACT_PIN_LABEL_SIZE = (int) ((float) COMPONENT_WIDTH * 0.1);

    //Poloměr prázdných kruhů (např. pro kontakty)
    float BLANK_POINT_RADIUS = 10;

    //Tloušťka čáry prázdného kruhu
    int BLANK_POINT_LINE_WIDTH = (int) ((float) CONDUCTOR_WIDTH * SCALE_BLANK_POINT_LINE_WIDTH);

    //Poloměr bodu uzlu
    int NODE_POINT_RADIUS = (int) ((float) COMPONENT_WIDTH * SCALE_NODE_RADIUS);

    //Šířka časového relé
    int TIME_REALAY_WIDTH = (int) (CONTACT_LENGTH * 4);

    //Výška časového relé
    int TIME_REALAY_HEIGHT = (int) (TIME_REALAY_WIDTH * SCALE_TIME_RELAY_HEIGHT);

    //Velikost otevření rozepnutého kontaktu
    //float CONTACT_OPENING_WIDTH = (int) ((float) COMPONENT_WIDTH * 0.1);

    //Šířka obvodu relé
    int RELAY_BORDER_WIDTH = (int) ((float) CONDUCTOR_WIDTH * SCALE_RELAY_BORDER_WIDTH);
}
