package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.form;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import java.time.LocalDate;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.PaymentFormModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.PaymentMethodForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.datePicker.DatePickerForm;

public class CreateInvoicePaymentForm extends BaseForm<PaymentFormModel, BaseViewHolder, CreateInvoicePaymentFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    PaymentMethodForm paymentMethodForm;
    DatePickerForm dueDateForm;


    public CreateInvoicePaymentForm(LayoutInflater inflater, ViewGroup viewGroup, CreateInvoicePaymentFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(PaymentFormModel value) {
        if (value == null) {
            return;
        }
        paymentMethodForm.setValue(value.getPaymentMethod());
        dueDateForm.setValue(value.getDueDate());
    }

    @Override
    public PaymentFormModel getValue() {
        PaymentMethod paymentMethod = paymentMethodForm.getValue();
        LocalDate date = dueDateForm.getValue();
        if (paymentMethod == null && date == null) {
            return null;
        }
        PaymentFormModel model = new PaymentFormModel();
        model.setPaymentMethod(paymentMethod);
        model.setDueDate(date);
        return model;
    }


    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, CreateInvoicePaymentFormConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        paymentMethodForm = new PaymentMethodForm(inflater, groupList, config.getPaymentConfig());
        dueDateForm = new DatePickerForm(inflater, groupList, config.getDueDateFormConfig());

        groupList.addView(paymentMethodForm.getView());
        groupList.addView(dueDateForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, CreateInvoicePaymentFormConfig config) {
        paymentMethodForm.setOnValidationStateChanged(this::onValueChange);
        dueDateForm.setOnValidationStateChanged(this::onValueChange);
        paymentMethodForm.setSafeNavigationExecutor(this::executeSafeNavigation);
    }

    @Override
    public boolean isValid() {
        return paymentMethodForm.isValid() && dueDateForm.isValid();
    }
}


