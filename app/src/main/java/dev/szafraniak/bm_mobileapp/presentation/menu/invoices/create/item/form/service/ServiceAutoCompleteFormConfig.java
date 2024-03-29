package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.service;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.price.PriceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceAutoCompleteFormConfig extends BaseFormConfig<InvoiceItemFormModel> {

    private AutoCompleteTextFormConfig<String, ServiceModel> serviceNameConfig;
    private TextEditTextFormConfig quantityUnitConfig;
    public TextFormConfig<BigDecimal> quantityConfig;
    public PriceFormConfig priceFormConfig;

}
