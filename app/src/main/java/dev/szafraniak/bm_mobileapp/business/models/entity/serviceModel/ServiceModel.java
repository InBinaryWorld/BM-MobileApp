package dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.FilterValue;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceModel extends FilterValue {

    private Long id;

    private String name;

    private String quantityUnit;

    private Price priceSuggestion;

    @Override
    protected String createDescriptionForFilter() {
        return name;
    }
}
