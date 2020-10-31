package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment;

import android.view.View;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.BaseDetailsConfig;
import timber.log.Timber;

public abstract class AbstractDetailsWithButtonFragment<T, C extends BaseDetailsConfig<T>>
    extends BaseDetailsFragment<T, C> implements BaseDetailsWithBtnView<T> {

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
        startButtonProgress();
        this.onFblClick();
    }

    public void initializeDetailsWithBtnFragment() {
        this.fblBtn = (ExtendedFloatingActionButton) findViewById(getButtonId());
        this.btnProgressView = findViewById(getButtonProgressId());
        fblBtn.setText(getButtonTextId());
        fblBtn.setOnClickListener(this::onBtnClick);
        hideButtonProgress();
    }

    protected void startButtonProgress() {
        fblBtn.setVisibility(View.GONE);
        btnProgressView.setVisibility(View.VISIBLE);
    }

    protected void hideButtonProgress() {
        fblBtn.setVisibility(View.VISIBLE);
        btnProgressView.setVisibility(View.GONE);
    }

    @Override
    public void setActionFailed(Throwable e) {
        Timber.e(e);
        errorToast();
        hideButtonProgress();
    }

    @Override
    public void setActionSucceed() {
        hideButtonProgress();
    }

    public void errorToast() {
        Toast.makeText(getContext(), "Action Failed", Toast.LENGTH_SHORT).show();
    }


}
