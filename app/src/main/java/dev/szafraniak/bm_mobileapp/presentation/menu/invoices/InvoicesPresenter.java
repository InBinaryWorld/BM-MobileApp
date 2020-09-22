package dev.szafraniak.bm_mobileapp.presentation.menu.invoices;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.InvoiceService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import lombok.Setter;

public class InvoicesPresenter {

    @Setter
    InvoicesView view;

    @Inject
    SessionManager sessionManager;

    @Inject
    InvoiceService invoiceService;

    public InvoicesPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void loadData() {
        Long companyId = sessionManager.getCompanyId();
        invoiceService.getInvoices(companyId)
                .compose(view.bindToLifecycle())
                .subscribe(view::setData, view::setError);
    }
}
