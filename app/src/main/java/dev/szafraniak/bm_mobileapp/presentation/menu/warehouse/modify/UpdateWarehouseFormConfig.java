package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.UpdateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateWarehouseFormConfig extends BaseFormConfig<UpdateWarehouseRequest> {

    public TextFormConfig<String> nameConfig;
    public AddressFormConfig addressConfig;

}

