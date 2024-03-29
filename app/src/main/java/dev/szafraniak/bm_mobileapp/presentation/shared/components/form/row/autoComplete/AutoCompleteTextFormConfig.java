package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete;

import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AutoCompleteTextFormConfig<T, R> extends TextFormConfig<T> {

    private int inputType;
    private String invalidMessage;
    private List<R> listItems;

}
