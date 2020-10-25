package dev.szafraniak.bm_mobileapp.presentation.menu.finances;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;

import com.google.gson.Gson;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.FinancesService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.FinancialRow;
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.modify.FinancesEventModifyFragment;
import lombok.Setter;

public class FinancialEventListPresenter {

    @Setter
    FinancialEventListView view;

    @Inject
    FinancesService financesService;

    @Inject
    SessionManager sessionManager;

    @Inject
    Gson gson;

    public FinancialEventListPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        Long companyId = sessionManager.getCompanyId();
        financesService.getFinancialEvents(companyId)
            .map(this::sort)
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }

    private BMCollection<FinancialRow> sort(BMCollection<FinancialRow> collection) {
        collection.getItems().sort((a, b) -> b.getEventDate().compareTo(a.getEventDate()));
        return collection;
    }

    public void modifyModel(FinancialRow item) {
        Bundle bundle = new Bundle();
        String json = gson.toJson(item);
        bundle.putString(FinancesEventModifyFragment.KEY_FINANCIAL_EVENT, json);
        Navigator.navigateTo(view, FragmentFactory.FRAGMENT_FINANCES_MODIFY, bundle);
    }
}
