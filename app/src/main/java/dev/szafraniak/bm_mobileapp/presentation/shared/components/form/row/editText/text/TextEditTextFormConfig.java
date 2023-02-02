package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TextEditTextFormConfig extends TextFormConfig<String> {
    private int inputType;
}
