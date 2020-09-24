package dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment;

import dev.szafraniak.bm_mobileapp.presentation.BaseView;

public interface BaseFormView extends BaseView {

    void errorToast();

    void stopProgress();
}
