package dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment;

import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import lombok.Setter;

public abstract class BaseFormPresenter<T, F extends BaseFormView, C extends BaseFormConfig> {

    @Setter
    protected F view;

    protected void onError(Throwable throwable) {
        view.setActionFailed(throwable);
    }

    protected void onSuccess(T object) {
        Navigator.back(view);
    }

    public abstract C createConfig();
}
