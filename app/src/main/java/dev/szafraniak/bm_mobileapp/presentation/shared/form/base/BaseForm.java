package dev.szafraniak.bm_mobileapp.presentation.shared.form.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;

public abstract class BaseForm<T, H extends BaseViewHolder,
        C extends BaseFormConfig<T>> extends BaseDetails<T, H, C> implements FormInterface<T> {

    private Boolean lastValidationResult;
    private Callback parentChangeStateCallback;
    private Callback parentChangeValueCallback;

    public BaseForm(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        super(inflater, viewGroup, config);
    }

    protected void onValueChange() {
        boolean isValid = isValid();
        if (parentChangeValueCallback != null) {
            parentChangeValueCallback.notifyChanged(isValid);
        }
        if (lastValidationResult == null || lastValidationResult != isValid) {
            lastValidationResult = isValid;
            System.out.println("!!!!!!!!!! Change state: " + isValid);
            if (parentChangeStateCallback != null) {
                parentChangeStateCallback.notifyChanged(isValid);
            }
        }
    }

    @Override
    public void setOnValueChange(Callback onValueChangeCallback) {
        parentChangeValueCallback = onValueChangeCallback;
    }

    @Override
    public void setOnValidationStateChanged(Callback onValidationStateChangeCallback) {
        this.parentChangeStateCallback = onValidationStateChangeCallback;
    }

}
