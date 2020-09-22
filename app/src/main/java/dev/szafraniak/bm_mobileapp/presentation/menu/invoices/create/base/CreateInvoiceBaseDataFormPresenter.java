package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.CompanyService;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsManager;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.CreateInvoiceRequest;
import lombok.Setter;

public class CreateInvoiceBaseDataFormPresenter {

    @Setter
    CreateInvoiceBaseDataFormFragment view;

    @Inject
    SessionManager sessionManager;

    @Inject
    FormsManager formsManager;

    @Inject
    CompanyService companyService;

    public CreateInvoiceBaseDataFormPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        Long companyId = sessionManager.getCompanyId();
        companyService.getCompany(companyId)
                .compose(view.bindToLifecycle())
                .subscribe(this::onNext, this::onError);
    }

    private void onError(Throwable throwable) {
        view.setError(throwable);
    }

    private void onNext(Company company) {
        CreateInvoiceRequest model = formsManager.getCreateInvoiceModel();
        view.setData(model, company);
    }
}
