package com.lupa.a363.objects.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.lupa.a363.R;
import com.lupa.a363.utils.AppConstants;

public class DialogYesNo extends Dialog implements AppConstants, View.OnClickListener {

    TextView btnYes;
    TextView btnNo;

    OnYesNoSelectedListener listener;
    String title;
    String message;

    public DialogYesNo(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_yes_no);

        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);

        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnYes:
                if (listener != null) listener.onYesSelected();
                break;
            case R.id.btnNo:
                if (listener != null) listener.onNoSelected();
                break;
        }

        dismiss();
    }

    public static DialogYesNo createDialog(Context context) {
        return new DialogYesNo(context);
    }

    public DialogYesNo setTitle(String title) {
        this.title = title;
        return this;
    }

    public DialogYesNo setMessage(String message) {
        this.message = message;
        return this;
    }

    public DialogYesNo setListener (OnYesNoSelectedListener listener) {
        this.listener = listener;
        return this;
    }

    public interface OnYesNoSelectedListener {
        void onYesSelected();
        void onNoSelected();
    }
}
