package com.lupa.a363.objects.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.lupa.a363.utils.AppUtils;

public class ComponentRelay extends Component {
    public ComponentRelay(Context context) {
        super(context);
    }

    public ComponentRelay(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ComponentRelay(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ComponentRelay(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawRectangle(canvas);
        drawTopLine(canvas, this.direction == Direction.TOP);
        drawBottomLine(canvas, this.direction == Direction.BOTTOM);

        if (this.orientation == Orientation.VERTICAL) {
            if (this.direction == Direction.LEFT_CENTER || this.direction == Direction.RIGHT_CENTER) {
                drawErrText(canvas, "Chybná volba napojení!");
                return;
            }
        }

        if (this.direction == Direction.LEFT_BOTTOM) {
            drawLeftBottomLine(canvas);
        } else if (this.direction == Direction.LEFT_TOP) {
            drawLeftTopLine(canvas);
        } else if (this.direction == Direction.RIGHT_TOP) {
            drawRightTopLine(canvas);
        } else if (this.direction == Direction.RIGHT_BOTTOM) {
            drawRightBottomLine(canvas);
        }

        drawLabelText(canvas);
    }

    private void drawRectangle(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(RELAY_BORDER_WIDTH);
        paint.setColor(Color.BLACK);

        canvas.drawRect(
                COMPONENT_FRAME + COMPONENT_PADDING,
                COMPONENT_FRAME + COMPONENT_PADDING + (int) (((float)(COMPONENT_HEIGHT - COMPONENT_PADDING)) / 4),
                COMPONENT_WIDTH + (2 * COMPONENT_FRAME) - (COMPONENT_FRAME + COMPONENT_PADDING),
                COMPONENT_HEIGHT + (2 * COMPONENT_FRAME) - COMPONENT_FRAME - COMPONENT_PADDING - (int) (((float)(COMPONENT_HEIGHT - COMPONENT_PADDING)) / 4),
                paint);
    }

    private void drawTopLine(Canvas canvas, boolean append) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        int startY = 0 + COMPONENT_FRAME;

        if (append) {
            startY = 0;
        }

        canvas.drawLine(
                (COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) / 2,
                startY,
                (COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) / 2,
                COMPONENT_FRAME + COMPONENT_PADDING + (int) (((float)(COMPONENT_HEIGHT - COMPONENT_PADDING)) / 4),
                paint
        );
    }

    private void drawBottomLine(Canvas canvas, boolean append) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        int stopY = COMPONENT_FRAME + COMPONENT_HEIGHT;

        if (append) {
            stopY = COMPONENT_FRAME + COMPONENT_HEIGHT + COMPONENT_FRAME;
        }

        canvas.drawLine(
                (COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) / 2,
                COMPONENT_HEIGHT + (2 * COMPONENT_FRAME) - COMPONENT_FRAME - COMPONENT_PADDING - (int) (((float)(COMPONENT_HEIGHT - COMPONENT_PADDING)) / 4),
                (COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) / 2,
                stopY,
                paint
        );
    }

    private void drawLeftBottomLine(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        canvas.drawLine(
                0,
                COMPONENT_FRAME + COMPONENT_HEIGHT,
                COMPONENT_FRAME + (COMPONENT_WIDTH / 2),
                COMPONENT_HEIGHT + COMPONENT_FRAME,
                paint
        );
    }

    private void drawRightBottomLine(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        canvas.drawLine(
                COMPONENT_FRAME + COMPONENT_WIDTH / 2,
                COMPONENT_FRAME + COMPONENT_HEIGHT,
                COMPONENT_FRAME + COMPONENT_WIDTH + COMPONENT_FRAME,
                COMPONENT_FRAME + COMPONENT_HEIGHT,
                paint
        );
    }

    private void drawLeftTopLine(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        canvas.drawLine(
                0,
                COMPONENT_FRAME,
                COMPONENT_FRAME + (COMPONENT_WIDTH / 2),
                COMPONENT_FRAME,
                paint
        );
    }

    private void drawRightTopLine(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        canvas.drawLine(
                COMPONENT_FRAME + COMPONENT_WIDTH / 2,
                COMPONENT_FRAME,
                COMPONENT_FRAME + COMPONENT_WIDTH + COMPONENT_FRAME,
                COMPONENT_FRAME,
                paint
        );

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(
                    COMPONENT_FRAME + COMPONENT_WIDTH + COMPONENT_FRAME - NODE_POINT_RADIUS,
                    COMPONENT_FRAME - NODE_POINT_RADIUS,
                    COMPONENT_FRAME + COMPONENT_WIDTH + COMPONENT_FRAME + NODE_POINT_RADIUS,
                    COMPONENT_FRAME + NODE_POINT_RADIUS,
                    paint);
        } else {
            RectF rectF = new RectF(
                    COMPONENT_FRAME + COMPONENT_WIDTH + COMPONENT_FRAME - NODE_POINT_RADIUS,
                    COMPONENT_FRAME - NODE_POINT_RADIUS,
                    COMPONENT_FRAME + COMPONENT_WIDTH + COMPONENT_FRAME + NODE_POINT_RADIUS,
                    COMPONENT_FRAME + NODE_POINT_RADIUS
            );

            canvas.drawOval(rectF, paint);
        }
    }

    private void drawLabelText(Canvas canvas) {
        int textSize = (int)((float)COMPONENT_HEIGHT / 4 * 0.9);

        Paint paint = new Paint();
        paint.setTextSize(textSize);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);

        if (getCoordinates() == null) setCoordinates(1,1);

        float textWidth = paint.measureText(/*"" + coordinates.getX() + "," + coordinates.getY()*/this.label);
        int maxTextWidth = (int)((float)COMPONENT_WIDTH * 0.7);

        int centerY = (COMPONENT_HEIGHT + (2 * COMPONENT_FRAME)) / 2;
        int yPos = (int) (centerY - ((paint.descent() + paint.ascent()) / 2)) ;

        if (textWidth > maxTextWidth) {
            int newTextSize = textSize;
            while (textWidth > maxTextWidth) {
                newTextSize = AppUtils.scaleDownTextSize(newTextSize);
                paint.setTextSize(newTextSize);
                textWidth = paint.measureText(/*"" + coordinates.getX() + "," + coordinates.getY()*/this.label);
                yPos = (int) (centerY - ((paint.descent() + paint.ascent()) / 2)) ;
            }
        } else {
            paint.setTextSize(textSize);
        }

        canvas.drawText(/*"" + coordinates.getX() + "," + coordinates.getY()*/this.label, centerY, yPos, paint);
    }

    private void drawErrText(Canvas canvas, String errText) {
        int textSize = (int)((float)COMPONENT_HEIGHT + (2 * COMPONENT_FRAME) * 0.8);

        Paint paint = new Paint();
        paint.setTextSize(textSize);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);

        float textWidth = paint.measureText(errText);
        int maxTextWidth = (int)((float)(COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) * 0.9);

        int centerY = (COMPONENT_HEIGHT + (2 * COMPONENT_FRAME)) / 2;
        int yPos = (int) (centerY - ((paint.descent() + paint.ascent()) / 2)) ;

        if (textWidth > maxTextWidth) {
            int newTextSize = textSize;
            while (textWidth > maxTextWidth) {
                newTextSize = AppUtils.scaleDownTextSize(newTextSize);
                paint.setTextSize(newTextSize);
                textWidth = paint.measureText(errText);
                yPos = (int) (centerY - ((paint.descent() + paint.ascent()) / 2)) ;
            }
        } else {
            paint.setTextSize(textSize);
        }

        canvas.drawText(errText, centerY, yPos, paint);
    }
}
