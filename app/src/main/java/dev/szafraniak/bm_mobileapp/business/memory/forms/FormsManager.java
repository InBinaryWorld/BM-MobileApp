package dev.szafraniak.bm_mobileapp.business.memory.forms;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.CreateInvoiceRequest;

public class FormsManager {

    @Inject
    FormsPreferences memory;

    @Inject
    Context context;

    public FormsManager(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void clearForms() {
        memory.setCreateInvoiceModel(null);
    }

    public CreateInvoiceRequest getCreateInvoiceModel() {
        CreateInvoiceRequest data = memory.getCreateInvoiceModel();
        if (data == null) {
            data = new CreateInvoiceRequest();
            memory.setCreateInvoiceModel(data);
        }
        return data;
    }

    public void setCreateInvoiceModel(CreateInvoiceRequest data) {
        memory.setCreateInvoiceModel(data);
    }

}
