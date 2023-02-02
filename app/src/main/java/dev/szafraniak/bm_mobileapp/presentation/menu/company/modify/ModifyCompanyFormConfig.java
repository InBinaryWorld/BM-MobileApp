package dev.szafraniak.bm_mobileapp.presentation.menu.company.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.company.UpdateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class ModifyCompanyFormConfig extends BaseFormConfig<UpdateCompanyRequest> {

    public AddressFormConfig addressConfig;
    public TextEditTextFormConfig nameConfig;
    public TextEditTextFormConfig taxIdentityConfig;
    public TextEditTextFormConfig invoiceLogoConfig;
    public TextEditTextFormConfig invoicePrefixConfig;

}

