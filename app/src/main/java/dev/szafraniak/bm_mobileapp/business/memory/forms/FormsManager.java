package dev.szafraniak.bm_mobileapp.business.memory.forms;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceBaseFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceFormModel;

public class FormsManager {

    @Inject
    FormsPreferences memory;

    @Inject
    Context context;

    public FormsManager(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void clearForms() {
        resetCreateInvoiceForm();
    }

    public void resetCreateInvoiceForm() {
        CreateInvoiceFormModel data = new CreateInvoiceFormModel();
        data.setBaseModel(new CreateInvoiceBaseFormModel());
        memory.setCreateInvoiceModel(data);
    }

    public CreateInvoiceFormModel getCreateInvoiceFormModel() {
        CreateInvoiceFormModel data = memory.getCreateInvoiceModel();
        if (data == null) {
            resetCreateInvoiceForm();
            return memory.getCreateInvoiceModel();
        }
        return data;
    }

    public void setCreateInvoiceFormModel(CreateInvoiceFormModel data) {
        memory.setCreateInvoiceModel(data);
    }

}
