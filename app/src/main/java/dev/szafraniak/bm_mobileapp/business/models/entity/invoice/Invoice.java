package dev.szafraniak.bm_mobileapp.business.models.entity.invoice;


import java.time.LocalDate;
import java.time.OffsetDateTime;

import dev.szafraniak.bm_mobileapp.business.models.IdNameEntity;
import dev.szafraniak.bm_mobileapp.business.models.entity.amount.Amount;
import lombok.Data;

@Data
public class Invoice {

    private Long id;

    private String buyerName;

    private String fileReference;

    private Boolean isPaid;

    private String invoiceName;

    private OffsetDateTime creationDate;

    private LocalDate dueDate;

    private IdNameEntity contact;

    private Amount totalAmount;

}
