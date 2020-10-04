package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentCash;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentTransfer;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.transfer.PaymentTransferForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.type.PaymentMethodType;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.type.PaymentMethodTypeForm;

import static dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.type.PaymentMethodType.CASH;
import static dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.type.PaymentMethodType.TRANSFER;

public class PaymentMethodForm extends BaseForm<PaymentMethod, PaymentViewHolder, PaymentMethodFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    PaymentMethodTypeForm paymentMethodTypeForm;
    PaymentTransferForm paymentTransferForm;


    public PaymentMethodForm(LayoutInflater inflater, ViewGroup viewGroup, PaymentMethodFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    public PaymentMethod getValue() {
        PaymentMethodType type = paymentMethodTypeForm.getValue();
        if (PaymentMethodType.CASH.equals(type)) {
            return new PaymentCash();
        } else if (TRANSFER.equals(type) && paymentTransferForm.isValid()) {
            return paymentTransferForm.getValue();
        }
        return null;
    }

    @Override
    public boolean isValid() {
        PaymentMethodType type = paymentMethodTypeForm.getValue();
        return TRANSFER.equals(type) && paymentTransferForm.isValid() || CASH.equals(type);
    }

    @Override
    protected void showValueOnView(PaymentMethod value) {
        boolean isTransfer = value instanceof PaymentTransfer;
        PaymentViewHolder holder = getViewHolder();
        holder.transferView.setVisibility(isTransfer ? View.VISIBLE : View.GONE);
        paymentMethodTypeForm.setValue(isTransfer ? TRANSFER : CASH);
        if (isTransfer) {
            paymentTransferForm.setValue((PaymentTransfer) value);
        }
    }

    @Override
    protected PaymentViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, PaymentMethodFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        paymentMethodTypeForm = new PaymentMethodTypeForm(inflater, groupList, config.getPaymentTypeFormConfig());
        paymentTransferForm = new PaymentTransferForm(inflater, groupList, config.getPaymentTransferFormConfig());

        View transferView = paymentTransferForm.getView();
        groupList.addView(paymentMethodTypeForm.getView());
        groupList.addView(transferView);

        PaymentViewHolder holder = new PaymentViewHolder();
        holder.view = groupList;
        holder.transferView = transferView;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, PaymentMethodFormConfig config) {
        paymentMethodTypeForm.setOnValueChange(this::onTypeChange);
        paymentTransferForm.setOnValidationStateChanged(this::onValueChange);
    }

    private void onTypeChange(boolean isValid) {
        PaymentViewHolder holder = getViewHolder();
        boolean isTransfer = TRANSFER.equals(paymentMethodTypeForm.getValue());
        holder.transferView.setVisibility(isTransfer ? View.VISIBLE : View.GONE);
        onValueChange();
    }

}
