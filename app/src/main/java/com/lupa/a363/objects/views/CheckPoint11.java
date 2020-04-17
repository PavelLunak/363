package com.lupa.a363.objects.views;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.lupa.a363.R;
import com.lupa.a363.utils.AppConstants;

public class CheckPoint11 extends View implements AppConstants {

    Paint paint;

    float scale = 1f;

    float width = 400;
    float height = 1500;
    int textSize = (int) (CONTACT_LENGTH * scale * 0.5f);
    float contactLength = CONTACT_LENGTH * scale;
    float conductorLength = contactLength;
    float pointRadius = BLANK_POINT_RADIUS * scale;
    float timeRelayWidth = TIME_REALAY_WIDTH * scale;
    float timeRelayHeight = TIME_REALAY_HEIGHT * scale;

    int timeRelayTop = 0;

    public CheckPoint11(Context context) {
        super(context);
    }

    public CheckPoint11(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckPoint11(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CheckPoint11(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((int) width, (int) height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Souřadnice v horním rohu vodiče
        int startX = (int) (width - (3 * conductorLength) + (2 * pointRadius));
        int startY = (int) conductorLength;

        //F104
        drawContact(
                canvas,
                (int) (startX + conductorLength + pointRadius),
                startY,
                ContactType.BREAKER,
                Orientation.HORIZONTAL);

        //Text F104
        drawText(canvas, "F104", (int) (startX + conductorLength + pointRadius + (int) (conductorLength / 2)), startY + textSize);

        //Vodič vpravo od F104
        drawConductor(canvas, (int) (startX + (2 * pointRadius) + (2 * conductorLength)), startY, Orientation.HORIZONTAL);

        //Vodič vlevo od F104
        drawConductor(canvas, startX, startY, Orientation.HORIZONTAL);

        //Vodič od horního rohu k F106
        //(CONDUCTOR_WIDTH / 2) je tam proto, aby roh byl pějně hranatej
        drawConductor(canvas, startX, startY - (CONDUCTOR_WIDTH / 2), Orientation.VERTICAL);

        //F106
        startY += conductorLength + contactLength;
        drawContact(
                canvas,
                startX,
                (int) (startY),
                ContactType.BREAKER,
                Orientation.VERTICAL);

        //Vodič pod F106
        startY += pointRadius;
        drawConductor(canvas, startX, startY, Orientation.VERTICAL);

        //K132
        startY += conductorLength + contactLength;
        drawContact(
                canvas,
                startX,
                startY,
                ContactType.IDLE,
                Orientation.VERTICAL);

        //Vodič 573
        startY += pointRadius;
        drawConductor(canvas, startX, startY, Orientation.VERTICAL);

        //K119
        startY += conductorLength + contactLength;
        drawContact(
                canvas,
                startX,
                startY,
                ContactType.NORMAL,
                Orientation.VERTICAL);

        //Vodič 541
        startY += pointRadius;
        drawConductor(canvas, startX, startY, Orientation.VERTICAL);

        //K128
        startY += conductorLength + contactLength;
        drawContact(
                canvas,
                startX,
                startY,
                ContactType.NORMAL,
                Orientation.VERTICAL);

        //Vodič 540
        startY += pointRadius;
        drawConductor(canvas, startX, startY, Orientation.VERTICAL);

        //K120
        startY += conductorLength + contactLength;
        drawContact(
                canvas,
                startX,
                startY,
                ContactType.NORMAL,
                Orientation.VERTICAL);

        //Vodič 531
        startY += pointRadius;
        drawConductor(canvas, startX, startY, Orientation.VERTICAL);

        //K129
        startY += conductorLength + contactLength;
        drawContact(
                canvas,
                startX,
                startY,
                ContactType.NORMAL,
                Orientation.VERTICAL);

        //Vodič k časovému relé
        startY += pointRadius;
        drawConductor(canvas, startX, startY, Orientation.VERTICAL);
        startY += conductorLength;
        drawConductor(canvas, startX, startY, Orientation.VERTICAL);

        //Časové relé
        startY += conductorLength;
        timeRelayTop = startY; //Uložení pozice, do které pak natáhnu druhý vodič co jde do časového relé
        drawTimeRelay(canvas, startX - (int) (timeRelayWidth * 0.4), startY);

        //Vodič od časového relé k zemi
        startY += timeRelayHeight;
        drawConductor(canvas, startX, startY, Orientation.VERTICAL);

        //Uzemnění
        startY += conductorLength;
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);
        canvas.drawLine(20, startY, getMeasuredWidth() - 20, startY, paint);

        //Odbočka pod F106
        startY = (int) (conductorLength + conductorLength - (CONDUCTOR_WIDTH / 2) + conductorLength + pointRadius + (conductorLength / 2));
        drawConductor(canvas, startX, startY, Orientation.HORIZONTAL);

        //Uzel odbočky pod F106
        drawNode(canvas, startX, startY);

        //propojení druhé větvě s časovým relé
        drawConductor(
                canvas,
                (int) (startX + conductorLength),
                startY,
                (int) (startX + conductorLength),
                timeRelayTop);
    }

    private void drawNode(Canvas canvas, int x, int y) {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(
                    x - pointRadius,
                    y - pointRadius,
                    x + pointRadius,
                    y + pointRadius,
                    paint);
        } else {
            RectF rectF = new RectF(
                    x - pointRadius,
                    y - pointRadius,
                    x + pointRadius,
                    y + pointRadius
            );

            canvas.drawOval(rectF, paint);
        }
    }

    //Vodič pevně dané délky
    private void drawConductor(Canvas canvas, int x, int y, Orientation orientation) {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        if (orientation == Orientation.VERTICAL) {
            canvas.drawLine(
                    x,
                    y ,
                    x,
                    y + conductorLength,
                    paint
            );
        } else {
            canvas.drawLine(
                    x,
                    y,
                    x + conductorLength,
                    y,
                    paint
            );
        }
    }

    //Vodič volitelné délky a bez zadání orientace
    private void drawConductor(Canvas canvas, int startX, int startY, int endX, int endY) {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        canvas.drawLine(
                startX,
                startY ,
                endX,
                endY,
                paint
        );
    }

    //x : horizontální střed textu
    //y : vertikální střed textu
    private void drawText(Canvas canvas, String text,  int x, int y) {
        paint.setTextSize(textSize);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);

        int yPos = (int) (y - ((paint.descent() + paint.ascent()) / 2)) ;
        canvas.drawText(text, x, yPos, paint);
    }

    private void drawContact(Canvas canvas, int x, int y, ContactType contactType, Orientation orientation){
        drawBlankPoint(
                canvas,
                x,
                y);

        if (orientation == Orientation.HORIZONTAL) {
            drawContactLine(
                    canvas,
                    (int) (x + pointRadius),
                    y,
                    contactType,
                    orientation);
        } else {
            drawContactLine(
                    canvas,
                    x,
                    (int) (y - pointRadius),
                    contactType,
                    orientation);
        }
    }

    private void drawTimeRelay(Canvas canvas, int left, int top) {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        int right = (int) (left + timeRelayWidth);
        int bottom = (int) (top + timeRelayHeight);

        //Obvod relé
        canvas.drawRect(
                left,
                top,
                right,
                bottom,
                paint);

        //Svislá čára relé
        canvas.drawLine(left + timeRelayHeight, top, left + timeRelayHeight, top + timeRelayHeight, paint);

        //Šikmá čára relé
        canvas.drawLine(left, top + timeRelayHeight, left + timeRelayHeight, top, paint);
    }

    //----------------------------------------------------------------------------------------------

    private void drawBlankPoint(Canvas canvas, int x, int y) {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(BLANK_POINT_LINE_WIDTH);
        paint.setColor(Color.BLACK);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(
                    x - pointRadius,
                    y - pointRadius,
                    x + pointRadius,
                    y + pointRadius,
                    paint);
        } else {
            RectF rectF = new RectF(
                    x - pointRadius,
                    y - pointRadius,
                    x + pointRadius,
                    y + pointRadius
            );

            canvas.drawOval(rectF, paint);
        }
    }

    private void drawContactLine(Canvas canvas, int x, int y, ContactType contactType, Orientation orientation) {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        canvas.save();

        //Jistič ce otevírá nahoru (nebo vlevo)
        //Klidový kontakt se otevírá dolů (nebo vpravo)
        if (contactType == ContactType.IDLE) {
            canvas.rotate(CONTACT_OPENING * -1, x, y);
        } else {
            canvas.rotate(CONTACT_OPENING, x, y);
        }

        if (orientation == Orientation.VERTICAL) {
            canvas.drawLine(
                    x,
                    y,
                    x,
                    y - contactLength,
                    paint
            );
        } else {
            canvas.drawLine(
                    x,
                    y,
                    x + contactLength,
                    y,
                    paint
            );
        }

        //Dokreslení obdélníčku jističe na rameni kontaktu
        if (contactType == ContactType.BREAKER) {
            paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.BLACK);

            if (orientation == Orientation.HORIZONTAL) {
                int rectWidth = (int) (contactLength / 3);
                int rectHeight = (int) (rectWidth / 2);

                canvas.drawRect(x + contactLength - rectWidth, y - rectHeight, x + contactLength, y, paint);
            } else {
                int rectWidth = (int) (contactLength / 3);
                int rectHeight = (int) (rectWidth / 2);

                canvas.drawRect(x - rectHeight, y  - contactLength, x, y - contactLength + rectWidth, paint);
            }

            canvas.restore();
        }
        //Dokreslení propojovací čárky mezi vodičem a ramenem kontaktu
        else if (contactType == ContactType.IDLE) {
            canvas.restore();

            paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(CONDUCTOR_WIDTH);
            paint.setColor(Color.BLACK);

            if (orientation == Orientation.HORIZONTAL) {
                canvas.drawLine(x + contactLength, y, x + contactLength, y + (contactLength / 3), paint);
            } else {
                canvas.drawLine(x - (CONDUCTOR_WIDTH / 2), y - contactLength + pointRadius, x + (contactLength / 3), y - contactLength + pointRadius, paint);
            }
        } else {
            canvas.restore();
        }
    }
}
