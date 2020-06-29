package dev.szafraniak.bm_mobileapp.presentation.menu.contacts;

import android.app.Application;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import lombok.Setter;

public class ContactsPresenter {

    @Setter
    ContactsView view;

    public ContactsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

}
