package dev.szafraniak.bm_mobileapp.business.http.service;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.api.BmResourcesApi;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HelloService {
    @Inject
    BmResourcesApi bmResourcesApi;

    public HelloService(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public Observable<String> getHelloMsg() {
        return bmResourcesApi.getHello()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<String> getSecuredHelloMsg() {
        return bmResourcesApi.getSecuredHello()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
