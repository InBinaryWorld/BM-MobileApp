package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormView;

public interface IndividualContactModifyView extends BaseFormView {

    void setModifyModel(IndividualContact individualContact);
}
