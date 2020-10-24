package dev.szafraniak.bm_mobileapp.presentation.menu.invoices;

import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListView;

public interface InvoicesView extends BaseListView<Invoice> {

    void setData(InvoicesDataModel invoicesDataModel);
}
