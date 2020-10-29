package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment;

import android.annotation.SuppressLint;
import android.app.Application;

import java.util.List;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.BankAccountService;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsManager;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceBaseFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.PaymentFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.form.CreateInvoicePaymentFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.FormConfigurations;
import lombok.Setter;

public class InvoicePaymentPresenter {

    @Inject
    BankAccountService bankAccountService;

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
        return FormConfigurations.getCreateInvoicePaymentFormConfig(view.getContext(), bankAccounts);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        CreateInvoiceFormModel createInvoiceModel = formsManager.getCreateInvoiceFormModel();
        CreateInvoiceBaseFormModel baseModel = createInvoiceModel.getBaseModel();
        PaymentFormModel paymentFormModel = baseModel.getPayment();

        Long companyId = sessionManager.getCompanyId();
        bankAccountService.getBankAccounts(companyId)
            .compose(view.bindToLifecycle())
            .subscribe(
                collection -> view.setData(paymentFormModel, collection.getItems()),
                view::setError
            );
    }

    public void savePayment(PaymentFormModel paymentFormModel) {
        CreateInvoiceFormModel createInvoiceModel = formsManager.getCreateInvoiceFormModel();
        CreateInvoiceBaseFormModel baseModel = createInvoiceModel.getBaseModel();
        baseModel.setPayment(paymentFormModel);
        formsManager.setCreateInvoiceFormModel(createInvoiceModel);
        Navigator.back(view);
    }
}
