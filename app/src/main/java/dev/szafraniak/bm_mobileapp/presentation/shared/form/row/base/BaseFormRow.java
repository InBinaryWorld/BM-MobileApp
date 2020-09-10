package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowFormatter;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowFulFiller;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowValidator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.SimpleFormRowConfig;
import lombok.Getter;

public abstract class BaseFormRow<T, R, H extends BaseViewHolder,
        C extends SimpleFormRowConfig<T, R>> implements FormRowInterface<T> {

    @Getter
    private final C config;

    @Getter
    private final H viewHolder;

    private final FormRowFormatter<R> formatter;
    private final FormRowFulFiller<T, R> fulFiller;
    private final FormRowValidator<R> validator;

    public BaseFormRow(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        this.config = config;
        this.formatter = config.getFormatter();
        this.fulFiller = config.getFulFiller();
        this.validator = config.getValidator();
        this.viewHolder = createViewHolder(inflater, viewGroup, config);
        this.setEnabled(config.isEnabled());
    }

    protected abstract H createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, C config);

    protected abstract R getOriginalValue();

    protected abstract boolean isEnabled();

    protected abstract void setEnabled(boolean enabled);

    protected R getValue() {
        if (isEnabled()) {
            return getFormattedValue();
        }
        return getDisabledValue();
    }

    private R getDisabledValue() {
        switch (config.getDisableValueMode()) {
            case NULL:
                return null;
            case CUSTOM:
                return config.getDisableCustomValue();
            default:
                return getFormattedValue();
        }
    }

    private R getFormattedValue() {
        R value = getOriginalValue();
        return formatter.format(value);
    }

    @Override
    public View getView() {
        H holder = getViewHolder();
        return holder.getView();
    }

    @Override
    public void fillModel(T model) {
        R value = getValue();
        fulFiller.fulfill(model, value);
    }

    @Override
    public boolean isValid() {
        R value = getValue();
        if (value == null) {
            return !config.isRequired();
        }
        return validator.validate(value);
    }

}
