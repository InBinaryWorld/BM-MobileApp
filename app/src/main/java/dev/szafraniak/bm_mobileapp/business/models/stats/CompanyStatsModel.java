package dev.szafraniak.bm_mobileapp.business.models.stats;

import lombok.Data;

@Data
public class CompanyStatsModel {

    private ResourcesStatsModel resources;
    private FinancesStatsModel finances;
    private InvoicesStatsModel invoices;
}
