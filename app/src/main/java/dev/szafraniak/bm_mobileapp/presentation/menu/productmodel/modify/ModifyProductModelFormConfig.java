package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.UpdateProductModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.barcode.BarcodeFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.price.PriceFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ModifyProductModelFormConfig extends BaseFormConfig<UpdateProductModelRequest> {

    public BarcodeFormConfig barcodeConfig;
    public TextEditTextFormConfig nameConfig;
    public TextEditTextFormConfig quantityUniteConfig;
    public PriceFormConfig priceFormConfig;

}

