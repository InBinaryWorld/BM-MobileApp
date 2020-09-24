package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EditTextFormConfig<T> extends BaseFormConfig<T> {

    private T initValue;
    private String labelText;
    private String invalidMessage;

}
