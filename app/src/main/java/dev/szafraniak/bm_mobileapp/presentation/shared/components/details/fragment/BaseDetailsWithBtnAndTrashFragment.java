package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment;

import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.BaseDetailsConfig;

@EFragment
public abstract class BaseDetailsWithBtnAndTrashFragment<T, C extends BaseDetailsConfig<T>>
    extends AbstractDetailsWithButtonFragment<T, C> {

    protected View trash;

    protected int getTrashViewId() {
        return R.id.iv_trash;
    }

    @AfterViews
    public void initializeDetailsWithBtnFragment() {
        trash = findViewById(getTrashViewId());
        trash.setOnClickListener(this::onTrashClick);
        super.initializeDetailsWithBtnFragment();
    }


    private void onTrashClick(View view) {
        this.startButtonProgress();
        this.onTrash();
    }

    protected abstract void onTrash();

    @Override
    protected void startButtonProgress() {
        super.startButtonProgress();
        trash.setClickable(false);
    }

    @Override
    protected void hideButtonProgress() {
        super.hideButtonProgress();
        trash.setClickable(true);
    }

}
