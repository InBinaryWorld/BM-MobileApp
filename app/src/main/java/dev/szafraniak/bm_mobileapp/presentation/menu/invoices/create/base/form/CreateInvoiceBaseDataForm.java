package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.form;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceBaseFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.PaymentFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.contact.ClickableBuyerForm;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.contact.ClickableReceiverForm;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.payment.ClickablePaymentForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;

public class CreateInvoiceBaseDataForm extends BaseForm<CreateInvoiceBaseFormModel, BaseViewHolder, CreateInvoiceBaseDataFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group_with_padding;

    TextEditTextFormRow invoiceNumberFormRow;
    ClickableBuyerForm buyerFormRow;
    ClickableReceiverForm receiverFormRow;
    ClickablePaymentForm paymentForm;

    public CreateInvoiceBaseDataForm(LayoutInflater inflater, ViewGroup viewGroup, CreateInvoiceBaseDataFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(CreateInvoiceBaseFormModel value) {
        System.out.println("base show input; " + value);
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
    public void setValue(CreateInvoiceBaseFormModel input) {
        System.out.println("base setValue input; " + input);
        if (!getConfig().isVisibleOnSetValueNull() && input == null) {
            getView().setVisibility(View.GONE);
            return;
        }
        getView().setVisibility(View.VISIBLE);
        CreateInvoiceBaseFormModel value = shouldShowDefaultValue(input) ? getConfig().getDefaultValue() : input;
        System.out.println("base setValue output; " + input);
        showValueOnView(value);
    }

    @Override
    public CreateInvoiceBaseFormModel getValue() {
        String invoiceNumber = invoiceNumberFormRow.getValue();
        Contact buyer = buyerFormRow.getValue();
        Contact receiver = receiverFormRow.getValue();
        PaymentFormModel payment = paymentForm.getValue();
        // If whole form is not required that allow to return null value if all of child fields have null values
        if (invoiceNumber == null && buyer == null && receiver == null && payment == null) {
            return null;
        }

        CreateInvoiceBaseFormModel model = new CreateInvoiceBaseFormModel();
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
        buyerFormRow = new ClickableBuyerForm(inflater, groupList, config.getBuyerConfig());
        receiverFormRow = new ClickableReceiverForm(inflater, groupList, config.getReceiverConfig());
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


