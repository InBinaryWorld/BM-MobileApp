package dev.szafraniak.bm_mobileapp.presentation.menu.resources;

import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.stats.ResourcesStatsModel;
import lombok.Data;

@Data
public class ResourcesDataModel {
    BMCollection<Warehouse> warehouses;
    ResourcesStatsModel resourcesStats;
}
