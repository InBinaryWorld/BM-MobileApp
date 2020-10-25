package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base;

import dev.szafraniak.bm_mobileapp.presentation.shared.base.BaseView;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.DetailsInterface;

public interface FormInterface<T> extends DetailsInterface<T> {

    void setOnValidationStateChanged(ChangeCallback onValidationStateChangeCallback);

    void setOnValidationStateChanged(Callback onValidationStateChangeCallback);

    void setOnValueChange(ChangeCallback onValueChangeCallback);

    void setOnValueChange(Callback onValueChangeCallback);

    void setSafeNavigationExecutor(SafeNavigationExecutor executor);

    T getValue();

    boolean isValid();

    interface SafeNavigationExecutor {
        void execute(NavigationCallback navigate);
    }

    interface NavigationCallback {
        void navigate(BaseView view);
    }

    interface ChangeCallback {
        void notifyChange(boolean isValid);
    }

    interface Callback {
        void call();
    }
}
