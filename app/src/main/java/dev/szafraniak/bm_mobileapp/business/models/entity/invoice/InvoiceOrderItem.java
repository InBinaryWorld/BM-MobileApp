package dev.szafraniak.bm_mobileapp.business.models.entity.invoice;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class InvoiceOrderItem {

    private String name;

    private String quantityUnit;

    private BigDecimal quantity;

    private BigDecimal taxRate;

    private BigDecimal netPrice;
}
