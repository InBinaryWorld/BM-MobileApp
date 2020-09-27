package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.EditTextFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TextEditTextFormRowConfig extends EditTextFormRowConfig<String> {

    private boolean readEmptyAsNull = true;

}
