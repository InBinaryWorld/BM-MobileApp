package dev.szafraniak.bm_mobileapp.presentation.shared.details;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;

@EFragment
public abstract class BaseDetailsFragmentWithBtn<T> extends BaseDetailsFragment<T> {

    protected ExtendedFloatingActionButton fblBtn;

    @IdRes
    protected int getPFblBtnId() {
        return R.id.flb_details_button;
    }

    @StringRes
    protected abstract int getFblBtnTextResourceId();

    protected abstract void onFblClick(View view);

    @AfterViews
    public void initializeBaseDetailsFragmentWithBtn() {
        this.fblBtn = (ExtendedFloatingActionButton) findViewById(getPFblBtnId());
        fblBtn.setText(getFblBtnTextResourceId());
        fblBtn.setOnClickListener(this::onFblClick);
    }


}
