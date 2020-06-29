package dev.szafraniak.bm_mobileapp.presentation.menu.dashboard;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.HelloService;
import lombok.Setter;

public class DashboardPresenter {

    @Setter
    DashboardView view;

    @Inject
    HelloService helloService;

    public DashboardPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void notSecured() {
        helloService.getHelloMsg()
                .compose(view.bindToLifecycle())
                .subscribe(
                        e -> view.setData(e),
                        e -> view.setData(e.getMessage())
                );
    }

    public void secured() {
        helloService.getSecuredHelloMsg()
                .compose(view.bindToLifecycle())
                .subscribe(
                        e -> view.setData(e),
                        e -> view.setData(e.getMessage())
                );
    }
}
