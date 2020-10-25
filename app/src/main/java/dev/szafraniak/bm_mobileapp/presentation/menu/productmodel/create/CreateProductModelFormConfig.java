package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.create;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.CreateProductModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.barcode.BarcodeFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.price.PriceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateProductModelFormConfig extends BaseFormConfig<CreateProductModelRequest> {

    public BarcodeFormConfig barcodeConfig;
    public TextFormConfig<String> nameConfig;
    public TextFormConfig<String> quantityUniteConfig;
    public PriceFormConfig priceFormConfig;

}

