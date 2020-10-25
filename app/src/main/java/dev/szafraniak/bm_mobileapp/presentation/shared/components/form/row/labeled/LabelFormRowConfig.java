package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.labeled;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LabelFormRowConfig<T> extends BaseFormRowConfig<T> {

    protected String label;

}
