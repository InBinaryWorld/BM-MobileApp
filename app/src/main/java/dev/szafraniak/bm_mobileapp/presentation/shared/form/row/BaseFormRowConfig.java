package dev.szafraniak.bm_mobileapp.presentation.shared.form.row;

import lombok.Data;

@Data
public class BaseFormRowConfig<E, T> {

    private boolean enabled;
    private boolean required;
    private T disableCustomValue;
    private FormRowValidator<T> validator;
    private FormRowFulFiller<E, T> fulFiller;
    private FormRowFormatter<T> formatter;
    private FormRowDisableMode disableValueMode;

}
