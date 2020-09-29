package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base;

import java.time.LocalDate;

import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.InvoiceContact;
import lombok.Data;

@Data
public class CreateInvoiceBaseDataModel {

    private InvoiceContact buyer;

    private InvoiceContact receiver;

    private String invoiceNumber;

    private String bankAccount;

    private LocalDate dueDate;

}


