package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.CompanyService;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsManager;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceBaseFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form.CreateInvoiceBaseDataFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.FormConfigurations;
import lombok.Setter;

public class CreateInvoiceBaseDataPresenter {

    @Inject
    CompanyService companyService;

    @Inject
    SessionManager sessionManager;

    @Inject
    FormsManager formsManager;

    @Setter
    protected CreateInvoiceBaseDataView view;

    public CreateInvoiceBaseDataPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void goToItemsSection() {
        Navigator.navigateTo(view, FragmentFactory.FRAGMENT_INVOICES_CREATE_ITEMS);
    }

    public CreateInvoiceBaseDataFormConfig createConfig(String invoicePrefix) {
        return FormConfigurations.getCreateInvoiceBaseDataFormConfig(view.getContext(), invoicePrefix);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        Long companyId = sessionManager.getCompanyId();
        CreateInvoiceFormModel createInvoiceModel = formsManager.getCreateInvoiceFormModel();
        CreateInvoiceBaseFormModel invoiceBaseModel = createInvoiceModel.getBaseModel();
        companyService.getCompany(companyId)
            .compose(view.bindToLifecycle())
            .subscribe(company -> view.setData(invoiceBaseModel, company), view::setError);
    }

}
