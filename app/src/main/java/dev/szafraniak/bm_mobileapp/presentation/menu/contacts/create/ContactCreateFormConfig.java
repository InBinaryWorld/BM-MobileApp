package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.create;

import dev.szafraniak.bm_mobileapp.business.models.entity.contact.CreateContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create.CompanyContactCreateFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create.IndividualContactCreateFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.ContactType;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.baseType.BaseTypeFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class ContactCreateFormConfig extends BaseFormConfig<CreateContactRequest> {

    protected BaseTypeFormConfig<ContactType> contactTypeForm;
    protected IndividualContactCreateFormConfig individualConfig;
    protected CompanyContactCreateFormConfig companyConfig;

}

