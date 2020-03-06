package com.lupa.a363.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

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
        drawRectangle(canvas);
        drawTopLine(canvas);
        drawBottomLine(canvas);
    }

    private void drawRectangle(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        paint.setColor(Color.BLACK);

        canvas.drawRect(
                2 * this.dimensions.getPadding(),
                this.dimensions.getHeight() / 3,
                this.dimensions.getWidth() - (2 * this.dimensions.getPadding()),
                this.dimensions.getHeight() / 3 * 2,
                paint);
    }

    private void drawTopLine(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setColor(Color.BLACK);

        canvas.drawLine(
                this.dimensions.getWidth() / 2,
                this.dimensions.getHeight() / 3,
                this.dimensions.getWidth() / 2,
                0,
                paint
        );
    }

    private void drawBottomLine(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setColor(Color.BLACK);

        canvas.drawLine(
                this.dimensions.getWidth() / 2,
                this.dimensions.getHeight() / 3 * 2,
                this.dimensions.getWidth() / 2,
                this.dimensions.getHeight(),
                paint
        );
    }
}
