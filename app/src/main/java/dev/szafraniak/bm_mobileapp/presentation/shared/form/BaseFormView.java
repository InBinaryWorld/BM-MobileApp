package dev.szafraniak.bm_mobileapp.presentation.shared.form;

import dev.szafraniak.bm_mobileapp.presentation.BaseView;

public interface BaseFormView extends BaseView {

    void errorToast();

    void stopProgress();
}
