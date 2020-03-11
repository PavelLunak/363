package com.lupa.a363.objects.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lupa.a363.R;


public class ItemStatusDisplay extends LinearLayout {

    View rootView;
    View led;
    TextView labelNumber, label01, label02, label03;

    boolean active;
    int number;
    String text01, text02, text03;

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
    }

    private void init() {
        rootView = inflate(getContext(), R.layout.status_display_item, this);

        led = rootView.findViewById(R.id.led);
        labelNumber = rootView.findViewById(R.id.labelNumber);
        label01 = rootView.findViewById(R.id.label01);
        label02 = rootView.findViewById(R.id.label02);
        label03 = rootView.findViewById(R.id.label03);

        if (active) {
            led.setBackground(getResources().getDrawable(R.drawable.status_display_led_on));
        } else {
            led.setBackground(getResources().getDrawable(R.drawable.status_display_led_off));
        }

        labelNumber.setText("" + number);
        label01.setText(text01 != null ? text01 : "");
        label02.setText(text02 != null ? text02 : "");
        label03.setText(text03 != null ? text03 : "");
    }
}
