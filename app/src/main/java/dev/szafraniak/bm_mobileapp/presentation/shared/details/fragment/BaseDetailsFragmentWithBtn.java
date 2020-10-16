package dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetailsConfig;

@EFragment
public abstract class BaseDetailsFragmentWithBtn<T, C extends BaseDetailsConfig<T>> extends BaseDetailsFragment<T, C> {

    protected ExtendedFloatingActionButton fblBtn;
    protected View btnProgressView;

    @IdRes
    protected int getButtonId() {
        return R.id.flb_details_button;
    }

    @IdRes
    protected int getButtonProgressId() {
        return R.id.v_button_progress;
    }

    @StringRes
    protected abstract int getButtonTextId();

    protected abstract void onFblClick();

    private void onBtnClick(View view) {
        showProgress();
        this.onFblClick();
    }

    @AfterViews
    public void initializeBaseDetailsFragmentWithBtn() {
        this.fblBtn = (ExtendedFloatingActionButton) findViewById(getButtonId());
        this.btnProgressView = findViewById(getButtonProgressId());
        fblBtn.setText(getButtonTextId());
        fblBtn.setOnClickListener(this::onBtnClick);
        showButton();
    }

    private void showProgress() {
        fblBtn.setVisibility(View.GONE);
        btnProgressView.setVisibility(View.VISIBLE);
    }

    protected void showButton() {
        fblBtn.setVisibility(View.VISIBLE);
        btnProgressView.setVisibility(View.GONE);
    }
}
