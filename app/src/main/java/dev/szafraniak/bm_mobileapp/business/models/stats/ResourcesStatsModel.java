package dev.szafraniak.bm_mobileapp.business.models.stats;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ResourcesStatsModel {

    private String currency;
    private BigDecimal totalGrossValue;
    private int warehousesNumber;
    private int productsNumber;
    private int productModelsNumber;
    private int serviceModelsNumber;
}
