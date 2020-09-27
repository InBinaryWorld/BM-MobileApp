package dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment;

import dev.szafraniak.bm_mobileapp.presentation.BaseView;

public interface BaseFormView extends BaseView {

    void setError(Throwable e);

    void setActionFailed(Throwable e);

    void setActionSucceed();
}
