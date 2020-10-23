package dev.szafraniak.bm_mobileapp.presentation.menu.resources;

import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListView;

public interface ResourcesView extends BaseListView<Warehouse> {

    void setData(ResourcesDataModel resourcesDataModel);
}
