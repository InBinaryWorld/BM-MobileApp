package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import lombok.Setter;

public class IndividualContactListPresenter {

    @Setter
    IndividualContactListView view;

    @Inject
    ContactsService contactsService;

    @Inject
    SessionManager sessionManager;

    public IndividualContactListPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        contactsService.getIndividualContacts(sessionManager.getCompanyId())
                .compose(view.bindToLifecycle())
                .subscribe(view::setData, view::setError);
    }

}
