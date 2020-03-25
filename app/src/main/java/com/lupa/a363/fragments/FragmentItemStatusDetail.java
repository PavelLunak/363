package com.lupa.a363.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lupa.a363.MainActivity;
import com.lupa.a363.R;
import com.lupa.a363.objects.views.ItemStatusDisplay;
import com.lupa.a363.utils.AppUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentItemStatusDetail extends Fragment {

    View view;
    TextView labelText01;

    MainActivity activity;
    Bundle data;
    ItemStatusDisplay itemStatusDisplay;

    int number = 0;
    String[] strings;
    boolean active = false;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof MainActivity)
            activity = (MainActivity) context;

        data = getArguments();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_status_detail, container, false);

        labelText01 = view.findViewById(R.id.labelText01);
        itemStatusDisplay = view.findViewById(R.id.checkpoint);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (data != null) {
            strings = data.getStringArray("strings");
            number = data.getInt("number");
            active = data.getBoolean("active");
        }

        StringBuilder sb = new StringBuilder("");

        if (strings != null) {
            if (strings.length > 0) {

                for (int i = 0; i < strings.length; i++) {
                    sb.append(strings[i]);

                    if (i < (strings.length - 1))
                        sb.append("\n\n");
                }
            }
        }

        labelText01.setText(sb.toString());

        itemStatusDisplay.setActive(active);
        itemStatusDisplay.setNumber(number);

        try {
            itemStatusDisplay.setText01(AppUtils.getLabelsByCheckpointNumber(activity, number)[0]);
            itemStatusDisplay.setText02(AppUtils.getLabelsByCheckpointNumber(activity, number)[1]);
            itemStatusDisplay.setText03(AppUtils.getLabelsByCheckpointNumber(activity, number)[2]);
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
