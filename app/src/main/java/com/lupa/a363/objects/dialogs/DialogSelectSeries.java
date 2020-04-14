package com.lupa.a363.objects.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.lupa.a363.R;
import com.lupa.a363.utils.AppConstants;


public class DialogSelectSeries extends Dialog implements
        AppConstants,
        View.OnClickListener {

    OnSeriesSelectedListener listener;

    LinearLayout
            dialogLayoutSeries1,
            dialogLayoutSeries2,
            dialogLayoutSeries3,
            dialogLayoutSeries4,
            dialogLayoutSeries5;

    Context context;

    public DialogSelectSeries(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_select_series);

        dialogLayoutSeries1 = findViewById(R.id.dialog_layout_series_1);
        dialogLayoutSeries2 = findViewById(R.id.dialog_layout_series_2);
        dialogLayoutSeries3 = findViewById(R.id.dialog_layout_series_3);
        dialogLayoutSeries4 = findViewById(R.id.dialog_layout_series_4);
        dialogLayoutSeries5 = findViewById(R.id.dialog_layout_series_5);

        dialogLayoutSeries1.setOnClickListener(this);
        dialogLayoutSeries2.setOnClickListener(this);
        dialogLayoutSeries3.setOnClickListener(this);
        dialogLayoutSeries4.setOnClickListener(this);
        dialogLayoutSeries5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_layout_series_1:
                if (listener != null) listener.onSeriesSelected(AppConstants.SERIES_1);
                break;
            case R.id.dialog_layout_series_2:
                if (listener != null) listener.onSeriesSelected(AppConstants.SERIES_2);
                break;
            case R.id.dialog_layout_series_3:
                if (listener != null) listener.onSeriesSelected(AppConstants.SERIES_3);
                break;
            case R.id.dialog_layout_series_4:
                if (listener != null) listener.onSeriesSelected(AppConstants.SERIES_4);
                break;
            case R.id.dialog_layout_series_5:
                if (listener != null) listener.onSeriesSelected(AppConstants.SERIES_5);
                break;
        }

        dismiss();
    }

    public static DialogSelectSeries createDialog(Context context) {
        return new DialogSelectSeries(context);
    }

    public DialogSelectSeries setListener (OnSeriesSelectedListener listener) {
        this.listener = listener;
        return this;
    }

    public interface OnSeriesSelectedListener {
        void onSeriesSelected(int series);
    }
}
