package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment.BaseDetailsView;

public interface IndividualContactDetailsView extends BaseDetailsView<IndividualContact> {

    void setData(IndividualContact individualContact);
}
