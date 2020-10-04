package dev.szafraniak.bm_mobileapp.presentation.shared.form.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;

public abstract class BaseForm<T, H extends BaseViewHolder,
        C extends BaseFormConfig<T>> extends BaseDetails<T, H, C> implements FormInterface<T> {

    private Boolean lastValidationResult;
    private List<ChangeCallback> parentChangeStateCallbacks;
    private List<ChangeCallback> parentChangeValueCallbacks;
    private SafeNavigationExecutor safeNavigationExecutor;

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
    public void setOnValidationStateChanged(ChangeCallback onValidationStateChangeCallback) {
        this.parentChangeStateCallbacks.add(onValidationStateChangeCallback);
    }

    @Override
    public void setOnValidationStateChanged(Callback onValidationStateChangeCallback) {
        setOnValidationStateChanged(isValid -> onValidationStateChangeCallback.call());
    }

    @Override
    public void setOnValueChange(Callback onValueChangeCallback) {
        setOnValueChange(isValid -> onValueChangeCallback.call());
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
