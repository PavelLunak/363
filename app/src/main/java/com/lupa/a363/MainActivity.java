package com.lupa.a363;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_display);

        root = findViewById(R.id.root);

        root.setOnTouchListener(this);
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
}
