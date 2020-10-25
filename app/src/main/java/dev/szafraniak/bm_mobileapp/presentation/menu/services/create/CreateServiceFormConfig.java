package dev.szafraniak.bm_mobileapp.presentation.menu.services.create;

import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.CreateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.price.PriceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateServiceFormConfig extends BaseFormConfig<CreateServiceModelRequest> {

    public TextFormConfig<String> nameConfig;
    public TextFormConfig<String> quantityUniteConfig;
    public PriceFormConfig priceFormConfig;

}

