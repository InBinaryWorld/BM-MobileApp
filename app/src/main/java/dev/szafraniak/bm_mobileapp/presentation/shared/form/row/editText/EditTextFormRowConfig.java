package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EditTextFormRowConfig<T> extends BaseFormRowConfig<T> {

    private String labelText;
    private String invalidMessage;

}
