package com.lupa.a363.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class Dimensions {

    private int width;
    private int height;
    private int padding;


    public Dimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Dimensions(int width, int height, int padding) {
        this.width = width;
        this.height = height;
        this.padding = padding;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }
}
