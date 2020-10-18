package dev.szafraniak.bm_mobileapp.presentation.menu.finances.modify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.FinancialRow;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.UpdateFinancialRowRequest;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class FinancesEventModifyFragment extends BaseFormFragment<UpdateFinancialRowRequest, FinancesEventModifyFormConfig> implements FinancialEventModifyView {

    public final static String KEY_FINANCIAL_EVENT = "KEY_FINANCIAL_EVENT";

    @Inject
    Gson gson;

    @Inject
    FinancesEventModifyPresenter presenter;

    FinancialRow financialRow;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        fetchArgumentsData();
        presenter.setView(this);
    }

    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_FINANCIAL_EVENT)) {
            Navigator.back(this);
            return;
        }
        String companyJSON = args.getString(KEY_FINANCIAL_EVENT);
        financialRow = gson.fromJson(companyJSON, FinancialRow.class);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_financial_event_modify;
    }

    @Override
    protected FormInterface<UpdateFinancialRowRequest> createForm(
        LayoutInflater inflater, ViewGroup linearLayout, FinancesEventModifyFormConfig config) {
        return new FinancesEventModifyForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(UpdateFinancialRowRequest request) {
        presenter.modifyFinancialEvent(financialRow.getId(), request);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_financial_event_modify;
    }

    @Override
    protected void loadData() {
        presenter.loadData(financialRow.getId());
    }

    @Override
    public void setModifyModel(UpdateFinancialRowRequest model) {
        FinancesEventModifyFormConfig config = presenter.createConfig();
        startForm(config, model);
    }

}
