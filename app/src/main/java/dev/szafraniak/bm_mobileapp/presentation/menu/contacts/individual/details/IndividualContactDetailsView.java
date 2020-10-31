package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment.BaseDetailsWithBtnView;

public interface IndividualContactDetailsView extends BaseDetailsWithBtnView<IndividualContact> {

    void setData(IndividualContact individualContact);
}
