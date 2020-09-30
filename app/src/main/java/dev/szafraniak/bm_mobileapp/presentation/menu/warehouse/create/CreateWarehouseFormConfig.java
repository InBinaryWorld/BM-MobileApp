package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.create;

import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.CreateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateWarehouseFormConfig extends BaseFormConfig<CreateWarehouseRequest> {

    public TextEditTextFormRowConfig nameConfig;
    public AddressFormConfig addressConfig;

}

