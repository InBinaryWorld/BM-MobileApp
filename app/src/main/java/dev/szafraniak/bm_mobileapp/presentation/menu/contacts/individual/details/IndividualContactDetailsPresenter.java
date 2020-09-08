package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details;

import android.app.Application;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.BaseDetailsPresenter;

public class IndividualContactDetailsPresenter extends BaseDetailsPresenter<IndividualContactDetailsView, IndividualContact> {

    public IndividualContactDetailsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @Override
    public void loadData(IndividualContact contact) {
        view.setData(contact);
    }
}
