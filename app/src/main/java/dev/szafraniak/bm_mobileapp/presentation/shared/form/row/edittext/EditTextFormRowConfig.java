package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.SimpleFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EditTextFormRowConfig<E> extends SimpleFormRowConfig<E, String> {

}
