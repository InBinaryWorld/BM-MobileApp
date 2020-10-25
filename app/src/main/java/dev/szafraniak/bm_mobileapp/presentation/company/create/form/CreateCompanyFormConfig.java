package dev.szafraniak.bm_mobileapp.presentation.company.create.form;

import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class CreateCompanyFormConfig extends BaseFormConfig<CreateCompanyRequest> {

    public AddressFormConfig addressConfig;
    public TextFormConfig<String> nameConfig;
    public TextFormConfig<String> invoicePrefixConfig;
    public TextFormConfig<String> taxIdentityConfig;

}

