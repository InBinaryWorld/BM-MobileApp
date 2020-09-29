package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base;

import android.view.LayoutInflater;
import android.widget.LinearLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class CreateInvoiceBaseDataFormFragment extends BaseFormFragment<CreateInvoiceBaseDataModel, CreateInvoiceBaseDataFormConfig> implements CreateInvoiceBaseDataView {

    @Inject
    CreateInvoiceBaseDataPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_text_invoice_create_base_data;
    }

    @Override
    protected FormInterface<CreateInvoiceBaseDataModel> createForm(LayoutInflater inflater, LinearLayout linearLayout, CreateInvoiceBaseDataFormConfig config) {
        return new CreateInvoiceBaseDataForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(CreateInvoiceBaseDataModel object) {
        presenter.goToItemsSection();
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_invoice_create_base_data;
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    public void setData(CreateInvoiceBaseDataModel initModel, Company company) {
        CreateInvoiceBaseDataFormConfig config = presenter.createConfig(company.getInvoicePrefix());
        startForm(config, initModel);
    }
}
