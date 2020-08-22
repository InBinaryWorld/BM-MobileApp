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
    protected int getFlButtonId() {
        return R.id.flb_list_button;
    }

    @StringRes
    protected abstract int getFlButtonTextId();

    protected abstract void onFlButtonClick(View view);

    @AfterViews
    public void initializeFloatingButton() {
        flButton = (ExtendedFloatingActionButton) findViewById(getFlButtonId());
        flButton.setText(getFlButtonTextId());
        flButton.setOnClickListener(this::onFlButtonClick);
    }
}
