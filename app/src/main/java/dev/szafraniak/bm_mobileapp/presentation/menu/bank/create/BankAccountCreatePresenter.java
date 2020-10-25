package dev.szafraniak.bm_mobileapp.presentation.menu.bank.create;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.BankAccountService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.CreateBankAccountRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormPresenter;

public class BankAccountCreatePresenter extends BaseFormPresenter<BankAccount, BankAccountCreateView, BankAccountCreateFormConfig> {

    @Inject
    BankAccountService bankAccountService;

    @Inject
    SessionManager sessionManager;

    public BankAccountCreatePresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createCompany(CreateBankAccountRequest request) {
        Long companyId = sessionManager.getCompanyId();
        bankAccountService.createBankAccount(companyId, request)
            .compose(view.bindToLifecycle())
            .subscribe(this::onSuccess, this::onError);
    }

    @Override
    public BankAccountCreateFormConfig createConfig() {
        BankAccountCreateFormConfig config = new BankAccountCreateFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getBankAccountNameConfig());
        config.setNumberConfig(FormConfigurations.getBankAccountNumberConfig());
        return config;
    }
}
