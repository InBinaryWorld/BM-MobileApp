package dev.szafraniak.bm_mobileapp.presentation.menu.bank.modify;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.BankAccountService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.UpdateBankAccountRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormPresenter;

public class BankAccountModifyPresenter extends BaseFormPresenter<BankAccount, BankAccountModifyView, BankAccountModifyFormConfig> {

    @Inject
    BankAccountService bankAccountService;

    @Inject
    SessionManager sessionManager;

    public BankAccountModifyPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void modifyBankAccount(Long accountId, UpdateBankAccountRequest request) {
        Long companyId = sessionManager.getCompanyId();
        bankAccountService.modifyBankAccount(companyId, accountId, request)
            .compose(view.bindToLifecycle())
            .subscribe(this::onSuccess, this::onError);

    }

    @Override
    public BankAccountModifyFormConfig createConfig() {
        BankAccountModifyFormConfig config = new BankAccountModifyFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getBankAccountNameConfig());
        config.setNumberConfig(FormConfigurations.getBankAccountNumberConfig());
        return config;
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(Long accountId) {
        Long companyId = sessionManager.getCompanyId();
        bankAccountService.getBankAccount(companyId, accountId)
            .compose(view.bindToLifecycle())
            .subscribe(this::setModifyModel, view::setError);
    }

    private void setModifyModel(BankAccount bankAccount) {
        UpdateBankAccountRequest request = new UpdateBankAccountRequest();
        request.setName(bankAccount.getName());
        request.setNumber(bankAccount.getNumber());
        view.setModifyModel(request);
    }

}
