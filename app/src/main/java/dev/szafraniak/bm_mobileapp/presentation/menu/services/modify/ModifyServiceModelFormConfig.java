package dev.szafraniak.bm_mobileapp.presentation.menu.services.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.UpdateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.models.price.PriceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ModifyServiceModelFormConfig extends BaseFormConfig<UpdateServiceModelRequest> {

    public TextEditTextFormRowConfig nameConfig;
    public TextEditTextFormRowConfig quantityUniteConfig;
    public PriceFormConfig priceFormConfig;

}

