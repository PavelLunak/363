package com.lupa.a363;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lupa.a363.fragments.FragmentItemStatusDetail;
import com.lupa.a363.fragments.FragmentMain;
import com.lupa.a363.fragments.FragmentStatusDisplay;
import com.lupa.a363.objects.dialogs.DialogSelectSeries;
import com.lupa.a363.objects.views.ItemStatusDisplay;
import com.lupa.a363.utils.AppConstants;
import com.lupa.a363.utils.AppUtils;
import com.lupa.a363.utils.PrefsUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements
        View.OnTouchListener,
        FragmentManager.OnBackStackChangedListener,
        AppConstants {

    TextView footerLabelSeries;
    RelativeLayout layoutFooter;

    int animShowFragment = R.anim.anim_fragment_show;
    int animHideFragment = R.anim.anim_fragment_hide;

    FragmentMain fragmentMain;
    FragmentManager fragmentManager;

    FragmentStatusDisplay fragmentStatusDisplay;
    FragmentItemStatusDetail fragmentItemStatusDetail;

    boolean isSavedInstanceState;
    int series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutFooter = findViewById(R.id.layoutFooter);
        footerLabelSeries = findViewById(R.id.footerLabelSeries);
        ;

        layoutFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogSelectSeries.createDialog(MainActivity.this)
                        .setListener(new DialogSelectSeries.OnSeriesSelectedListener() {
                            @Override
                            public void onSeriesSelected(int series) {
                                setSeries(series);
                            }
                        }).show();
            }
        });

        fragmentManager = getSupportFragmentManager();
        fragmentManager.addOnBackStackChangedListener(this);

        if (savedInstanceState == null) {
            this.series = PrefsUtils.getSeries(this);

            footerLabelSeries.setText(
                    AppUtils.seriesToRomanNumerals(this.series) +
                            ". série (" +
                            AppUtils.getSeriesRangeBySeries(this, this.series) +
                            ")");

            showFragmentMain();
        } else {
            isSavedInstanceState = true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!isSavedInstanceState) {
            if (fragmentStatusDisplay != null) {
                fragmentStatusDisplay.getRgOperatingStatus().check(R.id.rbOperatingStatus01);
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() == 1) finish();

        super.onBackPressed();
    }

    @Override
    public void onBackStackChanged() {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();

        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Log.i("vasavsav", "Action was DOWN");
                return true;
            case (MotionEvent.ACTION_MOVE):
                Log.i("vasavsav", "Action was MOVE");
                return true;
            case (MotionEvent.ACTION_UP):
                Log.i("vasavsav", "Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                Log.i("vasavsav", "Action was CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                Log.i("vasavsav", "Movement occurred outside bounds " +
                        "of current screen element");
                return true;
            default:
                return true;
        }
    }

    public void showFragmentMain() {
        fragmentMain = (FragmentMain) fragmentManager.findFragmentByTag(FRAGMENT_MAIN);

        if (fragmentMain == null) {
            fragmentMain = new FragmentMain();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(animShowFragment, animHideFragment, animShowFragment, animHideFragment);
            fragmentTransaction.add(R.id.container, fragmentMain, FRAGMENT_MAIN);
            fragmentTransaction.addToBackStack(FRAGMENT_MAIN);
            fragmentTransaction.commit();
        } else {
            int beCount = fragmentManager.getBackStackEntryCount();
            if (beCount == 0) return;
            fragmentManager.popBackStack(FRAGMENT_MAIN, 0);
        }
    }

    public void showFragmentStatusDisplay() {
        fragmentStatusDisplay = (FragmentStatusDisplay) fragmentManager.findFragmentByTag(FRAGMENT_STATUS_DISPLAY);

        if (fragmentStatusDisplay == null) {
            fragmentStatusDisplay = new FragmentStatusDisplay();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(animShowFragment, animHideFragment, animShowFragment, animHideFragment);
            fragmentTransaction.add(R.id.container, fragmentStatusDisplay, FRAGMENT_STATUS_DISPLAY);
            fragmentTransaction.addToBackStack(FRAGMENT_STATUS_DISPLAY);
            fragmentTransaction.commit();
        } else {
            int beCount = fragmentManager.getBackStackEntryCount();
            if (beCount == 0) return;
            fragmentManager.popBackStack(FRAGMENT_STATUS_DISPLAY, 0);
        }
    }

    public void showFragmentItemStatusDetail(ItemStatusDisplay itemStatusDisplay) {
        fragmentItemStatusDetail = (FragmentItemStatusDetail) fragmentManager.findFragmentByTag(FRAGMENT_ITEM_STATUS_DETAIL);

        if (fragmentItemStatusDetail == null) {
            fragmentItemStatusDetail = new FragmentItemStatusDetail();

            Bundle data = new Bundle();
            data.putInt("number", itemStatusDisplay.getNumber());
            data.putStringArray("strings", AppUtils.getStringsByCheckpointNumber(this, itemStatusDisplay.getNumber()));
            data.putBoolean("active", itemStatusDisplay.isActive());

            fragmentItemStatusDetail.setArguments(data);

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(animShowFragment, animHideFragment, animShowFragment, animHideFragment);
            fragmentTransaction.add(R.id.container, fragmentItemStatusDetail, FRAGMENT_ITEM_STATUS_DETAIL);
            fragmentTransaction.addToBackStack(FRAGMENT_ITEM_STATUS_DETAIL);
            fragmentTransaction.commit();
        } else {
            int beCount = fragmentManager.getBackStackEntryCount();
            if (beCount == 0) return;
            fragmentManager.popBackStack(FRAGMENT_ITEM_STATUS_DETAIL, 0);
        }
    }

    public boolean isSavedInstanceState() {
        return isSavedInstanceState;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
        PrefsUtils.updateSeries(this, this.series);
        if (footerLabelSeries != null)
            footerLabelSeries.setText(
                    AppUtils.seriesToRomanNumerals(this.series) +
                            ". série (" +
                            AppUtils.getSeriesRangeBySeries(this, this.series) +
                            ")");
    }
}
