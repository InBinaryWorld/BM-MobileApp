package dev.szafraniak.bm_mobileapp.presentation.menu.services.details;

import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.models.price.PriceDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetailsConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceModelDetailsConfig extends BaseDetailsConfig<ServiceModel> {

    public SimpleDetailsConfig<String> serviceModelNameConfig;
    public SimpleDetailsConfig<String> quantityUnitConfig;
    public PriceDetailsConfig priceDetailsConfig;

}

