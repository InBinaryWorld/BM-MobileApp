package dev.szafraniak.bm_mobileapp.business.http.service.api;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.api.BmResourcesApi;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.CreateFinancialRowRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.FinancialRow;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.UpdateFinancialRowRequest;
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FinancesService {

    @Inject
    BmResourcesApi bmResourcesApi;

    public FinancesService(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public Observable<BMCollection<FinancialRow>> getFinancialEvents(Long companyId) {
        return bmResourcesApi.getFinancialEvents(companyId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<FinancialRow> getFinancialEvent(Long companyId, Long eventId) {
        return bmResourcesApi.getFinancialEvent(companyId, eventId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<FinancialRow> modifyFinancialEvent(Long companyId, Long eventId, UpdateFinancialRowRequest request) {
        return bmResourcesApi.modifyFinancialEvent(companyId, eventId, request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<FinancialRow> createFinancialEvent(Long companyId, CreateFinancialRowRequest request) {
        return bmResourcesApi.createFinancialEvent(companyId, request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

}
