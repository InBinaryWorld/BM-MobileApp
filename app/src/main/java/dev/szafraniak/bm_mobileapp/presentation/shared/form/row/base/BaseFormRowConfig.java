package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseFormRowConfig<T> extends BaseFormConfig<T> {

    protected boolean required;
    protected FormRowValidator<T> validator;

}
