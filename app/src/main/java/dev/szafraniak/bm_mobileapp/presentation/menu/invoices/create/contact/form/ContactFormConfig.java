package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact.form;

import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact.form.company.CompanyAutoCompleteFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact.form.individual.IndividualAutoCompleteFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.spinner.type.BaseTypeFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContactFormConfig extends BaseFormConfig<Contact> {

    protected BaseTypeFormConfig<ContactType> contactTypeForm;
    protected IndividualAutoCompleteFormConfig individualConfig;
    protected CompanyAutoCompleteFormConfig companyConfig;

}
