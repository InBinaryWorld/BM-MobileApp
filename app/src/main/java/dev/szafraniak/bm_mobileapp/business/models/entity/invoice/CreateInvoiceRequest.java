package dev.szafraniak.bm_mobileapp.business.models.entity.invoice;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

import lombok.Data;

@Data
public class CreateInvoiceRequest {

    private InvoiceContact buyer;

    private InvoiceContact receiver;

    private String bankAccount;

    private LocalDate dueDate;

    private OffsetDateTime creationDate;

    private List<InvoiceOrderItem> items;
}
