package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment;

import android.annotation.SuppressLint;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.CompanyService;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsManager;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.CreateInvoiceRequest;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.PaymentModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.form.CreateInvoicePaymentFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.PaymentMethodFormConfig;
import lombok.Setter;

public class InvoicePaymentPresenter {

    @Inject
    CompanyService companyService;

    @Inject
    SessionManager sessionManager;

    @Inject
    FormsManager formsManager;

    @Setter
    protected InvoicePaymentView view;

    public InvoicePaymentPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void goToItemsSection() {
    }

    public CreateInvoicePaymentFormConfig createConfig(List<BankAccount> bankAccounts) {
        CreateInvoicePaymentFormConfig config = new CreateInvoicePaymentFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setPaymentConfig(createPaymentConfig(bankAccounts));
        return config;
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        Long companyId = sessionManager.getCompanyId();
//        companyService.getCompany(companyId)
//                .compose(view.bindToLifecycle())
//                .subscribe(company -> view.setData(invoiceBaseModel, company), view::setError);
        // TODO: implement valid fething data
        BankAccount b1 = new BankAccount();
        b1.setName("pierwsze konto 1");
        b1.setNumber("PL73103016546214735551514076");
        BankAccount b2 = new BankAccount();
        b2.setName("pierwsze konto 1");
        b2.setNumber("PL73103016546214735566666666");
        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(b1);
        bankAccounts.add(b2);

        CreateInvoiceRequest createInvoiceModel = formsManager.getCreateInvoiceModel();
        PaymentModel paymentModel = createInitModel(createInvoiceModel);
        view.setData(paymentModel, bankAccounts);
    }

    private PaymentModel createInitModel(CreateInvoiceRequest model) {
        PaymentModel initModel = new PaymentModel();
        initModel.setDueDate(model.getDueDate());
        initModel.setPaymentMethod(model.getPaymentMethod());
        return initModel;
    }

    private PaymentMethodFormConfig createPaymentConfig(List<BankAccount> bankAccounts) {
        return FormConfigurations.getPaymentMethodConfig(bankAccounts);
    }

}
