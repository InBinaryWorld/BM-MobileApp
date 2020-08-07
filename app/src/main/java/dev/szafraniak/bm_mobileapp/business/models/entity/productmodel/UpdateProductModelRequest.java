package dev.szafraniak.bm_mobileapp.business.models.entity.productmodel;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.UpdatePriceRequest;
import lombok.Data;

@Data
public class UpdateProductModelRequest {

    private String name;

    private String quantityUnit;

    private String bareCode;

    private UpdatePriceRequest priceSuggestion;

    private Long productGroupId;

}
