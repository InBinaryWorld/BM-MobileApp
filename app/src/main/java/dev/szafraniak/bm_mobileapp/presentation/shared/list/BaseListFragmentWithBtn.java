package dev.szafraniak.bm_mobileapp.presentation.shared.list;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;

@EFragment
public abstract class BaseListFragmentWithBtn<T> extends BaseListFragment<T> {


    protected ExtendedFloatingActionButton flButton;

    @IdRes
    protected int getButtonId() {
        return R.id.flb_list_button;
    }

    @StringRes
    protected abstract int getButtonTextId();

    protected abstract void onButtonClick(View view);

    @AfterViews
    public void initializeFloatingButton() {
        flButton = (ExtendedFloatingActionButton) findViewById(getButtonId());
        flButton.setText(getButtonTextId());
        flButton.setOnClickListener(this::onButtonClick);
    }
}
