package com.lupa.a363.objects.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.lupa.a363.R;
import com.lupa.a363.utils.AppConstants;

public class DialogInfo extends Dialog implements AppConstants {

    TextView btnClose;

    OnDialogInfoClosedListener listener;
    String title;
    String message;

    public DialogInfo(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_info);

        btnClose = findViewById(R.id.btnClose);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) listener.onDialogClosed();
                dismiss();
            }
        });
    }

    public static DialogInfo createDialog(Context context) {
        return new DialogInfo(context);
    }

    public DialogInfo setTitle(String title) {
        this.title = title;
        return this;
    }

    public DialogInfo setMessage(String message) {
        this.message = message;
        return this;
    }

    public DialogInfo setListener (OnDialogInfoClosedListener listener) {
        this.listener = listener;
        return this;
    }

    public interface OnDialogInfoClosedListener {
        void onDialogClosed();
    }
}
