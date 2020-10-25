package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact;

import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormView;

public interface InvoiceContactView extends BaseFormView {

    void setData(Contact model, List<IndividualContact> individualContacts, List<CompanyContact> companyContacts);

}
