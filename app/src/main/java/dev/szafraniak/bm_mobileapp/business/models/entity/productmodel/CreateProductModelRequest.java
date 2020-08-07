package dev.szafraniak.bm_mobileapp.business.models.entity.productmodel;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.CreatePriceRequest;
import lombok.Data;

@Data
public class CreateProductModelRequest {

    private String name;

    private String quantityUnit;

    private String bareCode;

    private CreatePriceRequest priceSuggestion;

    private Long productGroupId;

}
