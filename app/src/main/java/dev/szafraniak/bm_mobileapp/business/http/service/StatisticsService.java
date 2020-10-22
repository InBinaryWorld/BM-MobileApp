package dev.szafraniak.bm_mobileapp.business.http.service;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.api.BmResourcesApi;
import dev.szafraniak.bm_mobileapp.business.models.stats.CompanyStatsModel;
import dev.szafraniak.bm_mobileapp.business.models.stats.FinancesStatsModel;
import dev.szafraniak.bm_mobileapp.business.models.stats.InvoicesStatsModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class StatisticsService {
    @Inject
    BmResourcesApi bmResourcesApi;

    public StatisticsService(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public Observable<CompanyStatsModel> getCompanyStats(Long companyId) {
        return bmResourcesApi.getCompanyStats(companyId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<FinancesStatsModel> getFinancesStats(Long companyId) {
        return bmResourcesApi.getFinancesStats(companyId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<InvoicesStatsModel> getInvoicesStats(Long companyId) {
        return bmResourcesApi.getInvoicesStats(companyId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }
}
