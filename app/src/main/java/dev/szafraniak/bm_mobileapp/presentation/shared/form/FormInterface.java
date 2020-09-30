package dev.szafraniak.bm_mobileapp.presentation.shared.form;

import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsInterface;

public interface FormInterface<T> extends DetailsInterface<T> {

    void setOnValidationStateChanged(ChangeCallback onValidationStateChangeCallback);

    void setOnValueChange(ChangeCallback onValueChangeCallback);

    T getValue();

    boolean isValid();

}
