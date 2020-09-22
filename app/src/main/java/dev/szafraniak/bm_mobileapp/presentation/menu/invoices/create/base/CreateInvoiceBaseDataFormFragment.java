package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base;

import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.CreateInvoiceRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.load.BaseSRLLoadFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.utils.ViewUtils;
import timber.log.Timber;

@EFragment(R.layout.fragment_create_invoice_base)
public class CreateInvoiceBaseDataFormFragment extends BaseSRLLoadFragment {

    @ViewById(R.id.til_invoice_number)
    TextInputLayout invoiceNameLayout;

    @ViewById(R.id.et_invoice_number)
    EditText invoiceNameEditText;

    @Inject
    CreateInvoiceBaseDataFormPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        configureView();
    }

    private void configureView() {
        ViewUtils.addOnTextChangeListener(invoiceNameEditText, this::onInvoiceNameChange);
    }

    private void onInvoiceNameChange(String s) {

    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    public void setData(CreateInvoiceRequest model, Company company) {
        setInvoiceName(model, company);
        showData();
    }

    private void setInvoiceName(CreateInvoiceRequest model, Company company) {

    }


    public void setError(Throwable e) {
        Timber.e(e, "Failed To Load Create Invoice Data");
        showError();
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_create_invoice_base_data_form;
    }

}
