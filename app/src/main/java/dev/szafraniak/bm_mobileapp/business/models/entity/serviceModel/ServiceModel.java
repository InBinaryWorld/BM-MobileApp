package dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import lombok.Data;

@Data
public class ServiceModel {

    private Long id;

    private String name;

    private String quantityUnit;

    private Price priceSuggestion;

}
