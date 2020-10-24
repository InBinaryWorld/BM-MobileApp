package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form;

import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.product.ProductAutoCompleteFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.service.ServiceAutoCompleteFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.baseType.BaseTypeFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InvoiceItemFormConfig extends BaseFormConfig<InvoiceItemFormModel> {

    protected BaseTypeFormConfig<ItemType> ItemTypeForm;
    protected ProductAutoCompleteFormConfig ProductConfig;
    protected ServiceAutoCompleteFormConfig ServiceConfig;

}
