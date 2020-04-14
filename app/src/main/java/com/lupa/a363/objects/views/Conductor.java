package com.lupa.a363.objects.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;

import com.lupa.a363.R;
import com.lupa.a363.objects.Coordinates;
import com.lupa.a363.objects.Dimensions;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class Conductor extends Component {

    Paint paint;

    Side startSide;
    Side endSide;

    int startFromX = 0;
    int startFromY = 0;

    int endToX = 0;
    int endToY = 0;

    int centerX = (COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) / 2;
    int centerY = (COMPONENT_HEIGHT + (2 * COMPONENT_FRAME)) / 2;


    public Conductor(Context context) {
        super(context);
        init();
    }

    public Conductor(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        applyAttributeSet(context, attrs);
        init();
    }

    public Conductor(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyAttributeSet(context, attrs);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Conductor(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        applyAttributeSet(context, attrs);
        init();
    }


    public void applyAttributeSet(Context context, AttributeSet attrs) {
        super.applyAttributeSet(context, attrs);

        if (attrs == null) return;

        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Conductor, 0, 0);

        if (ta == null) return;

        try {
            label = ta.getString(R.styleable.Conductor_ccConductorLabel);
            description = ta.getString(R.styleable.Conductor_ccDescription);

            int tempStart = ta.getInt(R.styleable.Conductor_ccStart, 1);
            int tempEnd = ta.getInt(R.styleable.Conductor_ccStop, 2);

            if (label == null) label = "";
            if (description == null) description = "";

            switch (tempStart) {
                case 1:
                    startSide = Side.LEFT;
                    break;
                case 2:
                    startSide = Side.TOP;
                    break;
                case 3:
                    startSide = Side.RIGHT;
                    break;
                case 4:
                    startSide = Side.BOTTOM;
                    break;
            }

            switch (tempEnd) {
                case 1:
                    endSide = Side.LEFT;
                    break;
                case 2:
                    endSide = Side.TOP;
                    break;
                case 3:
                    endSide = Side.RIGHT;
                    break;
                case 4:
                    endSide = Side.BOTTOM;
                    break;
            }
        } finally {
            ta.recycle();
        }
    }

    private void init() {
        paint = new Paint();

        this.dimensions = new Dimensions(
                COMPONENT_WIDTH + (2 * (COMPONENT_FRAME + NODE_POINT_RADIUS)),
                COMPONENT_HEIGHT + (2 * (COMPONENT_FRAME + NODE_POINT_RADIUS)),
                COMPONENT_PADDING);

        setCoordinates(1,1);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(
                this.dimensions.getWidth(),
                this.dimensions.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawStart(canvas);
        drawEnd(canvas);
    }

    private void drawStart(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        switch (startSide) {
            case LEFT:
                if (createStartNode) startFromX = 0;    //Protáhne napojení do vedlejšího objektu a vytvoří uzel
                else startFromX = COMPONENT_FRAME;

                startFromY = (COMPONENT_HEIGHT + (2 * COMPONENT_FRAME)) / 2;
                break;
            case TOP:
                startFromX = (COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) / 2;

                if (createStartNode) startFromY = 0;
                else startFromY = COMPONENT_FRAME;
                break;
            case RIGHT:
                if (createStartNode) startFromX = COMPONENT_WIDTH + (2 * COMPONENT_FRAME);
                else startFromY = startFromX = COMPONENT_WIDTH + (COMPONENT_FRAME);

                startFromY = (COMPONENT_HEIGHT + (2 * COMPONENT_FRAME)) / 2;
                break;
            case BOTTOM:
                startFromX = (COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) / 2;

                if (createStartNode) startFromY = COMPONENT_HEIGHT + (2 * COMPONENT_FRAME);
                else startFromY = COMPONENT_HEIGHT + (COMPONENT_FRAME);
                break;
        }

        canvas.drawLine(
                startFromX,
                startFromY,
                centerX,
                centerY,
                paint);
    }

    private void drawEnd(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        switch (endSide) {
            case LEFT:
                if (createEndNode) endToX = 0;
                else endToX = COMPONENT_FRAME;

                endToY = (COMPONENT_HEIGHT + (2 * COMPONENT_FRAME)) / 2;
                break;
            case TOP:
                endToX = (COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) / 2;

                if (createEndNode) endToY = 0;
                else endToY = COMPONENT_FRAME;
                break;
            case RIGHT:
                if (createEndNode) endToX = COMPONENT_WIDTH + (2 * COMPONENT_FRAME);
                else endToX = COMPONENT_WIDTH + COMPONENT_FRAME;

                endToY = (COMPONENT_HEIGHT + (2 * COMPONENT_FRAME)) / 2;
                break;
            case BOTTOM:
                if (createEndNode) endToY = COMPONENT_HEIGHT + (2 * COMPONENT_FRAME);
                else endToY = COMPONENT_HEIGHT + COMPONENT_FRAME;

                endToX = (COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) / 2;
                break;
        }

        canvas.drawLine(
                centerX,
                centerY,
                endToX,
                endToY,
                paint);
    }
}
