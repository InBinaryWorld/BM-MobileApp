package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseFormRowConfig<T> extends BaseFormConfig<T> {

    protected boolean required;
    protected FormRowValidator<T> validator;

}
