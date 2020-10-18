package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.labeled.LabelFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TextFormConfig<T> extends LabelFormRowConfig<T> {

    private int lines;
    private int inputType;
    private String invalidMessage;
    private boolean readEmptyAsNull;

}
