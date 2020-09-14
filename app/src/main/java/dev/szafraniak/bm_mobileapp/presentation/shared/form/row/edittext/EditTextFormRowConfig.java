package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EditTextFormRowConfig<E> extends BaseFormRowConfig<E, String, String> {

    private String initValue;
    private String labelText;
    private String invalidMessage;

}
