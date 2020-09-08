package dev.szafraniak.bm_mobileapp.business.http.service;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.api.BmResourcesApi;
import dev.szafraniak.bm_mobileapp.business.models.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.UpdateCompanyRequest;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CompanyService {
    @Inject
    BmResourcesApi bmResourcesApi;

    public CompanyService(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public Observable<BMCollection<Company>> getCompanies() {
        return bmResourcesApi.getCompanies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Company> createCompany(CreateCompanyRequest request) {
        return bmResourcesApi.createCompany(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Company> modifyCompany(Long companyId, UpdateCompanyRequest request) {
        return bmResourcesApi.modifyCompany(companyId, request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
