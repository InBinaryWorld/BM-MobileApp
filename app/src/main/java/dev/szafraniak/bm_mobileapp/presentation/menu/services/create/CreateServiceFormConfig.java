package dev.szafraniak.bm_mobileapp.presentation.menu.services.create;

import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.CreateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.price.PriceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateServiceFormConfig extends BaseFormConfig<CreateServiceModelRequest> {

    public TextEditTextFormRowConfig nameConfig;
    public TextEditTextFormRowConfig quantityUniteConfig;
    public PriceFormConfig priceFormConfig;

}

