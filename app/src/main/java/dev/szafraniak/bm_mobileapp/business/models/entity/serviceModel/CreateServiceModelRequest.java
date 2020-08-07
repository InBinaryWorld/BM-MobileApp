package dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.CreatePriceRequest;
import lombok.Data;

@Data
public class CreateServiceModelRequest {

    private String name;

    private String quantityUnit;

    private CreatePriceRequest priceSuggestion;

}
