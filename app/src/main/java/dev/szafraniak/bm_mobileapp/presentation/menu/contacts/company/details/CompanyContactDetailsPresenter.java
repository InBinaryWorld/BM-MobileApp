package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details;

import android.app.Application;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.BaseDetailsPresenter;

public class CompanyContactDetailsPresenter extends BaseDetailsPresenter<CompanyContactDetailsView, CompanyContact> {

    public CompanyContactDetailsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @Override
    public void loadData(CompanyContact contact) {
        view.setData(contact);
    }
}
