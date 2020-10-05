package dev.szafraniak.bm_mobileapp.business.memory.forms;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceFormModel;

import static android.content.Context.MODE_PRIVATE;
import static dev.szafraniak.bm_mobileapp.business.Constance.PREFERENCES_FORMS_PREFIX;

public class FormsPreferences {

    private final static String CREATE_INVOICE_FORM_MODEL_KEY = "forms.create.invoice.model";

    private final SharedPreferences preferences;

    @Inject
    Gson gson;

    public FormsPreferences(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
        preferences = app.getSharedPreferences(PREFERENCES_FORMS_PREFIX, MODE_PRIVATE);
    }

    public void setCreateInvoiceModel(CreateInvoiceFormModel invoice) {
        String invoiceJSON = gson.toJson(invoice);
        preferences.edit().putString(CREATE_INVOICE_FORM_MODEL_KEY, invoiceJSON).apply();
    }

    public CreateInvoiceFormModel getCreateInvoiceModel() {
        String invoiceJSON = preferences.getString(CREATE_INVOICE_FORM_MODEL_KEY, null);
        return gson.fromJson(invoiceJSON, CreateInvoiceFormModel.class);
    }

}
