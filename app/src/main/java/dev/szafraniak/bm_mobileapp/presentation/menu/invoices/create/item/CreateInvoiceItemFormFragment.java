package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.List;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.InvoiceItemForm;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.InvoiceItemFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class CreateInvoiceItemFormFragment extends BaseFormFragment<InvoiceItemFormModel, InvoiceItemFormConfig> implements CrateInvoiceItemFormView {

    public static final String ITEM_COMMAND_KEY = "ITEM_COMMAND_KEY";

    @Inject
    InvoiceCreateItemFormPresenter presenter;

    @Inject
    Gson gson;

    private ItemCommand command;

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
        if (args == null || !args.containsKey(ITEM_COMMAND_KEY)) {
            Navigator.back(this);
            return;
        }
        String commandJSON = args.getString(ITEM_COMMAND_KEY);
        command = gson.fromJson(commandJSON, ItemCommand.class);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_text_invoice_create_item;
    }

    @Override
    protected FormInterface<InvoiceItemFormModel> createForm(LayoutInflater inflater, ViewGroup linearLayout, InvoiceItemFormConfig config) {
        return new InvoiceItemForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(InvoiceItemFormModel item) {
        presenter.saveItem(command, item);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_invoice_create_item;
    }

    @Override
    protected void loadData() {
        presenter.loadData(command);
    }

    @Override
    public void setData(InvoiceItemFormModel item, List<ProductModel> productModels, List<ServiceModel> serviceModels) {
        InvoiceItemFormConfig config = presenter.createConfig(productModels, serviceModels);
        startForm(config, item);

    }
}
