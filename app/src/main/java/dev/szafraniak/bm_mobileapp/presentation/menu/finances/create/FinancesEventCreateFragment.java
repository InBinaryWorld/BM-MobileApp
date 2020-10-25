package dev.szafraniak.bm_mobileapp.presentation.menu.finances.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.CreateFinancialRowRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class FinancesEventCreateFragment extends BaseFormFragment<CreateFinancialRowRequest, FinancesEventCreateFormConfig> implements FinancesEventCreateView {

    @Inject
    FinancesEventCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_create_form;
    }

    @Override
    protected FormInterface<CreateFinancialRowRequest> createForm(LayoutInflater inflater, ViewGroup linearLayout, FinancesEventCreateFormConfig config) {
        return new FinancesEventCreateForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(CreateFinancialRowRequest object) {
        presenter.createEvent(object);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_financial_event_create;
    }

    @Override
    protected void loadData() {
        FinancesEventCreateFormConfig config = presenter.createConfig();
        startForm(config);
    }
}
