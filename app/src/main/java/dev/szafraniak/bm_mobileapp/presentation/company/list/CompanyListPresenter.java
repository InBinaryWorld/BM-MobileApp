package dev.szafraniak.bm_mobileapp.presentation.company.list;

import android.annotation.SuppressLint;
import android.app.Application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.CompanyService;
import dev.szafraniak.bm_mobileapp.business.http.service.ProductService;
import dev.szafraniak.bm_mobileapp.business.models.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
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
    ProductService productService;


    public CompanyListPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        companyService.getCompanies()
                .flatMap(this::getCompanyListModelList)
                .compose(view.bindToLifecycle())
                .subscribe(view::setData, view::setError);
    }

    private ObservableSource<List<CompanyListModel>> getCompanyListModelList(BMCollection<Company> companiesCollection) {
        List<Company> companies = companiesCollection.getItems();
        List<Observable<CompanyListModel>> models = new ArrayList<>();
        for (Company company : companies) {
            models.add(getCompanyListModel(company));
        }
        return Observable.zip(models, new RxUtils.ObservableZipCollector<>());
    }


    private Observable<CompanyListModel> getCompanyListModel(Company company) {
        return productService.getProducts(company.getId())
                .map(this::countSumOfProductValues)
                .map(new FullFillCompanyListModel(company));
    }

    private BigDecimal countSumOfProductValues(BMCollection<Product> productBMCollection) {
        return productBMCollection.getItems()
                .stream().map(product -> {
                    BigDecimal gross = product.getProductModel().getPriceSuggestion().getGross();
                    BigDecimal quantity = product.getQuantity();
                    return quantity.multiply(gross).setScale(2, RoundingMode.HALF_UP);
                }).reduce(new BigDecimal(0), BigDecimal::add);
    }


    private static class FullFillCompanyListModel implements Function<BigDecimal, CompanyListModel> {
        private final Company company;

        public FullFillCompanyListModel(Company company) {
            this.company = company;
        }

        @Override
        public CompanyListModel apply(BigDecimal sumOfProductValues) {
            CompanyListModel model = new CompanyListModel();
            model.setCompany(company);
            model.setProductsValue(MessageFormat.format("{0} {1}", sumOfProductValues, company.getCurrency()));
            return model;
        }
    }
}
