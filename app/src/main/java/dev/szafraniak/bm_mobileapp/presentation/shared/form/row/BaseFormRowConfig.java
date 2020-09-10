package dev.szafraniak.bm_mobileapp.presentation.shared.form.row;

import lombok.Data;

@Data
public class BaseFormRowConfig<E, T> {

    private boolean enabled;
    private boolean required;
    private T disableCustomValue;
    private FormRowFulFiller<E, T> fulFiller;
    private FormRowDisableMode disableValueMode;

}
