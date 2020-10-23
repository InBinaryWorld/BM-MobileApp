package dev.szafraniak.bm_mobileapp.presentation.menu.dashboard;

import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.stats.CompanyStatsModel;
import lombok.Data;

@Data
public class DashboardDataModel {

    private Company company;
    private CompanyStatsModel statsModel;

}
