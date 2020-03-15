package com.lupa.a363.objects.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.lupa.a363.R;


public class ItemStatusDisplay extends View {

    int width;
    int height;

    int ledWidth;
    int textSize;

    boolean active;
    int number = 0;
    String text01 = "";
    String text02 = "";
    String text03 = "";

    Paint paint;

    int margin;
    int ledX;
    int ledY;

    int lineSpace;

    boolean selected;

    public ItemStatusDisplay(Context context) {
        super(context);
        init();
    }

    public ItemStatusDisplay(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        applyAttributeSet(context, attrs);
    }

    public ItemStatusDisplay(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        applyAttributeSet(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ItemStatusDisplay(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        applyAttributeSet(context, attrs);
    }


    public void applyAttributeSet(Context context, AttributeSet attrs) {
        if (attrs == null) return;

        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ItemStatusDisplay, 0, 0);

        if (ta == null) return;

        try {
            active = ta.getBoolean(R.styleable.ItemStatusDisplay_cActive, false);
            number = ta.getInt(R.styleable.ItemStatusDisplay_cNumber, 0);
            text01 = ta.getString(R.styleable.ItemStatusDisplay_cText01);
            text02 = ta.getString(R.styleable.ItemStatusDisplay_cText02);
            text03 = ta.getString(R.styleable.ItemStatusDisplay_cText03);
        } finally {
            ta.recycle();
        }

        if (text01 == null) text01 = "";
        if (text02 == null) text02 = "";
        if (text03 == null) text03 = "";
    }

    private void init() {
        paint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = getMeasuredWidth();
        height = (int) (width / ((float) 80 / (float) 130));

        ledWidth = (int) ((float) width / 3);
        textSize = (int) ((float) height / 8);
        lineSpace = (int) ((float) textSize / 2);

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawRectangle(canvas);
        drawLed(canvas);
        drawNumber(canvas);
        drawLabelText01(canvas);
        drawLabelText02(canvas);
        drawLabelText03(canvas);
    }

    private void drawRectangle(Canvas canvas) {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setColor(Color.BLACK);

        margin = (int) ((float) width * 0.04);

        canvas.drawRect(
                margin,
                margin,
                width - margin,
                height - margin,
                paint);
    }

    private void drawLed(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        paint.setColor(Color.GRAY);
        if (active) paint.setColor(Color.YELLOW);

        ledX = width / 2;
        ledY = margin + (int) ((float) ledWidth / 2);

        //Výplň
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(
                    (int) (((float) width / 2) - ((float) ledWidth / 2)),
                    margin + (int) ((float) height * 0.1),
                    (int) (((float) width / 2) + ((float) ledWidth / 2)),
                    margin + (int) ((float) height * 0.1) + ledWidth,
                    paint);
        } else {
            RectF rectF = new RectF(
                    (int) (((float) width / 2) - ((float) ledWidth / 2)),
                    margin + (int) ((float) ledWidth / 2),
                    (int) (((float) width / 2) + ((float) ledWidth / 2)),
                    margin + ledWidth);

            canvas.drawOval(rectF, paint);
        }


        //Obvod
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(
                    (int) (((float) width / 2) - ((float) ledWidth / 2)),
                    margin + (int) ((float) height * 0.1),
                    (int) (((float) width / 2) + ((float) ledWidth / 2)),
                    margin + (int) ((float) height * 0.1) + ledWidth,
                    paint);
        } else {
            RectF rectF = new RectF(
                    (int) (((float) width / 2) - ((float) ledWidth / 2)),
                    margin + (int) ((float) ledWidth / 2),
                    (int) (((float) width / 2) + ((float) ledWidth / 2)),
                    margin + ledWidth);

            canvas.drawOval(rectF, paint);
        }
    }

    private void drawNumber(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(textSize);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(Color.BLACK);

        if (!active) {
            paint.setColor(Color.WHITE);
        }

        int yPos =
                (int) ((margin + (int) ((float) height * 0.1) + (ledWidth / 2)
                - ((paint.descent() + paint.ascent()) / 2)));

        canvas.drawText(
                "" + this.number,
                (int) (((float) width) / 2),
                yPos,
                paint);
    }

    private void drawLabelText01(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(textSize);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(Color.BLACK);

        canvas.drawText(
                this.text01,
                (int) (((float) width) / 2),
                margin + (int) ((float) height * 0.1) + ledWidth + (int) ((float) height * 0.2),
                paint);
    }

    private void drawLabelText02(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(textSize);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(Color.BLACK);

        canvas.drawText(
                this.text02,
                (int) (((float) width) / 2),
                margin + (int) ((float) height * 0.1) + ledWidth + (int) ((float) height * 0.2) + textSize + lineSpace,
                paint);
    }

    private void drawLabelText03(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(textSize);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(Color.BLACK);

        canvas.drawText(
                this.text03,
                (int) (((float) width) / 2),
                margin + (int) ((float) height * 0.1) + ledWidth + (int) ((float) height * 0.2) + (2 * textSize) + (2 * lineSpace),
                paint);
    }

    public void setActive(boolean active) {
        this.active = active;
        invalidate();
    }

    public int getNumber() {
        return number;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }
}
