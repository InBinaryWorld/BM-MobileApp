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
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceBaseFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.PaymentFormModel;
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
        b1.setName("Danuta Nowak");
        b1.setNumber("PL73103016546214735551514076");
        BankAccount b2 = new BankAccount();
        b2.setName("Jeremiasz Nawacki");
        b2.setNumber("PL73103016546214735566666666");
        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(b1);
        bankAccounts.add(b2);

        CreateInvoiceFormModel createInvoiceModel = formsManager.getCreateInvoiceFormModel();
        CreateInvoiceBaseFormModel baseModel = createInvoiceModel.getBaseModel();
        PaymentFormModel paymentFormModel = baseModel.getPayment();
        view.setData(paymentFormModel, bankAccounts);
    }

    private PaymentMethodFormConfig createPaymentConfig(List<BankAccount> bankAccounts) {
        return FormConfigurations.getPaymentMethodConfig(bankAccounts);
    }

    public void savePayment(PaymentFormModel paymentFormModel) {
        CreateInvoiceFormModel createInvoiceModel = formsManager.getCreateInvoiceFormModel();
        CreateInvoiceBaseFormModel baseModel = createInvoiceModel.getBaseModel();
        baseModel.setPayment(paymentFormModel);
        formsManager.setCreateInvoiceFormModel(createInvoiceModel);
        Navigator.back(view);
    }
}
