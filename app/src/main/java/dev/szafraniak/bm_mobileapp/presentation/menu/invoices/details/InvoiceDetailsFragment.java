package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment.BaseDetailsFragmentWithBtn;

@EFragment(R.layout.fragment_base_details)
public class InvoiceDetailsFragment extends BaseDetailsFragmentWithBtn<Invoice, InvoiceDetailsConfig>
    implements InvoiceDetailsView {

    public final static String KEY_INVOICE = "KEY_INVOICE";

    @Inject
    InvoiceDetailsPresenter presenter;

    @Inject
    Gson gson;

    Invoice invoice;

    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_INVOICE)) {
            Navigator.back(this);
            return;
        }
        String invoiceJSON = getArguments().getString(KEY_INVOICE);
        invoice = gson.fromJson(invoiceJSON, Invoice.class);
    }

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        fetchArgumentsData();
        presenter.setView(this);
    }

    @Override
    protected void loadData() {
        presenter.loadData(invoice);
    }

    public void setData(Invoice model) {
        InvoiceDetailsConfig config = presenter.createConfig();
        startForm(config, model);
    }

    @Override
    public void hideBtnProgress() {
        this.showButton();
    }

    @Override
    protected DetailsInterface<Invoice> createForm(LayoutInflater inflater, ViewGroup viewGroup, InvoiceDetailsConfig config) {
        return new InvoiceDetails(inflater, detailsLayout, config);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_invoice_details;
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_invoice_details_download;
    }

    @Override
    protected void onFblClick() {
        presenter.downloadInvoice(invoice);
    }


}
