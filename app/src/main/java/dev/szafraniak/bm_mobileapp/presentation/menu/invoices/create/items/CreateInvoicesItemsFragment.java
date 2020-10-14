package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.List;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsManager;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form.InvoiceItemsConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form.InvoiceItemsForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class CreateInvoicesItemsFragment extends BaseFormFragment<List<InvoiceItemFormModel>, InvoiceItemsConfig> implements CreateInvoiceItemsView {


    @Inject
    CreateInvoiceItemsPresenter presenter;

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
        return R.string.btn_invoice_create_items;
    }

    @Override
    protected FormInterface<List<InvoiceItemFormModel>> createForm(LayoutInflater inflater, ViewGroup linearLayout, InvoiceItemsConfig config) {
        return new InvoiceItemsForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(List<InvoiceItemFormModel> object) {
        saveCurrentItems();
        presenter.generateInvoice();
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_invoice_create_Items;
    }

    @Override
    protected void executeSafeNavigation(FormInterface.NavigationCallback navigationCallback) {
        saveCurrentItems();
        navigationCallback.navigate(this);
    }

    private void saveCurrentItems() {
        CreateInvoiceFormModel model = formsManager.getCreateInvoiceFormModel();
        model.setItems(formComponent.getValue());
        formsManager.setCreateInvoiceFormModel(model);
    }

    @Override
    public void setData(List<InvoiceItemFormModel> items) {
        InvoiceItemsConfig config = presenter.createConfig();
        startForm(config, items);
    }


}
