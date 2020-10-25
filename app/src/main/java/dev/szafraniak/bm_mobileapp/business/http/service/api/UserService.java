package dev.szafraniak.bm_mobileapp.business.http.service.api;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.api.BmResourcesApi;
import dev.szafraniak.bm_mobileapp.business.models.entity.user.User;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserService {
    @Inject
    BmResourcesApi bmResourcesApi;

    public UserService(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public Observable<User> getUser() {
        return bmResourcesApi.getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
