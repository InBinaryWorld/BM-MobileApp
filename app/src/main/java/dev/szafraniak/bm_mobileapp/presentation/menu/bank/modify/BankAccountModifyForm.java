package dev.szafraniak.bm_mobileapp.presentation.menu.bank.modify;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.UpdateBankAccountRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;

public class BankAccountModifyForm extends BaseForm<UpdateBankAccountRequest, BaseViewHolder, BankAccountModifyFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group_with_padding;

    TextEditTextFormRow nameForm;
    TextEditTextFormRow numberForm;

    public BankAccountModifyForm(LayoutInflater inflater, ViewGroup viewGroup, BankAccountModifyFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(UpdateBankAccountRequest value) {
        if (value == null) {
            nameForm.setValue(null);
            numberForm.setValue(null);
            return;
        }
        nameForm.setValue(value.getName());
        numberForm.setValue(value.getNumber());
    }

    @Override
    public UpdateBankAccountRequest getValue() {
        String name = nameForm.getValue();
        String number = numberForm.getValue();
        if (name == null && number == null) {
            return null;
        }
        UpdateBankAccountRequest model = new UpdateBankAccountRequest();
        model.setName(name);
        model.setNumber(number);
        return model;
    }


    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, BankAccountModifyFormConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        nameForm = new TextEditTextFormRow(inflater, groupList, config.getNameConfig());
        numberForm = new TextEditTextFormRow(inflater, groupList, config.getNumberConfig());

        groupList.addView(nameForm.getView());
        groupList.addView(numberForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, BankAccountModifyFormConfig config) {
        nameForm.setOnValidationStateChanged(this::onValueChange);
        numberForm.setOnValidationStateChanged(this::onValueChange);
    }

    @Override
    public boolean isValid() {
        return nameForm.isValid() && numberForm.isValid();
    }
}


