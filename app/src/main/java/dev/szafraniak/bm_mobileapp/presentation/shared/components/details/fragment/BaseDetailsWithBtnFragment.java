package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.BaseDetailsConfig;

@EFragment
public abstract class BaseDetailsWithBtnFragment<T, C extends BaseDetailsConfig<T>> extends AbstractDetailsWithButtonFragment<T, C> {

    @AfterViews
    public void initializeDetailsWithBtnFragment() {
        super.initializeDetailsWithBtnFragment();
    }

}
