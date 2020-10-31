package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

@EFragment
public abstract class BaseFormFragment<T, C> extends AbstractFormFragment<T, C> {

    @Override
    @AfterViews
    public void initializeBaseFormFragment() {
        super.initializeBaseFormFragment();
    }

}
