package com.lupa.a363.objects;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.lupa.a363.R;
import com.lupa.a363.utils.AppConstants;

public abstract class Component extends View implements AppConstants {

    CircuitType circuitType;
    ComponentType componentType;

    String name;
    String label;
    String description;

    Orientation orientation;
    Direction direction;

    Coordinates coordinates;
    Dimensions dimensions;


    public Component(Context context) {
        super(context);
        init();
    }

    public Component(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        applyAttributeSet(context, attrs);
        init();
    }

    public Component(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyAttributeSet(context, attrs);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Component(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        applyAttributeSet(context, attrs);
        init();
    }


    private void applyAttributeSet(Context context, AttributeSet attrs) {
        if (attrs == null) return;

        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Component, 0, 0);
        if (ta == null) return;

        try {
            label = ta.getString(R.styleable.Component_cLabel);
            description = ta.getString(R.styleable.Component_cDescription);

            int tempDirection = ta.getInt(R.styleable.Component_cDirection, 1);
            int tempOrientation = ta.getInt(R.styleable.Component_cOrientation, 1);

            if (label == null) label = "";
            if (description == null) description = "";

            if (tempOrientation == 1) orientation = Orientation.VERTICAL;
            else orientation = Orientation.HORIZONTAL;

            switch (tempDirection) {
                case 11:
                    direction = Direction.LEFT_BOTTOM;
                    break;
                case 12:
                    direction = Direction.LEFT_CENTER;
                    break;
                case 13:
                    direction = Direction.LEFT_TOP;
                    break;
                case 2:
                    direction = Direction.TOP;
                    break;
                case 31:
                    direction = Direction.RIGHT_BOTTOM;
                    break;
                case 32:
                    direction = Direction.RIGHT_CENTER;
                    break;
                case 33:
                    direction = Direction.RIGHT_TOP;
                    break;
                case 4:
                    direction = Direction.BOTTOM;
                    break;
            }
        } finally {
            ta.recycle();
        }
    }

    private void init() {
        this.dimensions = new Dimensions(100, 100, 10);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(dimensions.getWidth(), dimensions.getHeight());
    }
}
