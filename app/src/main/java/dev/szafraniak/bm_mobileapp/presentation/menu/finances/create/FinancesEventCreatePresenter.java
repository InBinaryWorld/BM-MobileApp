package dev.szafraniak.bm_mobileapp.presentation.menu.finances.create;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.FinancesService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.CreateFinancialRowRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.FinancialRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormPresenter;

public class FinancesEventCreatePresenter extends BaseFormPresenter<FinancialRow, FinancesEventCreateView, FinancesEventCreateFormConfig> {

    @Inject
    FinancesService financesService;

    @Inject
    SessionManager sessionManager;

    public FinancesEventCreatePresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }


    @Override
    public FinancesEventCreateFormConfig createConfig() {
        return FormConfigurations.getFinancesEventCreateConfig();
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createEvent(CreateFinancialRowRequest request) {
        Long companyId = sessionManager.getCompanyId();

        System.out.println("!!!!!!!!!! " + request.getEventDate());
        financesService.createFinancialEvent(companyId, request)
            .compose(view.bindToLifecycle())
            .subscribe(this::onSuccess, this::onError);
    }
}
