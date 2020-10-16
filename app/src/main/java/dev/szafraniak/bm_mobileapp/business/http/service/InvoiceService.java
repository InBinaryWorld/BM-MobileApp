package dev.szafraniak.bm_mobileapp.business.http.service;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.api.BmResourcesApi;
import dev.szafraniak.bm_mobileapp.business.models.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.CreateInvoiceRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.UpdateInvoiceRequest;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class InvoiceService {
    @Inject
    BmResourcesApi bmResourcesApi;

    public InvoiceService(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public Observable<BMCollection<Invoice>> getInvoices(Long companyId) {
        return bmResourcesApi.getInvoices(companyId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Invoice> getInvoice(Long companyId, Long invoiceId) {
        return bmResourcesApi.getInvoice(companyId, invoiceId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ResponseBody> getInvoiceDocument(Long companyId, Long invoiceId) {
        return bmResourcesApi.getInvoiceDocument(companyId, invoiceId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Invoice> createInvoice(Long companyId, CreateInvoiceRequest model) {
        return bmResourcesApi.createInvoice(companyId, model)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Invoice> modifyInvoice(Long companyId,
                                             Long invoiceId,
                                             UpdateInvoiceRequest model) {
        return bmResourcesApi.modifyInvoice(companyId, invoiceId, model)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

}
