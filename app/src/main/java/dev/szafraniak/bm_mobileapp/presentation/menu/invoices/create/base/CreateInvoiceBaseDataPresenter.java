package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.CompanyService;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsManager;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceBaseFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.contact.ClickableContactFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.form.CreateInvoiceBaseDataFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.payment.ClickablePaymentFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
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
        CreateInvoiceBaseDataFormConfig config = new CreateInvoiceBaseDataFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setInvoiceNumberConfig(getInvoiceNumberConfig(invoicePrefix));
        config.setBuyerConfig(getBuyerConfig());
        config.setReceiverConfig(getReceiverConfig());
        config.setPaymentConfig(getPaymentConfig());
        return config;
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

    private TextFormConfig<String> getInvoiceNumberConfig(String invoicePrefix) {
        TextFormConfig<String> config = FormConfigurations.getInvoiceNumberConfig();
        config.setDefaultValue(invoicePrefix);
        return config;
    }

    private ClickableContactFormConfig getReceiverConfig() {
        ClickableContactFormConfig config = FormConfigurations.getClickableContactConfig();
        config.setLabel("Receiver");
        config.setRequired(false);
        return config;
    }

    private ClickableContactFormConfig getBuyerConfig() {
        ClickableContactFormConfig config = FormConfigurations.getClickableContactConfig();
        config.setLabel("Buyer");
        return config;
    }

    private ClickablePaymentFormConfig getPaymentConfig() {
        return FormConfigurations.getClickablePaymentConfig();
    }

}
