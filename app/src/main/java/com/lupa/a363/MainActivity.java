package com.lupa.a363;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lupa.a363.objects.views.ItemStatusDisplay;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    LinearLayout root;

    RadioGroup rgOperatingStatus;

    RadioButton
            rbOperatingStatus01,
            rbOperatingStatus02,
            rbOperatingStatus03,
            rbOperatingStatus04,
            rbOperatingStatus05;

    ItemStatusDisplay
            checkpoint11, checkpoint12, checkpoint13, checkpoint14, checkpoint15,
            checkpoint16, checkpoint17, checkpoint18, checkpoint19, checkpoint20,
            checkpoint21, checkpoint22, checkpoint23, checkpoint24, checkpoint25,
            checkpoint26, checkpoint27, checkpoint28, checkpoint29, checkpoint30,
            checkpoint31, checkpoint32, checkpoint33, checkpoint34, checkpoint35,
            checkpoint36, checkpoint37, checkpoint38, checkpoint39, checkpoint40,
            checkpoint41, checkpoint42, checkpoint43, checkpoint44, checkpoint45,
            checkpoint46, checkpoint47, checkpoint48, checkpoint49, checkpoint50;

    View.OnClickListener onItemStatusClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.isSelected()) {
                view.setSelected(false);
                view.setBackgroundColor(0xFFFFFFFF);
            } else {
                view.setSelected(true);
                view.setBackgroundColor(0xFFFFD5DD);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_display);

        root = findViewById(R.id.root);
        rgOperatingStatus = findViewById(R.id.rgOperatingStatus);

        checkpoint11 = findViewById(R.id.checkpoint11);
        checkpoint12 = findViewById(R.id.checkpoint12);
        checkpoint13 = findViewById(R.id.checkpoint13);
        checkpoint14 = findViewById(R.id.checkpoint14);
        checkpoint15 = findViewById(R.id.checkpoint15);
        checkpoint16 = findViewById(R.id.checkpoint16);
        checkpoint17 = findViewById(R.id.checkpoint17);
        checkpoint18 = findViewById(R.id.checkpoint18);
        checkpoint19 = findViewById(R.id.checkpoint19);
        checkpoint20 = findViewById(R.id.checkpoint20);

        checkpoint21 = findViewById(R.id.checkpoint21);
        checkpoint22 = findViewById(R.id.checkpoint22);
        checkpoint23 = findViewById(R.id.checkpoint23);
        checkpoint24 = findViewById(R.id.checkpoint24);
        checkpoint25 = findViewById(R.id.checkpoint25);
        checkpoint26 = findViewById(R.id.checkpoint26);
        checkpoint27 = findViewById(R.id.checkpoint27);
        checkpoint28 = findViewById(R.id.checkpoint28);
        checkpoint29 = findViewById(R.id.checkpoint29);
        checkpoint30 = findViewById(R.id.checkpoint30);

        checkpoint31 = findViewById(R.id.checkpoint31);
        checkpoint32 = findViewById(R.id.checkpoint32);
        checkpoint33 = findViewById(R.id.checkpoint33);
        checkpoint34 = findViewById(R.id.checkpoint34);
        checkpoint35 = findViewById(R.id.checkpoint35);
        checkpoint36 = findViewById(R.id.checkpoint36);
        checkpoint37 = findViewById(R.id.checkpoint37);
        checkpoint38 = findViewById(R.id.checkpoint38);
        checkpoint39 = findViewById(R.id.checkpoint39);
        checkpoint40 = findViewById(R.id.checkpoint40);

        checkpoint41 = findViewById(R.id.checkpoint41);
        checkpoint42 = findViewById(R.id.checkpoint42);
        checkpoint43 = findViewById(R.id.checkpoint43);
        checkpoint44 = findViewById(R.id.checkpoint44);
        checkpoint45 = findViewById(R.id.checkpoint45);
        checkpoint46 = findViewById(R.id.checkpoint46);
        checkpoint47 = findViewById(R.id.checkpoint47);
        checkpoint48 = findViewById(R.id.checkpoint48);
        checkpoint49 = findViewById(R.id.checkpoint49);
        checkpoint50 = findViewById(R.id.checkpoint50);

        root.setOnTouchListener(this);

        checkpoint11.setOnClickListener(onItemStatusClickListener);
        checkpoint12.setOnClickListener(onItemStatusClickListener);
        checkpoint13.setOnClickListener(onItemStatusClickListener);
        checkpoint14.setOnClickListener(onItemStatusClickListener);
        checkpoint15.setOnClickListener(onItemStatusClickListener);
        checkpoint16.setOnClickListener(onItemStatusClickListener);
        checkpoint17.setOnClickListener(onItemStatusClickListener);
        checkpoint18.setOnClickListener(onItemStatusClickListener);
        checkpoint19.setOnClickListener(onItemStatusClickListener);
        checkpoint20.setOnClickListener(onItemStatusClickListener);
        checkpoint21.setOnClickListener(onItemStatusClickListener);
        checkpoint22.setOnClickListener(onItemStatusClickListener);
        checkpoint23.setOnClickListener(onItemStatusClickListener);
        checkpoint24.setOnClickListener(onItemStatusClickListener);
        checkpoint25.setOnClickListener(onItemStatusClickListener);
        checkpoint26.setOnClickListener(onItemStatusClickListener);
        checkpoint27.setOnClickListener(onItemStatusClickListener);
        checkpoint28.setOnClickListener(onItemStatusClickListener);
        checkpoint29.setOnClickListener(onItemStatusClickListener);
        checkpoint30.setOnClickListener(onItemStatusClickListener);
        checkpoint31.setOnClickListener(onItemStatusClickListener);
        checkpoint32.setOnClickListener(onItemStatusClickListener);
        checkpoint33.setOnClickListener(onItemStatusClickListener);
        checkpoint34.setOnClickListener(onItemStatusClickListener);
        checkpoint35.setOnClickListener(onItemStatusClickListener);
        checkpoint36.setOnClickListener(onItemStatusClickListener);
        checkpoint37.setOnClickListener(onItemStatusClickListener);
        checkpoint38.setOnClickListener(onItemStatusClickListener);
        checkpoint39.setOnClickListener(onItemStatusClickListener);
        checkpoint40.setOnClickListener(onItemStatusClickListener);
        checkpoint41.setOnClickListener(onItemStatusClickListener);
        checkpoint42.setOnClickListener(onItemStatusClickListener);
        checkpoint43.setOnClickListener(onItemStatusClickListener);
        checkpoint44.setOnClickListener(onItemStatusClickListener);
        checkpoint45.setOnClickListener(onItemStatusClickListener);
        checkpoint46.setOnClickListener(onItemStatusClickListener);
        checkpoint47.setOnClickListener(onItemStatusClickListener);
        checkpoint48.setOnClickListener(onItemStatusClickListener);
        checkpoint49.setOnClickListener(onItemStatusClickListener);
        checkpoint50.setOnClickListener(onItemStatusClickListener);

        rgOperatingStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbOperatingStatus01:
                        setOperatingStatus01();
                        break;
                    case R.id.rbOperatingStatus02:
                        setOperatingStatus02();
                        break;
                    case R.id.rbOperatingStatus03:
                        setOperatingStatus03();
                        break;
                    case R.id.rbOperatingStatus04:
                        setOperatingStatus04();
                        break;
                    case R.id.rbOperatingStatus05:
                        setOperatingStatus05();
                        break;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        rgOperatingStatus.check(R.id.rbOperatingStatus01);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();

        switch(action) {
            case (MotionEvent.ACTION_DOWN) :
                Log.i("vasavsav","Action was DOWN");
                return true;
            case (MotionEvent.ACTION_MOVE) :
                Log.i("vasavsav","Action was MOVE");
                return true;
            case (MotionEvent.ACTION_UP) :
                Log.i("vasavsav","Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL) :
                Log.i("vasavsav","Action was CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE) :
                Log.i("vasavsav","Movement occurred outside bounds " +
                        "of current screen element");
                return true;
            default :
                return true;
        }
    }

    private void setOperatingStatus01() {
        checkpoint11.setActive(true);
        checkpoint12.setActive(true);
        checkpoint13.setActive(true);
        checkpoint14.setActive(true);
        checkpoint15.setActive(true);
        checkpoint16.setActive(true);
        checkpoint17.setActive(true);
        checkpoint18.setActive(true);
        checkpoint19.setActive(true);
        checkpoint20.setActive(true);

        checkpoint21.setActive(false);
        checkpoint22.setActive(true);
        checkpoint23.setActive(true);
        checkpoint24.setActive(true);
        checkpoint25.setActive(false);
        checkpoint26.setActive(false);
        checkpoint27.setActive(false);
        checkpoint28.setActive(false);
        checkpoint29.setActive(false);
        checkpoint30.setActive(false);

        checkpoint31.setActive(true);
        checkpoint32.setActive(true);
        checkpoint33.setActive(true);
        checkpoint34.setActive(true);
        checkpoint35.setActive(true);
        checkpoint36.setActive(true);
        checkpoint37.setActive(false);
        checkpoint38.setActive(false);
        checkpoint39.setActive(true);
        checkpoint40.setActive(true);

        checkpoint41.setActive(false);
        checkpoint42.setActive(false);
        checkpoint43.setActive(false);
        checkpoint44.setActive(true);
        checkpoint45.setActive(true);
        checkpoint46.setActive(false);
        checkpoint47.setActive(false);
        checkpoint48.setActive(true);
        checkpoint49.setActive(false);
        checkpoint50.setActive(false);
    }

    private void setOperatingStatus02() {
        checkpoint11.setActive(true);
        checkpoint12.setActive(true);
        checkpoint13.setActive(true);
        checkpoint14.setActive(true);
        checkpoint15.setActive(true);
        checkpoint16.setActive(true);
        checkpoint17.setActive(true);
        checkpoint18.setActive(true);
        checkpoint19.setActive(true);
        checkpoint20.setActive(true);

        checkpoint21.setActive(false);
        checkpoint22.setActive(true);
        checkpoint23.setActive(true);
        checkpoint24.setActive(true);
        checkpoint25.setActive(true);
        checkpoint26.setActive(false);
        checkpoint27.setActive(false);
        checkpoint28.setActive(false);
        checkpoint29.setActive(false);
        checkpoint30.setActive(false);

        checkpoint31.setActive(true);
        checkpoint32.setActive(true);
        checkpoint33.setActive(false);
        checkpoint34.setActive(false);
        checkpoint35.setActive(false);
        checkpoint36.setActive(false);
        checkpoint37.setActive(false);
        checkpoint38.setActive(false);
        checkpoint39.setActive(false);
        checkpoint40.setActive(false);

        checkpoint41.setActive(true);
        checkpoint42.setActive(false);
        checkpoint43.setActive(false);
        checkpoint44.setActive(true);
        checkpoint45.setActive(true);
        checkpoint46.setActive(true);
        checkpoint47.setActive(true);
        checkpoint48.setActive(false);
        checkpoint49.setActive(false);
        checkpoint50.setActive(false);
    }

    private void setOperatingStatus03() {
        checkpoint11.setActive(true);
        checkpoint12.setActive(true);
        checkpoint13.setActive(true);
        checkpoint14.setActive(true);
        checkpoint15.setActive(true);
        checkpoint16.setActive(true);
        checkpoint17.setActive(true);
        checkpoint18.setActive(true);
        checkpoint19.setActive(true);
        checkpoint20.setActive(true);

        checkpoint21.setActive(false);
        checkpoint22.setActive(true);
        checkpoint23.setActive(true);
        checkpoint24.setActive(true);
        checkpoint25.setActive(true);
        checkpoint26.setActive(false);
        checkpoint27.setActive(true);
        checkpoint28.setActive(true);
        checkpoint29.setActive(false);
        checkpoint30.setActive(false);

        checkpoint31.setActive(true);
        checkpoint32.setActive(true);
        checkpoint33.setActive(false);
        checkpoint34.setActive(false);
        checkpoint35.setActive(false);
        checkpoint36.setActive(false);
        checkpoint37.setActive(false);
        checkpoint38.setActive(false);
        checkpoint39.setActive(false);
        checkpoint40.setActive(false);

        checkpoint41.setActive(true);
        checkpoint42.setActive(true);
        checkpoint43.setActive(true);
        checkpoint44.setActive(true);
        checkpoint45.setActive(true);
        checkpoint46.setActive(true);
        checkpoint47.setActive(true);
        checkpoint48.setActive(true);
        checkpoint49.setActive(false);
        checkpoint50.setActive(false);
    }

    private void setOperatingStatus04() {
        checkpoint11.setActive(true);
        checkpoint12.setActive(true);
        checkpoint13.setActive(true);
        checkpoint14.setActive(true);
        checkpoint15.setActive(true);
        checkpoint16.setActive(true);
        checkpoint17.setActive(true);
        checkpoint18.setActive(true);
        checkpoint19.setActive(true);
        checkpoint20.setActive(true);

        checkpoint21.setActive(false);
        checkpoint22.setActive(true);
        checkpoint23.setActive(true);
        checkpoint24.setActive(true);
        checkpoint25.setActive(true);
        checkpoint26.setActive(false);
        checkpoint27.setActive(false);
        checkpoint28.setActive(false);
        checkpoint29.setActive(false);
        checkpoint30.setActive(false);

        checkpoint31.setActive(false);
        checkpoint32.setActive(false);
        checkpoint33.setActive(true);
        checkpoint34.setActive(true);
        checkpoint35.setActive(false);
        checkpoint36.setActive(false);
        checkpoint37.setActive(true);
        checkpoint38.setActive(true);
        checkpoint39.setActive(false);
        checkpoint40.setActive(false);

        checkpoint41.setActive(false);
        checkpoint42.setActive(false);
        checkpoint43.setActive(false);
        checkpoint44.setActive(false);
        checkpoint45.setActive(false);
        checkpoint46.setActive(true);
        checkpoint47.setActive(true);
        checkpoint48.setActive(false);
        checkpoint49.setActive(false);
        checkpoint50.setActive(false);
    }

    private void setOperatingStatus05() {
        checkpoint11.setActive(true);
        checkpoint12.setActive(true);
        checkpoint13.setActive(true);
        checkpoint14.setActive(true);
        checkpoint15.setActive(true);
        checkpoint16.setActive(true);
        checkpoint17.setActive(true);
        checkpoint18.setActive(true);
        checkpoint19.setActive(true);
        checkpoint20.setActive(true);

        checkpoint21.setActive(false);
        checkpoint22.setActive(true);
        checkpoint23.setActive(true);
        checkpoint24.setActive(true);
        checkpoint25.setActive(true);
        checkpoint26.setActive(false);
        checkpoint27.setActive(true);
        checkpoint28.setActive(true);
        checkpoint29.setActive(true);
        checkpoint30.setActive(true);

        checkpoint31.setActive(false);
        checkpoint32.setActive(false);
        checkpoint33.setActive(true);
        checkpoint34.setActive(true);
        checkpoint35.setActive(true);
        checkpoint36.setActive(true);
        checkpoint37.setActive(true);
        checkpoint38.setActive(true);
        checkpoint39.setActive(false);
        checkpoint40.setActive(false);

        checkpoint41.setActive(false);
        checkpoint42.setActive(false);
        checkpoint43.setActive(false);
        checkpoint44.setActive(false);
        checkpoint45.setActive(false);
        checkpoint46.setActive(true);
        checkpoint47.setActive(true);
        checkpoint48.setActive(true);
        checkpoint49.setActive(false);
        checkpoint50.setActive(false);
    }
}
