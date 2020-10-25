package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormView;

public interface CompanyContactModifyView extends BaseFormView {

    void setModifyModel(CompanyContact contact);

}
