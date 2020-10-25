package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment;

import dev.szafraniak.bm_mobileapp.presentation.shared.base.BaseView;

public interface BaseFormView extends BaseView {

    void setError(Throwable e);

    void setActionFailed(Throwable e);

    void setActionSucceed();
}
