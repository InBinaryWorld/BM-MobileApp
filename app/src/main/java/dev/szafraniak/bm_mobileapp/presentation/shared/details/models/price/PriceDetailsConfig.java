package dev.szafraniak.bm_mobileapp.presentation.shared.details.models.price;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetailsConfig;
import lombok.Data;

@Data
public class PriceDetailsConfig extends BaseDetailsConfig<Price> {

    private SimpleDetailsConfig<BigDecimal> netConfig;
    private SimpleDetailsConfig<BigDecimal> taxConfig;
    private SimpleDetailsConfig<BigDecimal> grossConfig;

}

