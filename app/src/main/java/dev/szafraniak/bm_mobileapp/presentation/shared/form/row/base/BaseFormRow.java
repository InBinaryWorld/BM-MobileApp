package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import lombok.Getter;

public abstract class BaseFormRow<P, R, S, T extends BaseViewHolder,
        U extends BaseFormRowConfig<P, R, S>> implements FormRowInterface<P> {

    @Getter
    private final U config;

    @Getter
    private final T viewHolder;

    private final FormRowParser<R, S> parser;
    private final FormRowFulFiller<P, S> fulFiller;
    private final FormRowValidator<S> validator;
    private BaseFormFragment.Callback formCallback;

    public BaseFormRow(LayoutInflater inflater, ViewGroup viewGroup, U config) {
        this.config = config;
        this.parser = config.getParser();
        this.fulFiller = config.getFulFiller();
        this.validator = config.getValidator();
        this.viewHolder = createViewHolder(inflater, viewGroup, config);
        this.setEnabled(config.isEnabled());
    }

    protected abstract T createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, U config);

    protected abstract R getValueToParse();

    protected abstract void setEnabled(boolean enabled);

    protected S getValidateValue() {
        S value = getCurrentValue();
        if (!isValid(value)) {
            return null;
        }
        return value;
    }

    private S getCurrentValue() {
        if (config.isEnabled()) {
            return getValueFromView();
        }
        return getDisabledValue();
    }

    private S getDisabledValue() {
        switch (config.getDisableValueMode()) {
            case NULL:
                return null;
            case CUSTOM:
                return config.getDisableCustomValue();
            default:
                return getValueFromView();
        }
    }

    protected S getValueFromView() {
        R value = getValueToParse();
        return parser.parse(value);
    }

    @Override
    public View getView() {
        T holder = getViewHolder();
        return holder.getView();
    }

    @Override
    public void fillModel(P model) {
        S value = getValidateValue();
        fulFiller.fulfill(model, value);
    }

    @Override
    public boolean isValid() {
        S value = getCurrentValue();
        return isValid(value);
    }

    protected boolean isValid(S value) {
        if (value == null) {
            return !config.isRequired();
        }
        return validator.validate(value);
    }

    protected void onValueChange() {
        if (formCallback != null && isValid()) {
            formCallback.call();
        }
    }

    @Override
    public void setOnChangeWithValidValue(BaseFormFragment.Callback onValueChange) {
        formCallback = onValueChange;
    }
}
