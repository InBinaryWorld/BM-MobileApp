package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment;

import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;

@EFragment
public abstract class BaseFormWithTrashFragment<T, C> extends AbstractFormFragment<T, C> {

    protected View trash;

    protected int getTrashViewId() {
        return R.id.iv_trash;
    }

    @Override
    @AfterViews
    public void initializeBaseFormFragment() {
        trash = findViewById(getTrashViewId());
        trash.setOnClickListener(this::onTrashClick);
        super.initializeBaseFormFragment();

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
