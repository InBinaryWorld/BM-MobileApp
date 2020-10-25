package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.price;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.BaseDetailsConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PriceDetailsConfig extends BaseDetailsConfig<Price> {

    private SimpleDetailsConfig<BigDecimal> netConfig;
    private SimpleDetailsConfig<BigDecimal> taxConfig;
    private SimpleDetailsConfig<BigDecimal> grossConfig;

}

