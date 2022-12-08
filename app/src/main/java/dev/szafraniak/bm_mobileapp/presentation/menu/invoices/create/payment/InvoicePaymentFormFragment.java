package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.List;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.PaymentFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.form.CreateInvoicePaymentForm;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.form.CreateInvoicePaymentFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class InvoicePaymentFormFragment extends BaseFormFragment<PaymentFormModel, CreateInvoicePaymentFormConfig> implements InvoicePaymentView {

    @Inject
    InvoicePaymentPresenter presenter;

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
    protected FormInterface<PaymentFormModel> createForm(LayoutInflater inflater, ViewGroup linearLayout, CreateInvoicePaymentFormConfig config) {
        return new CreateInvoicePaymentForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(PaymentFormModel paymentFormModel) {
        presenter.savePayment(paymentFormModel);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_invoice_create_payment;
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    public void setData(PaymentFormModel model, List<BankAccount> bankAccounts) {
        CreateInvoicePaymentFormConfig config = presenter.createConfig(bankAccounts);
        startForm(config, model);
    }
}
