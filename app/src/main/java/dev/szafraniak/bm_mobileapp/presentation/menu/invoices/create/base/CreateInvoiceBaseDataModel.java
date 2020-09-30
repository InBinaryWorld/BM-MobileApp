package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base;

import java.time.LocalDate;

import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import lombok.Data;

@Data
public class CreateInvoiceBaseDataModel {

    private Contact buyer;

    private Contact receiver;

    private String invoiceNumber;

    private PaymentMethod paymentMethod;

    private LocalDate dueDate;

}


