package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;

public abstract class BaseFormRow<T, H extends BaseViewHolder,
        C extends BaseFormConfig<T>> extends BaseDetails<T, H, C> implements FormRowInterface<T> {

    private final FormRowValidator<T> validator;

    private Boolean lastValidationResult;
    private Callback parentCallback;

    public BaseFormRow(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        super(inflater, viewGroup, config);
        this.validator = config.getValidator();
        if (!config.isEnabled()) {
            this.disableView();
        }
    }

    protected abstract T getValueFromView();

    protected abstract void disableView();

    private T getDisabledValue() {
        switch (getConfig().getDisableValueMode()) {
            case NULL:
                return null;
            case CUSTOM:
                return getConfig().getDisableCustomValue();
            case VALUE:
            default:
                return getValueFromView();
        }
    }

    @Override
    public T getValue() {
        if (getConfig().isEnabled()) {
            return getValueFromView();
        }
        return getDisabledValue();
    }

    @Override
    public boolean isValid() {
        T value = getValue();
        return isValid(value);
    }

    protected boolean isValid(T value) {
        if (value == null) {
            return !getConfig().isRequired();
        }
        if (validator != null) {
            return validator.validate(value);
        }
        return true;
    }

    protected void onValueChange() {
        boolean isValid = isValid();
        if (isValid != lastValidationResult) {
            lastValidationResult = isValid;
            if (parentCallback != null) {
                parentCallback.notifyValidationStateChanged();
            }
        }
    }

    @Override
    public void setOnValidationStateChanged(Callback onValidationStateChangeCallback) {
        this.parentCallback = onValidationStateChangeCallback;
    }

}
