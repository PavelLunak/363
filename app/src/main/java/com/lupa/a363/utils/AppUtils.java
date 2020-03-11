package com.lupa.a363.utils;

public class AppUtils {

    public static int scaleDownTextSize(int actualSize) {
        if (actualSize <= 0) return 0;
        return (int) (actualSize * 0.90);
    }
}
