package dev.szafraniak.bm_mobileapp.presentation.menu.finances.modify;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.FinancesService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.FinancialRow;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.UpdateFinancialRowRequest;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormPresenter;
import retrofit2.Response;

public class FinancesEventModifyPresenter extends BaseFormPresenter<FinancialRow, FinancialEventModifyView, FinancesEventModifyFormConfig> {

    @Inject
    FinancesService financesService;

    @Inject
    SessionManager sessionManager;

    public FinancesEventModifyPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void modifyFinancialEvent(Long eventId, UpdateFinancialRowRequest request) {
        Long companyId = sessionManager.getCompanyId();
        financesService.modifyFinancialEvent(companyId, eventId, request)
            .compose(view.bindToLifecycle())
            .subscribe(this::onSuccess, this::onError);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void deleteEvent(Long eventId) {
        Long companyId = sessionManager.getCompanyId();
        financesService.deleteFinancialEvent(companyId, eventId)
            .compose(view.bindToLifecycle())
            .subscribe(this::onDeleteSucceed, this::onError);
    }

    private void onDeleteSucceed(Response<Void> voidResponse) {
        Navigator.back(view);
    }

    @Override
    public FinancesEventModifyFormConfig createConfig() {
        return FormConfigurations.getFinancesEventModifyConfig(view.getContext());
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(Long eventId) {
        Long companyId = sessionManager.getCompanyId();
        financesService.getFinancialEvent(companyId, eventId)
            .compose(view.bindToLifecycle())
            .subscribe(this::setModifyModel, view::setError);
    }

    private void setModifyModel(FinancialRow financialRow) {
        UpdateFinancialRowRequest request = new UpdateFinancialRowRequest();
        request.setTitle(financialRow.getTitle());
        request.setEventDate(financialRow.getEventDate());
        request.setAmountChange(financialRow.getAmountChange());
        request.setDescription(financialRow.getDescription());
        view.setModifyModel(request);
    }

}
