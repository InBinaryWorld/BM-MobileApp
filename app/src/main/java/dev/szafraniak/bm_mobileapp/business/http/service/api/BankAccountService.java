package dev.szafraniak.bm_mobileapp.business.http.service.api;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.api.BmResourcesApi;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.CreateBankAccountRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.UpdateBankAccountRequest;
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class BankAccountService {
    @Inject
    BmResourcesApi bmResourcesApi;

    public BankAccountService(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public Observable<BMCollection<BankAccount>> getBankAccounts(Long companyId) {
        return bmResourcesApi.getBankAccounts(companyId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<BankAccount> getBankAccount(Long companyId, Long accountId) {
        return bmResourcesApi.getBankAccount(companyId, accountId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<BankAccount> modifyBankAccount(Long companyId, Long accountId, UpdateBankAccountRequest request) {
        return bmResourcesApi.modifyBankAccount(companyId, accountId, request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<BankAccount> createBankAccount(Long companyId, CreateBankAccountRequest request) {
        return bmResourcesApi.createBankAccount(companyId, request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Response<Void>> deleteBankAccount(Long companyId, Long accountId) {
        return bmResourcesApi.deleteBankAccount(companyId, accountId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }
}
