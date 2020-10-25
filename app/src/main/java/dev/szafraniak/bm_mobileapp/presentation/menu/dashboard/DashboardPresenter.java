package dev.szafraniak.bm_mobileapp.presentation.menu.dashboard;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.CompanyService;
import dev.szafraniak.bm_mobileapp.business.http.service.api.StatisticsService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import io.reactivex.Observable;
import lombok.Setter;

public class DashboardPresenter {

    @Setter
    DashboardView view;

    @Inject
    SessionManager sessionManager;

    @Inject
    CompanyService companyService;

    @Inject
    StatisticsService statisticsService;

    public DashboardPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        Long companyId = sessionManager.getCompanyId();
        companyService.getCompany(companyId)
            .flatMap(this::appendStats)
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }


    private Observable<DashboardDataModel> appendStats(Company company) {
        return statisticsService.getCompanyStats(company.getId()).map(stats -> {
            DashboardDataModel model = new DashboardDataModel();
            model.setCompany(company);
            model.setStatsModel(stats);
            return model;
        });
    }

}
