package dev.szafraniak.bm_mobileapp.presentation.company.list;

import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import lombok.Data;

@Data
public class CompanyListModel {

    private Company company;
    private String productsValue;
}
