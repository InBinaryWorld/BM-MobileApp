package dev.szafraniak.bm_mobileapp.presentation.menu.resources;

import android.app.Application;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import lombok.Setter;

public class ResourcesPresenter {

    @Setter
    ResourcesView view;

    public ResourcesPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

}
