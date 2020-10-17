package dev.szafraniak.bm_mobileapp.presentation.menu.bank;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;

import com.google.gson.Gson;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.BankAccountService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.bank.modify.BankAccountModifyFragment;
import lombok.Setter;

public class BankAccountListPresenter {

    @Setter
    BankAccountListView view;

    @Inject
    BankAccountService bankAccountService;

    @Inject
    SessionManager sessionManager;

    @Inject
    Gson gson;

    public BankAccountListPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        Long companyId = sessionManager.getCompanyId();
        bankAccountService.getBankAccounts(companyId)
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }

    public void modifyModel(BankAccount item) {
        Bundle bundle = new Bundle();
        String json = gson.toJson(item);
        bundle.putString(BankAccountModifyFragment.KEY_BANK_ACCOUNT, json);
        Navigator.navigateTo(view, FragmentFactory.FRAGMENT_BANK_ACCOUNT_MODIFY, bundle);
    }
}
