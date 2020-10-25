package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.BaseDetails;

public abstract class BaseForm<T, H extends BaseViewHolder, C extends BaseFormConfig<T>>
    extends BaseDetails<T, H, C> implements FormInterface<T> {

    private Boolean lastValidationResult;
    private SafeNavigationExecutor safeNavigationExecutor;
    private final List<ChangeCallback> parentChangeStateCallbacks;
    private final List<ChangeCallback> parentChangeValueCallbacks;

    public BaseForm(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        super(inflater, viewGroup, config);
        parentChangeStateCallbacks = new ArrayList<>();
        parentChangeValueCallbacks = new ArrayList<>();
    }

    protected abstract void updateView(boolean isValid);

    protected void onValueChange() {
        boolean isValid = isValid();
        updateView(isValid);
        if (parentChangeValueCallbacks != null) {
            parentChangeValueCallbacks.forEach(callback -> callback.notifyChange(isValid));
        }
        if (lastValidationResult == null || lastValidationResult != isValid) {
            lastValidationResult = isValid;
            if (parentChangeStateCallbacks != null) {
                parentChangeStateCallbacks.forEach(callback -> callback.notifyChange(isValid));
            }
        }
    }

    @Override
    public void setOnValueChange(ChangeCallback onValueChangeCallback) {
        parentChangeValueCallbacks.add(onValueChangeCallback);
    }

    @Override
    public void setOnValueChange(Callback onValueChangeCallback) {
        setOnValueChange(isValid -> onValueChangeCallback.call());
    }

    @Override
    public void setOnValidationStateChanged(ChangeCallback onValidationStateChangeCallback) {
        this.parentChangeStateCallbacks.add(onValidationStateChangeCallback);
    }

    @Override
    public void setOnValidationStateChanged(Callback onValidationStateChangeCallback) {
        setOnValidationStateChanged(isValid -> onValidationStateChangeCallback.call());
    }

    public void setSafeNavigationExecutor(SafeNavigationExecutor executor) {
        safeNavigationExecutor = executor;
    }

    protected void executeSafeNavigation(NavigationCallback navigateAction) {
        if (safeNavigationExecutor != null) {
            safeNavigationExecutor.execute(navigateAction);
        }
    }


}
