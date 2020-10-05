package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create;

import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.InvoiceOrderItem;
import lombok.Data;

@Data
public class CreateInvoiceFormModel {

    private CreateInvoiceBaseFormModel baseModel;

    private List<InvoiceOrderItem> items;
}


