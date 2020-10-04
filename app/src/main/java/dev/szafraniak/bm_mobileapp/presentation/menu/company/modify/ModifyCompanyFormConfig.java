package dev.szafraniak.bm_mobileapp.presentation.menu.company.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.company.UpdateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class ModifyCompanyFormConfig extends BaseFormConfig<UpdateCompanyRequest> {

    public TextFormConfig<String> nameConfig;
    public TextFormConfig<String> invoicePrefixConfig;
    public TextFormConfig<String> taxIdentityConfig;
    public AddressFormConfig addressConfig;

}

