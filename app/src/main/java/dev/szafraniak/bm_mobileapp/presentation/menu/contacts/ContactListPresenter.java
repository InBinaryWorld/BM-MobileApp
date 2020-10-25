package dev.szafraniak.bm_mobileapp.presentation.menu.contacts;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
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

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        Long companyId = sessionManager.getCompanyId();
        contactsService.getContacts(companyId)
            .map(this::sort)
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }

    private BMCollection<Contact> sort(BMCollection<Contact> collection) {
        collection.getItems().sort((a, b) -> a.getName().compareTo(b.getName()));
        return collection;
    }
}
