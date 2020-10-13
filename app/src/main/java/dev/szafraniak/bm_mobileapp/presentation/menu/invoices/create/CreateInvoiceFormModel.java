package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create;

import java.util.List;

import lombok.Data;

@Data
public class CreateInvoiceFormModel {

    private CreateInvoiceBaseFormModel baseModel;

    private List<InvoiceItemFormModel> items;

    private Long itemsIdx = 0L;

    public Long getNextItemsId() {
        return ++itemsIdx;
    }

}


