package dev.szafraniak.bm_mobileapp.business.models.entity.productmodel;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import lombok.Data;

@Data
public class CreateProductModelRequest {

    private String name;

    private String quantityUnit;

    private String barcode;

    private Price priceSuggestion;

    private Long productGroupId;

}
