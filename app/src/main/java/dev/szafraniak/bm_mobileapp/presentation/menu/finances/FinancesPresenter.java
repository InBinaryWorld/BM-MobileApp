package dev.szafraniak.bm_mobileapp.presentation.menu.finances;

import android.app.Application;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import lombok.Setter;

public class FinancesPresenter {

    @Setter
    FinancesView view;

    public FinancesPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void loadData() {
    }
}
