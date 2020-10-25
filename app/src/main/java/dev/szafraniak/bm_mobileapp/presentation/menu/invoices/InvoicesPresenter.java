package dev.szafraniak.bm_mobileapp.presentation.menu.invoices;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.InvoiceService;
import dev.szafraniak.bm_mobileapp.business.http.service.api.StatisticsService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
import io.reactivex.Observable;
import lombok.Setter;

public class InvoicesPresenter {

    @Setter
    InvoicesView view;

    @Inject
    SessionManager sessionManager;

    @Inject
    InvoiceService invoiceService;

    @Inject
    StatisticsService statisticsService;

    public InvoicesPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        Long companyId = sessionManager.getCompanyId();
        invoiceService.getInvoices(companyId)
            .flatMap(collection -> appendStats(collection, companyId))
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }

    private Observable<InvoicesDataModel> appendStats(BMCollection<Invoice> invoicesCollection, Long companyId) {
        invoicesCollection.getItems().sort((a, b) -> b.getCreationDate().compareTo(a.getCreationDate()));
        return statisticsService.getFinancesStats(companyId)
            .map(stats -> {
                InvoicesDataModel model = new InvoicesDataModel();
                model.setFinancesStats(stats);
                model.setInvoiceCollection(invoicesCollection);
                return model;
            });
    }
}
