package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.price;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PriceFormConfig extends BaseFormConfig<Price> {

    protected TextFormConfig<BigDecimal> netConfig;
    protected TextFormConfig<BigDecimal> TaxConfig;
    protected SimpleDetailsConfig<BigDecimal> grossConfig;

}
