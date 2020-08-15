package dev.szafraniak.bm_mobileapp.presentation.shared.form.row;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SimpleFormRowConfig<E, T> extends BaseFormRowConfig<E, T> {

    private T initValue;
    private String labelText;
    private String invalidMessage;
}
