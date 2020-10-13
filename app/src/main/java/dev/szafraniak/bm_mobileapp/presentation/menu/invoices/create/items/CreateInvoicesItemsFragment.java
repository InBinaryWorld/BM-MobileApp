package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items;

import android.view.LayoutInflater;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragmentWithBtn;

@EFragment(R.layout.fragment_create_invoice_items)
public class CreateInvoicesItemsFragment extends BaseListFragmentWithBtn<InvoiceItemFormModel, CreateInvoiceItemsListAdapter> implements CreateInvoiceItemsView {

    @Inject
    CreateInvoiceItemsPresenter presenter;

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
    protected void onButtonClick(View view) {
//        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_INVOICES_CREATE_BASE_DATA);
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    public void onItemClick(InvoiceItemFormModel item) {
        presenter.modifyItem(item);
    }

    @Click(R.id.btn_add_items)
    public void addItems() {
        presenter.addItem();
    }

    @Override
    protected CreateInvoiceItemsListAdapter createAdapter() {
        return new CreateInvoiceItemsListAdapter(LayoutInflater.from(getContext()), new ArrayList<>());
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_invoice_create_Items;
    }
}
