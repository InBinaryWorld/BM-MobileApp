package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.CompanyService;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsManager;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.CreateInvoiceRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRowConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.special.contact.ClickableContactFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.special.payment.ClickablePaymentFormConfig;
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
        CreateInvoiceRequest createInvoiceModel = formsManager.getCreateInvoiceModel();
        CreateInvoiceBaseDataModel invoiceBaseModel = createInitModel(createInvoiceModel);
        companyService.getCompany(companyId)
                .compose(view.bindToLifecycle())
                .subscribe(company -> view.setData(invoiceBaseModel, company), view::setError);
    }

    private CreateInvoiceBaseDataModel createInitModel(CreateInvoiceRequest model) {
        CreateInvoiceBaseDataModel initModel = new CreateInvoiceBaseDataModel();
        initModel.setInvoiceNumber(model.getInvoiceNumber());
        initModel.setReceiver(model.getReceiver());
        initModel.setBuyer(model.getBuyer());
        initModel.setDueDate(model.getDueDate());
        initModel.setPaymentMethod(model.getPaymentMethod());
        return initModel;
    }

    private TextEditTextFormRowConfig getInvoiceNumberConfig(String invoicePrefix) {
        TextEditTextFormRowConfig config = FormConfigurations.getInvoiceNumberConfig();
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
