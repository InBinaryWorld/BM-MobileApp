package dev.szafraniak.bm_mobileapp.presentation.menu.company.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.company.UpdateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class ModifyCompanyFormConfig extends BaseFormConfig<UpdateCompanyRequest> {

    public AddressFormConfig addressConfig;
    public TextFormConfig<String> nameConfig;
    public TextFormConfig<String> taxIdentityConfig;
    public TextFormConfig<String> invoicePrefixConfig;

}

