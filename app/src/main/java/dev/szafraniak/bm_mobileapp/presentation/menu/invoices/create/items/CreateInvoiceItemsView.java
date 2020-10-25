package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items;

import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormView;

public interface CreateInvoiceItemsView extends BaseFormView {

    void setData(List<InvoiceItemFormModel> items);

}