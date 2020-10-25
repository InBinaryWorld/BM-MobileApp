package dev.szafraniak.bm_mobileapp.business.models.entity.invoice;

import java.time.LocalDate;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import lombok.Data;

@Data
public class CreateInvoiceRequest {

    private Contact buyer;

    private Contact receiver;

    private String invoiceNumber;

    private PaymentMethod paymentMethod;

    private LocalDate dueDate;

    private List<InvoiceItem> items;
}
