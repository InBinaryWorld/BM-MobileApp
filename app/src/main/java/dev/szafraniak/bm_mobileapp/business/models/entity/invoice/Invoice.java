package dev.szafraniak.bm_mobileapp.business.models.entity.invoice;


import java.time.LocalDate;
import java.time.OffsetDateTime;

import dev.szafraniak.bm_mobileapp.business.models.entity.amount.Amount;
import dev.szafraniak.bm_mobileapp.business.models.mics.IdNameEntity;
import lombok.Data;

@Data
public class Invoice {

    private Long id;

    private String buyerName;

    private String fileReference;

    private Boolean isPaid;

    private String invoiceName;

    private OffsetDateTime creationDate;

    private OffsetDateTime dateOfPayment;

    private LocalDate dueDate;

    private LocalDate issueDate;

    private IdNameEntity contact;

    private Amount totalAmount;

}
