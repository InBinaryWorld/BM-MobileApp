package dev.szafraniak.bm_mobileapp.presentation.shared.form.row;

import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.DetailsInterface;

public interface FormRowInterface<T> extends DetailsInterface<T> {

    void setOnValidationStateChanged(Callback onValidationStateChangeCallback);

    T getValue();

    boolean isValid();

    interface Callback {
        void notifyValidationStateChanged();
    }
}
