package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.create;

import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.CreateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateWarehouseFormConfig extends BaseFormConfig<CreateWarehouseRequest> {

    public TextEditTextFormConfig nameConfig;
    public AddressFormConfig addressConfig;

}

