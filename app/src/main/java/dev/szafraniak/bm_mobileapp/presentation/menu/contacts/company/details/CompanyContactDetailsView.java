package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment.BaseDetailsView;

public interface CompanyContactDetailsView extends BaseDetailsView<CompanyContact> {

    void setData(CompanyContact contact);
}
