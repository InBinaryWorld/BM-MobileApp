package dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class FinancialRow {

    private Long id;

    private String title;

    private OffsetDateTime eventDate;

    private String description;

    private BigDecimal amountChange;

    private String currency;

}
