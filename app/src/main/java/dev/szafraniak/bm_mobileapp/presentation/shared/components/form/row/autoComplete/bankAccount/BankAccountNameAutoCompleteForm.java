package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.bankAccount;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.BaseAutoCompleteListAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.text.TextAutoCompleteTextForm;

public class BankAccountNameAutoCompleteForm extends TextAutoCompleteTextForm<BankAccount> {

    public BankAccountNameAutoCompleteForm(LayoutInflater inflater, ViewGroup viewGroup, AutoCompleteTextFormConfig<String, BankAccount> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected BaseAutoCompleteListAdapter<BankAccount> createAdapter(LayoutInflater inflater, AutoCompleteTextFormConfig<String, BankAccount> config) {
        return new BankAccountAutoCompleteAdapter(inflater, config.getListItems());
    }

}
