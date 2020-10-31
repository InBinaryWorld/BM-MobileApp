package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment.BaseDetailsWithBtnView;

public interface CompanyContactDetailsView extends BaseDetailsWithBtnView<CompanyContact> {

    void setData(CompanyContact contact);
}
