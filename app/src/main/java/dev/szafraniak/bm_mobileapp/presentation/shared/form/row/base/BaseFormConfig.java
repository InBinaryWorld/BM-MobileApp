package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base;

import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetailsConfig;
import lombok.Data;

@Data
public class BaseFormConfig<T> extends BaseDetailsConfig<T> {

    protected boolean enabled;
    protected boolean required;
    protected T disableCustomValue;
    protected FormRowValidator<T> validator;
    protected FormRowDisableMode disableValueMode;

}
