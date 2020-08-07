package dev.szafraniak.bm_mobileapp.presentation.company.list;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.UserService;
import dev.szafraniak.bm_mobileapp.business.models.BMCollection;
import lombok.Setter;

public class CompanyListPresenter {

    @Setter
    CompanyListView view;

    @Inject
    UserService userService;


    public CompanyListPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void loadListData() {
        userService.getCompanies()
                .compose(view.bindToLifecycle())
                .map(BMCollection::getItems)
                .subscribe(view::setData, view::setError);
    }
}
