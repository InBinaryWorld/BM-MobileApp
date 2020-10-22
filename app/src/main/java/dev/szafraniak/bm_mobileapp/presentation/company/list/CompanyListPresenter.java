package dev.szafraniak.bm_mobileapp.presentation.company.list;

import android.annotation.SuppressLint;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.CompanyService;
import dev.szafraniak.bm_mobileapp.business.http.service.StatisticsService;
import dev.szafraniak.bm_mobileapp.business.models.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.stats.CompanyStatsModel;
import dev.szafraniak.bm_mobileapp.business.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
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
            .flatMap(this::appendStats)
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }

    private ObservableSource<List<CompanyListModel>> appendStats(BMCollection<Company> companiesCollection) {
        List<Company> companies = companiesCollection.getItems();
        List<Observable<CompanyListModel>> models = new ArrayList<>();
        for (Company company : companies) {
            models.add(getCompanyListModel(company));
        }
        if (models.size() == 0) {
            return Observable.just(new ArrayList<>());
        }
        return Observable.zip(models, new RxUtils.ObservableZipCollector<>());
    }


    private Observable<CompanyListModel> getCompanyListModel(Company company) {
        return statisticsService.getCompanyStats(company.getId())
            .map(new FullFillCompanyListModel(company));
    }

    private static class FullFillCompanyListModel implements Function<CompanyStatsModel, CompanyListModel> {
        private final Company company;

        public FullFillCompanyListModel(Company company) {
            this.company = company;
        }

        @Override
        public CompanyListModel apply(CompanyStatsModel companyStats) {
            CompanyListModel model = new CompanyListModel();
            model.setCompany(company);
            model.setCompanyStats(companyStats);
            return model;
        }
    }
}
