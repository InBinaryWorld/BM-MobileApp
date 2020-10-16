package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details;

import android.app.Application;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.InvoiceService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.UpdateInvoiceRequest;
import dev.szafraniak.bm_mobileapp.business.utils.FileUtils;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details.state.InvoiceStatusFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment.BaseDetailsPresenter;
import okhttp3.ResponseBody;

public class InvoiceDetailsPresenter extends BaseDetailsPresenter<Invoice, InvoiceDetailsView, InvoiceDetailsConfig> {

    @Inject
    InvoiceService invoiceService;

    @Inject
    SessionManager sessionManager;

    public InvoiceDetailsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void loadData(Invoice invoice) {
        Long companyId = sessionManager.getCompanyId();
        invoiceService.getInvoice(companyId, invoice.getId())
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }

    @Override
    public InvoiceDetailsConfig createConfig() {
        InvoiceDetailsConfig config = new InvoiceDetailsConfig();
        config.setVisibleOnSetValueNull(true);
        config.setBuyerNameConfig(DetailsConfigurations.getBuyerNameConfig());
        config.setCreationDateConfig(DetailsConfigurations.getCreationDateConfig());
        config.setDueDateConfig(DetailsConfigurations.getDueDateConfiguration());
        config.setInvoiceNumberConfig(DetailsConfigurations.getInvoiceNumberConfig());
        config.setGrossConfig(DetailsConfigurations.getGrossPriceConfig());
        config.setStatusConfig(getStatusConfig());
        return config;
    }

    private InvoiceStatusFormConfig getStatusConfig() {
        HashMap<Boolean, String> map = new HashMap<>();
        map.put(true, "Paid");
        map.put(false, "Unpaid");

        InvoiceStatusFormConfig config = new InvoiceStatusFormConfig();
        config.setVisibleOnSetValueNull(false);
        config.setLabel("Payment Status");
        config.setDisplayValues(map);
        config.setDefaultValue(false);
        return config;
    }

    public void downloadInvoice(Invoice invoice) {
        if (!FileUtils.checkPermission(view.getActivity())) {
            FileUtils.requestPermission(view.getActivity());
            view.hideBtnProgress();
            return;
        }
        downloadPDF(invoice);
    }

    private void downloadPDF(Invoice invoice) {
        Long companyId = sessionManager.getCompanyId();
        invoiceService.getInvoiceDocument(companyId, invoice.getId())
            .compose(view.bindToLifecycle())
            .subscribe(response -> this.saveAndOpenPdf(invoice, response), this::onActionFailed);
    }


    private void saveAndOpenPdf(Invoice invoice, ResponseBody body) {
        try {
            File file = FileUtils.saveInvoice(invoice, body.bytes());
            FileUtils.openPDFFile(view.getActivity(), file);
        } catch (IOException e) {
            e.printStackTrace();
            String msg = "Download PDF File Failed";
            Toast.makeText(view.getContext(), msg, Toast.LENGTH_SHORT).show();
        } finally {
            view.hideBtnProgress();
        }
    }

    public void updateInvoice(Long invoiceId, UpdateInvoiceRequest updateInvoiceRequest) {
        Long companyId = sessionManager.getCompanyId();
        invoiceService.modifyInvoice(companyId, invoiceId, updateInvoiceRequest)
            .compose(view.bindToLifecycle())
            .subscribe(this::onModifySucceed, this::onActionFailed);

    }

    private void onActionFailed(Throwable throwable) {
        Toast.makeText(view.getContext(), "Action Failed", Toast.LENGTH_SHORT).show();
        view.reload();
    }

    private void onModifySucceed(Invoice invoice) {
        Toast.makeText(view.getContext(), "Action succeed", Toast.LENGTH_SHORT).show();
        view.reload();
    }
}
