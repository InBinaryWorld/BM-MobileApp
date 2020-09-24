package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.EditTextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TextFormConfig extends EditTextFormConfig<String> {

    private boolean readEmptyAsNull = true;

}
