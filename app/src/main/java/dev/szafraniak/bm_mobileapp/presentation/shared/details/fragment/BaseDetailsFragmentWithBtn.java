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

    @IdRes
    protected int getButtonId() {
        return R.id.flb_details_button;
    }

    @StringRes
    protected abstract int getButtonTextId();

    protected abstract void onFblClick(View view);

    @AfterViews
    public void initializeBaseDetailsFragmentWithBtn() {
        this.fblBtn = (ExtendedFloatingActionButton) findViewById(getButtonId());
        fblBtn.setText(getButtonTextId());
        fblBtn.setOnClickListener(this::onFblClick);
    }

}
