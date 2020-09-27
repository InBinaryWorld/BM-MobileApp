package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details;

import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment.BaseDetailsView;

public interface WarehouseDetailsView extends BaseDetailsView<Warehouse> {

    void setData(Warehouse warehouse);
}
