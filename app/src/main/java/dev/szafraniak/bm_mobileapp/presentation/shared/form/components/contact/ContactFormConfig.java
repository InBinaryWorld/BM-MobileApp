package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact;

import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.company.CompanyAutoCompleteFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.individual.IndividualAutoCompleteFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.type.ContactTypeFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContactFormConfig extends BaseFormConfig<Contact> {

    protected ContactTypeFormConfig contactTypeForm;
    protected IndividualAutoCompleteFormConfig individualConfig;
    protected CompanyAutoCompleteFormConfig companyConfig;

}
