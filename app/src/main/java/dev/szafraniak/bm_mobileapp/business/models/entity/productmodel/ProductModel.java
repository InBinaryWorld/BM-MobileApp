package dev.szafraniak.bm_mobileapp.business.models.entity.productmodel;

import dev.szafraniak.bm_mobileapp.business.models.IdNameEntity;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import lombok.Data;

@Data
public class ProductModel {

    private Long id;

    private String name;

    private String quantityUnit;

    private String bareCode;

    private Price priceSuggestion;

    private IdNameEntity productGroup;

}
