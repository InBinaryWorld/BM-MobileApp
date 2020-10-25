package dev.szafraniak.bm_mobileapp.presentation.company.list;

import android.annotation.SuppressLint;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.CompanyService;
import dev.szafraniak.bm_mobileapp.business.http.service.api.StatisticsService;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
import dev.szafraniak.bm_mobileapp.business.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import lombok.Setter;

public class CompanyListPresenter {

    @Setter
    CompanyListView view;

    @Inject
    CompanyService companyService;

    @Inject
    StatisticsService statisticsService;


    public CompanyListPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        companyService.getCompanies()
            .flatMap(this::mapToModels)
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }

    private ObservableSource<List<CompanyListModel>> mapToModels(BMCollection<Company> companiesCollection) {
        List<Company> companies = companiesCollection.getItems();
        companies.sort((a, b) -> a.getName().compareTo(b.getName()));
        List<Observable<CompanyListModel>> models = companies.stream()
            .map(this::mapToModels).collect(Collectors.toList());
        if (models.size() == 0) {
            return Observable.just(new ArrayList<>());
        }
        return Observable.zip(models, new RxUtils.ObservableZipCollector<>());
    }


    private Observable<CompanyListModel> mapToModels(Company company) {
        return statisticsService.getCompanyStats(company.getId()).map(stats -> {
            CompanyListModel model = new CompanyListModel();
            model.setCompany(company);
            model.setCompanyStats(stats);
            return model;
        });
    }

}
