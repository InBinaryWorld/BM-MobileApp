package dev.szafraniak.bm_mobileapp.presentation.menu.bank.modify;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.BankAccountService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.UpdateBankAccountRequest;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormPresenter;
import retrofit2.Response;

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

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void deleteAccount(Long accountId) {
        Long companyId = sessionManager.getCompanyId();
        bankAccountService.deleteBankAccount(companyId, accountId)
            .compose(view.bindToLifecycle())
            .subscribe(this::onDeleteSucceed, this::onError);
    }

    private void onDeleteSucceed(Response<Void> voidResponse) {
        Navigator.back(view);
    }

    @Override
    public BankAccountModifyFormConfig createConfig() {
        return FormConfigurations.getBankAccountModifyFormConfig(view.getContext());
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
