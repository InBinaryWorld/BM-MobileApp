package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.details;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.models.price.PriceDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetailsConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductModelDetailsConfig extends BaseDetailsConfig<ProductModel> {

    public SimpleDetailsConfig<String> productModelNameConfig;
    public SimpleDetailsConfig<String> barcodeConfig;
    public SimpleDetailsConfig<String> quantityUnitConfig;
    public SimpleDetailsConfig<String> productGroupNameConfig;
    public PriceDetailsConfig priceDetailsConfig;

}

