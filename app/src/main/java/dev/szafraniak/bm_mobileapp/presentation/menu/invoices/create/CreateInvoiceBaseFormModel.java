package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create;

import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import lombok.Data;

@Data
public class CreateInvoiceBaseFormModel {

    private Contact buyer;

    private Contact receiver;

    private String invoiceNumber;

    private PaymentFormModel payment;

}

