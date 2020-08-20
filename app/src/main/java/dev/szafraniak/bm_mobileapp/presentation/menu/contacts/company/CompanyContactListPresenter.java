package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import lombok.Setter;

public class CompanyContactListPresenter {

    @Setter
    CompanyContactListView view;

    @Inject
    ContactsService contactsService;

    @Inject
    UserPreferences userPreferences;

    public CompanyContactListPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadListData() {
        contactsService.getCompanyContacts(userPreferences.getCompanyId())
                .compose(view.bindToLifecycle())
                .subscribe(view::setData, view::setError);
    }

}
