package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details;

import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.address.AddressDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.BaseDetailsConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class WarehouseDetailsConfig extends BaseDetailsConfig<Warehouse> {

    public SimpleDetailsConfig<String> warehouseNameConfig;
    public AddressDetailsConfig addressDetailsConfig;

}

