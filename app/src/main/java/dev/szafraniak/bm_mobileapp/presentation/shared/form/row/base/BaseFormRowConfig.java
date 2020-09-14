package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base;

import lombok.Data;

@Data
public class BaseFormRowConfig<E, S, T> {

    protected boolean enabled;
    protected boolean required;
    protected T disableCustomValue;
    protected FormRowParser<S, T> parser;
    protected FormRowValidator<T> validator;
    protected FormRowFulFiller<E, T> fulFiller;
    protected FormRowDisableMode disableValueMode;

}
