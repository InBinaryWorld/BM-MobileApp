package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.UpdateProductModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.price.PriceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ModifyProductModelFormConfig extends BaseFormConfig<UpdateProductModelRequest> {

    public TextEditTextFormRowConfig nameConfig;
    public TextEditTextFormRowConfig bareCodeConfig;
    public TextEditTextFormRowConfig quantityUniteConfig;
    public PriceFormConfig priceFormConfig;

}

