package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;


import java.time.LocalDate;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceBaseFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.PaymentFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form.contact.ClickableBuyerForm;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form.contact.ClickableReceiverForm;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form.payment.ClickablePaymentForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.datePicker.DatePickerForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;

public class CreateInvoiceBaseDataForm extends BaseForm<CreateInvoiceBaseFormModel, BaseViewHolder, CreateInvoiceBaseDataFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group_with_padding;

    TextEditTextFormRow invoiceNumberFormRow;
    ClickablePaymentForm paymentForm;
    DatePickerForm issueDateForm;
    DatePickerForm sellDateForm;
    ClickableBuyerForm buyerFormRow;
    ClickableReceiverForm receiverFormRow;

    public CreateInvoiceBaseDataForm(LayoutInflater inflater, ViewGroup viewGroup, CreateInvoiceBaseDataFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(CreateInvoiceBaseFormModel value) {
        if (value == null) {
            invoiceNumberFormRow.setValue(null);
            paymentForm.setValue(null);
            issueDateForm.setValue(null);
            sellDateForm.setValue(null);
            buyerFormRow.setValue(null);
            receiverFormRow.setValue(null);
            return;
        }
        invoiceNumberFormRow.setValue(value.getInvoiceNumber());
        paymentForm.setValue(value.getPayment());
        issueDateForm.setValue(value.getIssueDate());
        sellDateForm.setValue(value.getSellDate());
        buyerFormRow.setValue(value.getBuyer());
        receiverFormRow.setValue(value.getReceiver());
    }

    @Override
    public void setValue(CreateInvoiceBaseFormModel input) {
        if (!getConfig().isVisibleOnSetValueNull() && input == null) {
            getView().setVisibility(View.GONE);
            return;
        }
        getView().setVisibility(View.VISIBLE);
        CreateInvoiceBaseFormModel value = shouldShowDefaultValue(input) ? getConfig().getDefaultValue() : input;
        showValueOnView(value);
    }

    @Override
    public CreateInvoiceBaseFormModel getValue() {
        String invoiceNumber = invoiceNumberFormRow.getValue();
        PaymentFormModel payment = paymentForm.getValue();
        LocalDate issueDate = issueDateForm.getValue();
        LocalDate sellDate = sellDateForm.getValue();
        Contact buyer = buyerFormRow.getValue();
        Contact receiver = receiverFormRow.getValue();
        // If whole form is not required that allow to return null value if all of child fields have null values
        if (invoiceNumber == null && buyer == null && receiver == null && payment == null && issueDate == null) {
            return null;
        }

        CreateInvoiceBaseFormModel model = new CreateInvoiceBaseFormModel();
        model.setInvoiceNumber(invoiceNumber);
        model.setPayment(payment);
        model.setIssueDate(issueDate);
        model.setSellDate(sellDate);
        model.setBuyer(buyer);
        model.setReceiver(receiver);
        return model;
    }


    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, CreateInvoiceBaseDataFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        invoiceNumberFormRow = new TextEditTextFormRow(inflater, groupList, config.getInvoiceNumberConfig());
        paymentForm = new ClickablePaymentForm(inflater, groupList, config.getPaymentConfig());
        issueDateForm = new DatePickerForm(inflater, groupList, config.getIssueDateConfig());
        sellDateForm = new DatePickerForm(inflater, groupList, config.getSellDateConfig());
        buyerFormRow = new ClickableBuyerForm(inflater, groupList, config.getBuyerConfig());
        receiverFormRow = new ClickableReceiverForm(inflater, groupList, config.getReceiverConfig());

        groupList.addView(invoiceNumberFormRow.getView());
        groupList.addView(paymentForm.getView());
        groupList.addView(issueDateForm.getView());
        groupList.addView(sellDateForm.getView());
        groupList.addView(buyerFormRow.getView());
        groupList.addView(receiverFormRow.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, CreateInvoiceBaseDataFormConfig config) {
        invoiceNumberFormRow.setOnValidationStateChanged(this::onValueChange);
        issueDateForm.setOnValidationStateChanged(this::onValueChange);
        sellDateForm.setOnValidationStateChanged(this::onValueChange);
        paymentForm.setSafeNavigationExecutor(this::executeSafeNavigation);
        buyerFormRow.setSafeNavigationExecutor(this::executeSafeNavigation);
        receiverFormRow.setSafeNavigationExecutor(this::executeSafeNavigation);
    }


    @Override
    public boolean isValid() {
        return invoiceNumberFormRow.isValid() && buyerFormRow.isValid()
                && receiverFormRow.isValid() && paymentForm.isValid()
                && this.isDueDateLaterThanIssueDate();
    }

    private boolean isDueDateLaterThanIssueDate() {
        return true;
    }
}


