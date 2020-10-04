package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.form;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceBaseDataModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.PaymentModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.contact.ClickableContactForm;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.payment.ClickablePaymentForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;

public class CreateInvoiceBaseDataForm extends BaseForm<CreateInvoiceBaseDataModel, BaseViewHolder, CreateInvoiceBaseDataFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    TextEditTextFormRow invoiceNumberFormRow;
    ClickableContactForm buyerFormRow;
    ClickableContactForm receiverFormRow;
    ClickablePaymentForm paymentForm;

    public CreateInvoiceBaseDataForm(LayoutInflater inflater, ViewGroup viewGroup, CreateInvoiceBaseDataFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(CreateInvoiceBaseDataModel value) {
        if (value == null) {
            invoiceNumberFormRow.setValue(null);
            buyerFormRow.setValue(null);
            receiverFormRow.setValue(null);
            paymentForm.setValue(null);
            return;
        }

        invoiceNumberFormRow.setValue(value.getInvoiceNumber());
        buyerFormRow.setValue(value.getBuyer());
        receiverFormRow.setValue(value.getReceiver());
        paymentForm.setValue(value.getPayment());
    }

    @Override
    public CreateInvoiceBaseDataModel getValue() {
        String invoiceNumber = invoiceNumberFormRow.getValue();
        Contact buyer = buyerFormRow.getValue();
        Contact receiver = receiverFormRow.getValue();
        PaymentModel payment = paymentForm.getValue();
        // If whole form is not required that allow to return null value if all of child fields have null values
        if (invoiceNumber == null && buyer == null && receiver == null && payment == null) {
            return null;
        }

        CreateInvoiceBaseDataModel model = new CreateInvoiceBaseDataModel();
        model.setInvoiceNumber(invoiceNumber);
        model.setBuyer(buyer);
        model.setReceiver(receiver);
        model.setPayment(payment);
        return model;
    }


    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, CreateInvoiceBaseDataFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        invoiceNumberFormRow = new TextEditTextFormRow(inflater, groupList, config.getInvoiceNumberConfig());
        buyerFormRow = new ClickableContactForm(inflater, groupList, config.getBuyerConfig());
        receiverFormRow = new ClickableContactForm(inflater, groupList, config.getReceiverConfig());
        paymentForm = new ClickablePaymentForm(inflater, groupList, config.getPaymentConfig());

        groupList.addView(invoiceNumberFormRow.getView());
        groupList.addView(buyerFormRow.getView());
        groupList.addView(receiverFormRow.getView());
        groupList.addView(paymentForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, CreateInvoiceBaseDataFormConfig config) {
        invoiceNumberFormRow.setOnValidationStateChanged(this::onValueChange);
        buyerFormRow.setSafeNavigationExecutor(this::executeSafeNavigation);
        receiverFormRow.setSafeNavigationExecutor(this::executeSafeNavigation);
        paymentForm.setSafeNavigationExecutor(this::executeSafeNavigation);
    }


    @Override
    public boolean isValid() {
        return invoiceNumberFormRow.isValid() && buyerFormRow.isValid()
                && receiverFormRow.isValid() && paymentForm.isValid();
    }
}


