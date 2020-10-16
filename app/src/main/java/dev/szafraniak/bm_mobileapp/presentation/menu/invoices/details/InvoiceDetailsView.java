package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details;

import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment.BaseDetailsView;

public interface InvoiceDetailsView extends BaseDetailsView<Invoice> {

    void setData(Invoice invoice);

    void hideBtnProgress();

    void reload();
}
