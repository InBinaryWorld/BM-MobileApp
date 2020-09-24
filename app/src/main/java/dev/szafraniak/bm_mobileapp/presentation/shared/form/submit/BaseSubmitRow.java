package dev.szafraniak.bm_mobileapp.presentation.shared.form.submit;

import android.view.View;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

public interface BaseSubmitRow {

    void setSubmitEnabled(boolean enabled);

    View getView();

    void setOnClickListener(BaseFormFragment.Callback onClick);
}
