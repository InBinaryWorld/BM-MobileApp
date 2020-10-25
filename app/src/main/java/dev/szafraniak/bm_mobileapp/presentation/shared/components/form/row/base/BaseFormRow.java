package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;

public abstract class BaseFormRow<T, H extends BaseViewHolder,
        C extends BaseFormRowConfig<T>> extends BaseForm<T, H, C> {

    private final FormRowValidator<T> validator;

    public BaseFormRow(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        super(inflater, viewGroup, config);
        this.validator = config.getValidator();
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

}
