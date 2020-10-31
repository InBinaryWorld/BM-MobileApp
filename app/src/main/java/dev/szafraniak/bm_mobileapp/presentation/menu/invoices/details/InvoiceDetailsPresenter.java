package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details;

import android.annotation.SuppressLint;
import android.app.Application;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.InvoiceService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.business.utils.FileUtils;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment.BaseDetailsPresenter;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class InvoiceDetailsPresenter extends BaseDetailsPresenter<Invoice, InvoiceDetailsView, InvoiceDetailsConfig> {

    @Inject
    InvoiceService invoiceService;

    @Inject
    SessionManager sessionManager;

    public InvoiceDetailsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(Invoice invoice) {
        Long companyId = sessionManager.getCompanyId();
        invoiceService.getInvoice(companyId, invoice.getId())
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }

    @Override
    public InvoiceDetailsConfig createConfig() {
        return DetailsConfigurations.getInvoiceDetailsConfig(view.getContext());
    }

    public void downloadInvoice(Invoice invoice) {
        if (!FileUtils.checkPermission(view.getActivity())) {
            FileUtils.requestPermission(view.getActivity());
            view.hideBtnProgress();
            return;
        }
        downloadPDF(invoice);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
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
            String msg = view.getContext().getString(R.string.invoice_download_succeed);
            Toast.makeText(view.getContext(), msg, Toast.LENGTH_SHORT).show();
        } finally {
            view.hideBtnProgress();
        }
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void paidOffAction(Long invoiceId) {
        Long companyId = sessionManager.getCompanyId();
        invoiceService.paidOffAction(companyId, invoiceId)
            .compose(view.bindToLifecycle())
            .subscribe(this::onModifySucceed, this::onActionFailed);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void deleteInvoice(Long invoiceId) {
        Long companyId = sessionManager.getCompanyId();
        invoiceService.deleteInvoice(companyId, invoiceId)
            .compose(view.bindToLifecycle())
            .subscribe(this::onDeleteSucceed, this::onActionFailed);
    }

    private void onDeleteSucceed(Response<Void> voidResponse) {
        Navigator.back(view);
    }

    private void onActionFailed(Throwable throwable) {
        Toast.makeText(view.getContext(), R.string.toast_action_failed, Toast.LENGTH_SHORT).show();
        view.reload();
    }

    private void onModifySucceed(Invoice invoice) {
        Toast.makeText(view.getContext(), R.string.toast_action_succeed, Toast.LENGTH_SHORT).show();
        view.reload();
    }
}
