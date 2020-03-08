package com.lupa.a363.objects.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.lupa.a363.R;
import com.lupa.a363.objects.Coordinates;
import com.lupa.a363.objects.Dimensions;
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

    int toLeftOf;
    int toRightOf;
    int below;
    int above;


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


    public void applyAttributeSet(Context context, AttributeSet attrs) {
        if (attrs == null) return;

        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Component, 0, 0);

        if (ta == null) return;

        try {
            label = ta.getString(R.styleable.Component_cLabel);
            description = ta.getString(R.styleable.Component_cDescription);

            toLeftOf = ta.getResourceId(R.styleable.Component_cToLeftOf, 0);
            toRightOf = ta.getResourceId(R.styleable.Component_cToRightOf, 0);
            below = ta.getResourceId(R.styleable.Component_cBelow, 0);
            above = ta.getResourceId(R.styleable.Component_cAbove, 0);

            int tempDirection = ta.getInt(R.styleable.Component_cDirection, 1);
            int tempOrientation = ta.getInt(R.styleable.Component_cOrientation, 1);

            if (label == null) label = "";
            if (description == null) description = "";

            if (tempOrientation == 1) orientation = Orientation.VERTICAL;
            else orientation = Orientation.HORIZONTAL;

            switch (tempDirection) {
                case -1:
                    direction = Direction.NONE;
                    break;
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
        this.dimensions = new Dimensions(200, 200, 10);
        setCoordinates(1,1);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(
                COMPONENT_WIDTH + (2 * COMPONENT_FRAME),
                COMPONENT_HEIGHT + (2 * COMPONENT_FRAME));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawFrame(canvas);
    }

    private void drawFrame(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setColor(Color.LTGRAY);

        canvas.drawRect(
                COMPONENT_FRAME,
                COMPONENT_FRAME,
                COMPONENT_WIDTH + COMPONENT_FRAME,
                COMPONENT_HEIGHT + COMPONENT_FRAME,
                paint);
    }

    //----------------------------------------------------------------------------------------------

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int x, int y) {
        this.coordinates = new Coordinates(x, y);
    }

    //----------------------------------------------------------------------------------------------

    public boolean hasRelativePosition() {
        return toLeftOf > 0 || toRightOf > 0 || below > 0 || above > 0;
    }

    public boolean hasCoordinates() {
        return this.coordinates.getX() > 0 && this.coordinates.getY() > 0;
    }

    //----------------------------------------------------------------------------------------------
}
