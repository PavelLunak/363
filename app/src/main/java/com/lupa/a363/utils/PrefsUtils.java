package com.lupa.a363.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsUtils {

    public static void updateSeries(Context context, int series) {
        SharedPreferences pref = context.getSharedPreferences(AppConstants.PREFS_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(AppConstants.PREFS_SERIES_NAME, series);
        editor.commit();
    }

    public static int getSeries(Context context) {
        SharedPreferences pref = context.getSharedPreferences(AppConstants.PREFS_NAME, context.MODE_PRIVATE);
        return pref.getInt(AppConstants.PREFS_SERIES_NAME, 3);
    }
}
