package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.number;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.EditTextFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NumberEditTextFormRowConfig extends EditTextFormRowConfig<BigDecimal> {

    private boolean zeroOnEmpty = false;

}
