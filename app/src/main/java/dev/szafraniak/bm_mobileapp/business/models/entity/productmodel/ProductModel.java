package dev.szafraniak.bm_mobileapp.business.models.entity.productmodel;

import dev.szafraniak.bm_mobileapp.business.models.IdNameEntity;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.FilterValue;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductModel extends FilterValue {

    private Long id;

    private String name;

    private String quantityUnit;

    private String barcode;

    private Price priceSuggestion;

    private IdNameEntity productGroup;

    @Override
    protected String createDescriptionForFilter() {
        return String.format("%s %s", name, barcode);
    }
}
