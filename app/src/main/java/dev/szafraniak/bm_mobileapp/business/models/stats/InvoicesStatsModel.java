package dev.szafraniak.bm_mobileapp.business.models.stats;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class InvoicesStatsModel {

    private int invoicesNumber;
    private int unpaid;
    private int paid;
    private BigDecimal unpaidValue;
    private BigDecimal paidValue;
    private BigDecimal lastInvoiceValue;
}
