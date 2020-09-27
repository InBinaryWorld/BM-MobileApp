package dev.szafraniak.bm_mobileapp.presentation.shared.form;

import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsInterface;

public interface FormInterface<T> extends DetailsInterface<T> {

    void setOnValidationStateChanged(Callback onValidationStateChangeCallback);

    void setOnValueChange(Callback onValueChangeCallback);

    T getValue();

    boolean isValid();

    interface Callback {
        void notifyChanged(boolean isValid);
    }
}
