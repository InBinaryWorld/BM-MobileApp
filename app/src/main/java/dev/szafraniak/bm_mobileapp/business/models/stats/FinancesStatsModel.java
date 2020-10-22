package dev.szafraniak.bm_mobileapp.business.models.stats;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class FinancesStatsModel {

    private int EventsNumber;
    private BigDecimal currentState;
}
