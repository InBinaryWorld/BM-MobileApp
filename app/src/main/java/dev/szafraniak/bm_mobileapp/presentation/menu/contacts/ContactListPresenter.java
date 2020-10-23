package dev.szafraniak.bm_mobileapp.presentation.menu.contacts;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import lombok.Setter;

public class ContactListPresenter {

    @Setter
    ContactListView view;

    @Inject
    ContactsService contactsService;

    @Inject
    SessionManager sessionManager;

    public ContactListPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void loadData() {
        Long companyId = sessionManager.getCompanyId();
        contactsService.getContacts(companyId)
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }
}
