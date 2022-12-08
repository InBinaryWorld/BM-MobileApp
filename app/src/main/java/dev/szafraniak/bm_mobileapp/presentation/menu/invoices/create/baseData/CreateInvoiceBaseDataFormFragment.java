package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceBaseFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form.CreateInvoiceBaseDataForm;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form.CreateInvoiceBaseDataFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.FormInterface;

@EFragment(R.layout.fragment_base_form)
public class CreateInvoiceBaseDataFormFragment extends BaseFormFragment<CreateInvoiceBaseFormModel, CreateInvoiceBaseDataFormConfig> implements CreateInvoiceBaseDataView {

    @Inject
    CreateInvoiceBaseDataPresenter presenter;

    @Inject
    FormsManager formsManager;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_save;
    }

    @Override
    protected void executeSafeNavigation(FormInterface.NavigationCallback navigationCallback) {
        CreateInvoiceFormModel model = formsManager.getCreateInvoiceFormModel();
        model.setBaseModel(formComponent.getValue());
        formsManager.setCreateInvoiceFormModel(model);
        navigationCallback.navigate(this);
    }

    @Override
    protected FormInterface<CreateInvoiceBaseFormModel> createForm(LayoutInflater inflater, ViewGroup linearLayout, CreateInvoiceBaseDataFormConfig config) {
        return new CreateInvoiceBaseDataForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(CreateInvoiceBaseFormModel object) {
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
    public void setData(CreateInvoiceBaseFormModel initModel, Company company) {
        CreateInvoiceBaseDataFormConfig config = presenter.createConfig(company.getInvoicePrefix());
        startForm(config, initModel);
    }
}
