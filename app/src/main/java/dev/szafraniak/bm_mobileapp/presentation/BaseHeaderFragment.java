package dev.szafraniak.bm_mobileapp.presentation;


import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;

@EFragment
public abstract class BaseHeaderFragment extends BaseFragment {

    protected TextView headerTextView;

    @IdRes
    protected int getHeaderTextViewId() {
        return R.id.tv_header_text;
    }

    @AfterViews
    public void initializeHeader() {
        headerTextView = (TextView) findViewById(getHeaderTextViewId());
        headerTextView.setText(getHeaderTextResourceId());
    }

    @StringRes
    protected abstract int getHeaderTextResourceId();

}
