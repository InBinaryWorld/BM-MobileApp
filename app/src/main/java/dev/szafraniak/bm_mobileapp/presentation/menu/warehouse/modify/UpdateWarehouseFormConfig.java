package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.UpdateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateWarehouseFormConfig extends BaseFormConfig<UpdateWarehouseRequest> {

    public TextEditTextFormConfig nameConfig;
    public AddressFormConfig addressConfig;

}

