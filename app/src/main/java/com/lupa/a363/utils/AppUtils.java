package com.lupa.a363.utils;

import android.content.Context;

import com.lupa.a363.R;

import java.lang.reflect.Array;

import androidx.fragment.app.FragmentManager;

public class AppUtils {

    public static boolean isFragmentCurrent(String name, FragmentManager fragmentManager) {
        if (fragmentManager.getBackStackEntryCount() != 0) {
            FragmentManager.BackStackEntry be = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1);
            return be.getName().equals(name);
        }
        return false;
    }

    public static int scaleDownTextSize(int actualSize) {
        if (actualSize <= 0) return 0;
        return (int) (actualSize * 0.90);
    }

    public static String[] getStringsByCheckpointNumber(Context context, int number) {

        switch (number) {
            case 11:
                return context.getResources().getStringArray(R.array.data_checkpoint_11);
            case 12:
                return context.getResources().getStringArray(R.array.data_checkpoint_12);
            case 13:
                return context.getResources().getStringArray(R.array.data_checkpoint_13);
            case 14:
                return context.getResources().getStringArray(R.array.data_checkpoint_14);
            case 15:
                return context.getResources().getStringArray(R.array.data_checkpoint_15);
            case 16:
                return context.getResources().getStringArray(R.array.data_checkpoint_16);
            case 17:
                return context.getResources().getStringArray(R.array.data_checkpoint_17);
            case 18:
                return context.getResources().getStringArray(R.array.data_checkpoint_18);
            case 19:
                return context.getResources().getStringArray(R.array.data_checkpoint_19);
            case 20:
                return context.getResources().getStringArray(R.array.data_checkpoint_20);
            case 21:
                return context.getResources().getStringArray(R.array.data_checkpoint_21);
            case 22:
                return context.getResources().getStringArray(R.array.data_checkpoint_22);
            case 23:
                return context.getResources().getStringArray(R.array.data_checkpoint_23);
            case 24:
                return context.getResources().getStringArray(R.array.data_checkpoint_24);
            case 25:
                return context.getResources().getStringArray(R.array.data_checkpoint_25);
            case 26:
                return context.getResources().getStringArray(R.array.data_checkpoint_26);
            case 27:
                return context.getResources().getStringArray(R.array.data_checkpoint_27);
            case 28:
                return context.getResources().getStringArray(R.array.data_checkpoint_28);
            case 29:
                return context.getResources().getStringArray(R.array.data_checkpoint_29);
            case 30:
                return context.getResources().getStringArray(R.array.data_checkpoint_30);
            case 31:
                return context.getResources().getStringArray(R.array.data_checkpoint_31);

        }

        return null;
    }

    public static String[] getLabelsByCheckpointNumber(Context context, int number) {

        String[] labels = null;

        switch (number) {
            case 11:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_11_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_11_b);
                break;
            case 12:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_12_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_12_b);
                break;
            case 13:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_13_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_13_b);
                break;
            case 14:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_14_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_14_b);
                break;
            case 15:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_15_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_15_b);
                break;
            case 16:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_16_a);
                break;
            case 17:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_17_a);
                break;
            case 18:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_18_a);
                break;
            case 19:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_19_a);
                break;
            case 20:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_20_a);
                break;
            case 21:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_21_a);
                break;
            case 22:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_22_a);
                break;
            case 23:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_23_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_23_b);
                break;
            case 24:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_24_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_24_b);
                break;
            case 25:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_25_a);
                break;
            case 26:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_26_a);
                break;
            case 27:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_27_a);
                break;
            case 28:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_28_a);
                break;
            case 29:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_29_a);
                break;
            case 30:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_30_a);
                break;
            case 31:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_31_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_31_b);
                break;
            case 32:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_32_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_32_b);
                break;
            case 33:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_33_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_33_b);
                break;
            case 34:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_34_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_34_b);
                break;
            case 35:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_35_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_35_b);
                break;
            case 36:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_36_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_36_b);
                break;
            case 37:
                labels = new String[3];
                labels[0] = context.getResources().getString(R.string.checkpoint_37_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_37_b);
                labels[2] = context.getResources().getString(R.string.checkpoint_37_c);
                break;
            case 38:
                labels = new String[3];
                labels[0] = context.getResources().getString(R.string.checkpoint_38_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_38_b);
                labels[2] = context.getResources().getString(R.string.checkpoint_38_c);
                break;
            case 39:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_39_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_39_b);
                break;
            case 40:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_40_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_40_b);
                break;
            case 41:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_41_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_41_b);
                break;
            case 42:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_42_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_42_b);
                break;
            case 43:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_43_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_43_b);
                break;
            case 44:
                labels = new String[3];
                labels[0] = context.getResources().getString(R.string.checkpoint_44_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_44_b);
                labels[2] = context.getResources().getString(R.string.checkpoint_44_c);
                break;
            case 45:
                labels = new String[3];
                labels[0] = context.getResources().getString(R.string.checkpoint_45_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_45_b);
                labels[2] = context.getResources().getString(R.string.checkpoint_45_c);
                break;
            case 46:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_46_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_46_b);
                break;
            case 47:
                labels = new String[2];
                labels[0] = context.getResources().getString(R.string.checkpoint_47_a);
                labels[1] = context.getResources().getString(R.string.checkpoint_47_b);
                break;
            case 48:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_48_a);
                break;
            case 49:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_49_a);
                break;
            case 50:
                labels = new String[1];
                labels[0] = context.getResources().getString(R.string.checkpoint_50_a);
                break;
        }

        return labels;
    }
}
