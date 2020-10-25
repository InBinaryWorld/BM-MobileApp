package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormView;

public interface WarehouseModifyView extends BaseFormView {

    void setModifyModel(Warehouse warehouse);
}
