package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.price;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.number.NumberEditTextFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PriceFormConfig extends BaseFormConfig<Price> {


    private Price initValue;
    protected NumberEditTextFormRowConfig netConfig;
    protected NumberEditTextFormRowConfig TaxConfig;
    protected SimpleDetailsConfig<BigDecimal> grossConfig;

}
