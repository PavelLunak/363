package com.lupa.a363.objects.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;

import com.lupa.a363.R;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class ComponentContact extends Component {

    Paint paint;

    ContactType contactType;

    int blankPointX;
    int blankPointY;

    String pinLabel01;
    String pinLabel02;

    public ComponentContact(Context context) {
        super(context);
        init();
    }

    public ComponentContact(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ComponentContact(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ComponentContact(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    public void applyAttributeSet(Context context, AttributeSet attrs) {
        super.applyAttributeSet(context, attrs);

        TypedArray taComponentContact = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ComponentContact, 0, 0);

        if (taComponentContact == null) return;

        pinLabel01 = taComponentContact.getString(R.styleable.ComponentContact_cContactLabel_1);
        pinLabel02 = taComponentContact.getString(R.styleable.ComponentContact_cContactLabel_2);

        int tempContactType = taComponentContact.getInt(R.styleable.ComponentContact_cContactType, 1);

        if (pinLabel01 == null) pinLabel01 = "";
        if (pinLabel02 == null) pinLabel02 = "";

        switch (tempContactType) {
            case 2:
                contactType = ContactType.IDLE;
                break;
            default:
                contactType = ContactType.NORMAL;
        }
    }

    private void init() {
        paint = new Paint();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        switch (contactType) {
            case NORMAL:
                drawNormalContact(canvas);
                break;
            case IDLE:
                drawIdleContact(canvas);
                break;
        }
    }

    private void drawNormalContact(Canvas canvas) {
        drawBlankPoint(canvas);
        drawContactLine(canvas);
        drawContactStart(canvas);
        drawContactEnd(canvas);
        drawPinLabel_01(canvas);
        drawPinLabel_02(canvas);
        drawLabelText(canvas);
    }

    private void drawIdleContact(Canvas canvas) {
        drawBlankPoint(canvas);
        drawContactLine(canvas);
        drawContactStart(canvas);
        drawContactEnd(canvas);
        drawIdleLine(canvas);
        drawPinLabel_01(canvas);
        drawPinLabel_02(canvas);
        drawLabelText(canvas);
    }

    private void drawBlankPoint(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(BLANK_POINT_LINE_WIDTH);
        paint.setColor(Color.BLACK);

        float scale = 0.7f;

        if (orientation == Orientation.VERTICAL) {
            blankPointX = ((COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) / 2);
            blankPointY = (int) ((float) (COMPONENT_HEIGHT + (2 * COMPONENT_FRAME)) * scale) - COMPONENT_PADDING;
        } else {
            blankPointX = COMPONENT_PADDING + (int) ((float) (COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) * 0.3);
            blankPointY = ((COMPONENT_WIDTH + (2 * COMPONENT_FRAME)) / 2);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(
                    blankPointX - BLANK_POINT_RADIUS,
                    blankPointY - BLANK_POINT_RADIUS,
                    blankPointX + BLANK_POINT_RADIUS,
                    blankPointY + BLANK_POINT_RADIUS,
                    paint);
        } else {
            RectF rectF = new RectF(
                    blankPointX - BLANK_POINT_RADIUS,
                    blankPointY - BLANK_POINT_RADIUS,
                    blankPointX + BLANK_POINT_RADIUS,
                    blankPointY + BLANK_POINT_RADIUS
            );

            canvas.drawOval(rectF, paint);
        }
    }

    private void drawContactLine(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        int overlap = (int) ((float)CONTACT_LENGTH * 0.1);

        if (orientation == Orientation.VERTICAL) {
            canvas.drawLine(
                    blankPointX,
                    blankPointY - BLANK_POINT_RADIUS,
                    blankPointX - CONTACT_OPENING_WIDTH,
                    blankPointY - CONTACT_LENGTH - overlap,
                    paint
            );
        } else {
            canvas.drawLine(
                    blankPointX + BLANK_POINT_RADIUS,
                    blankPointY,
                    blankPointX + CONTACT_LENGTH + overlap,
                    blankPointY - CONTACT_OPENING_WIDTH,
                    paint
            );
        }
    }

    private void drawContactStart(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        if (orientation == Orientation.VERTICAL) {
            canvas.drawLine(
                    blankPointX,
                    blankPointY + BLANK_POINT_RADIUS,
                    blankPointX,
                    COMPONENT_FRAME + COMPONENT_HEIGHT,
                    paint
            );
        } else {
            canvas.drawLine(
                    blankPointX - BLANK_POINT_RADIUS,
                    blankPointY,
                    COMPONENT_FRAME,
                    blankPointY,
                    paint
            );
        }
    }

    private void drawContactEnd(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        if (orientation == Orientation.VERTICAL) {
            canvas.drawLine(
                    blankPointX,
                    blankPointY - CONTACT_LENGTH,
                    blankPointX,
                    COMPONENT_FRAME,
                    paint
            );
        } else {
            canvas.drawLine(
                    blankPointX + CONTACT_LENGTH,
                    blankPointY,
                    COMPONENT_FRAME + COMPONENT_WIDTH,
                    blankPointY,
                    paint
            );
        }
    }

    private void drawIdleLine(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(CONDUCTOR_WIDTH);
        paint.setColor(Color.BLACK);

        int idleLineLength = (int) ((float)CONTACT_LENGTH * 0.25);

        if (orientation == Orientation.VERTICAL) {
            canvas.drawLine(
                    blankPointX,
                    blankPointY - CONTACT_LENGTH,
                    blankPointX - idleLineLength,
                    blankPointY - CONTACT_LENGTH,
                    paint
            );
        } else {
            canvas.drawLine(
                    blankPointX + CONTACT_LENGTH,
                    blankPointY,
                    blankPointX + CONTACT_LENGTH,
                    blankPointY - idleLineLength,
                    paint
            );
        }
    }

    private void drawPinLabel_01(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(CONTACT_PIN_LABEL_SIZE);
        paint.setAntiAlias(true);

        if (orientation == Orientation.VERTICAL) {
            canvas.drawText(pinLabel01, blankPointX + BLANK_POINT_RADIUS + 2, blankPointY - CONTACT_LENGTH, paint);
        } else {
            canvas.drawText(pinLabel01, blankPointX + CONTACT_LENGTH, blankPointY + (2 * BLANK_POINT_RADIUS) + 5, paint);
        }
    }

    private void drawPinLabel_02(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(CONTACT_PIN_LABEL_SIZE);
        paint.setAntiAlias(true);

        if (orientation == Orientation.VERTICAL) {
            canvas.drawText(pinLabel02, blankPointX + BLANK_POINT_RADIUS + 2, blankPointY, paint);
        } else {
            canvas.drawText(pinLabel02, blankPointX, blankPointY + (2 * BLANK_POINT_RADIUS) + 5, paint);
        }
    }

    private void drawLabelText(Canvas canvas) {
        int textSize = (int)((float)COMPONENT_HEIGHT / 4 * 0.9);

        Paint paint = new Paint();
        paint.setTextSize(textSize);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);

        if (orientation == Orientation.VERTICAL) {
            canvas.save();
            canvas.rotate(
                    270,
                    ((2 * COMPONENT_FRAME) + COMPONENT_WIDTH + (2 * NODE_POINT_RADIUS)) / 2,
                    ((2 * COMPONENT_FRAME) + COMPONENT_WIDTH + (2 * NODE_POINT_RADIUS)) / 2);

            canvas.drawText(
                    this.label,
                    ((2 * COMPONENT_FRAME) + COMPONENT_WIDTH + (2 * NODE_POINT_RADIUS)) / 2,
                    (((2 * COMPONENT_FRAME) + COMPONENT_WIDTH + (2 * NODE_POINT_RADIUS)) / 2) - (textSize),
                    paint);

            canvas.restore();
        } else {
            canvas.drawText(
                    this.label,
                    ((2 * COMPONENT_FRAME) + COMPONENT_WIDTH + (2 * NODE_POINT_RADIUS)) / 2,
                    (((2 * COMPONENT_FRAME) + COMPONENT_WIDTH + (2 * NODE_POINT_RADIUS)) / 2) - (textSize),
                    paint);
        }
    }
}
