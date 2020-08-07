package dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.UpdatePriceRequest;
import lombok.Data;

@Data
public class UpdateServiceModelRequest {

    private String name;

    private String quantityUnit;

    private UpdatePriceRequest priceSuggestion;

}
