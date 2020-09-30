package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.special.contact.ClickableContactForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.special.payment.ClickablePaymentForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.special.payment.PaymentModel;

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
    protected void showValueOnView(CreateInvoiceBaseDataModel value) {
        if (value == null) {
            invoiceNumberFormRow.setValue(null);
            buyerFormRow.setValue(null);
            receiverFormRow.setValue(null);
            paymentForm.setValue(null);
            return;
        }
        PaymentModel model = new PaymentModel();
        model.setDueDate(value.getDueDate());
        model.setPaymentMethod(value.getPaymentMethod());

        invoiceNumberFormRow.setValue(value.getInvoiceNumber());
        buyerFormRow.setValue(value.getBuyer());
        receiverFormRow.setValue(value.getReceiver());
        paymentForm.setValue(model);
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
        model.setPaymentMethod(payment.getPaymentMethod());
        model.setDueDate(payment.getDueDate());
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
    protected void setupView(CreateInvoiceBaseDataFormConfig config) {
        invoiceNumberFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        buyerFormRow.setOnClickAction(() -> openContactForm("CREATE_INVOICE_BUYER"));
        receiverFormRow.setOnClickAction(() -> openContactForm("CREATE_INVOICE_RECEIVER"));
        paymentForm.setOnClickAction(() -> openPaymentForm("CREATE_INVOICE"));
    }

    //    type in future can be enum of CREATE_INVOICE_BUYER ,CREATE_INVOICE_RECEIVER
    public void openContactForm(String type) {
        System.out.println("Not Implemented: next fragment and edit contact: " + type);
    }

    //    type in future can be enum of CREATE_INVOICE_FORM
    public void openPaymentForm(String type) {
        System.out.println("Not Implemented: next fragment and edit payment: " + type);
    }


    private void onFieldStateChanged(boolean b) {
        onValueChange();
    }

    @Override
    public boolean isValid() {
        return invoiceNumberFormRow.isValid() && buyerFormRow.isValid()
                && receiverFormRow.isValid() && paymentForm.isValid();
    }
}


