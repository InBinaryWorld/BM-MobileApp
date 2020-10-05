package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.transfer;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentTransfer;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.bankAccount.BankAccountNameAutoCompleteForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;

public class PaymentTransferForm extends BaseForm<PaymentTransfer, BaseViewHolder, PaymentTransferFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    BankAccountNameAutoCompleteForm nameForm;
    TextEditTextFormRow numberForm;

    public PaymentTransferForm(LayoutInflater inflater, ViewGroup viewGroup, PaymentTransferFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(PaymentTransfer value) {
        if (value == null) {
            nameForm.setValue(null);
            numberForm.setValue(null);
            return;
        }
        nameForm.setValue(value.getAccountName());
        numberForm.setValue(value.getAccountNumber());
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, PaymentTransferFormConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        nameForm = new BankAccountNameAutoCompleteForm(inflater, groupList, config.getNameConfig());
        numberForm = new TextEditTextFormRow(inflater, groupList, config.getNumberConfig());

        groupList.addView(nameForm.getView());
        groupList.addView(numberForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, PaymentTransferFormConfig config) {
        nameForm.setOnValidationStateChanged(this::onValueChange);
        numberForm.setOnValidationStateChanged(this::onValueChange);
        nameForm.addOnItemSelected(item -> numberForm.setValue(item.getNumber()));
    }

    @Override
    public PaymentTransfer getValue() {
        String name = nameForm.getValue();
        String number = numberForm.getValue();
        if (name == null && number == null) {
            return null;
        }
        PaymentTransfer paymentTransfer = new PaymentTransfer();
        paymentTransfer.setAccountName(name);
        paymentTransfer.setAccountNumber(number);
        return paymentTransfer;
    }

    @Override
    public boolean isValid() {
        return nameForm.isValid() && numberForm.isValid();
    }

}
