package dev.szafraniak.bm_mobileapp.presentation.shared.form.row;

import android.view.View;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;

public interface FormRowInterface<T> {

    View getView();

    void setOnChangeWithValidValue(BaseFormFragment.Callback onValueChange);

    void fillModel(T model);

    boolean isValid();
}
