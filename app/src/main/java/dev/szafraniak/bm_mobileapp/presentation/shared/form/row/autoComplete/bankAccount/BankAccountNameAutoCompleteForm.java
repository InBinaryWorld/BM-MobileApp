package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.bankAccount;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.text.TextAutoCompleteTextForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.BaseFilterListAdapter;

public class BankAccountNameAutoCompleteForm extends TextAutoCompleteTextForm<BankAccount> {

    public BankAccountNameAutoCompleteForm(LayoutInflater inflater, ViewGroup viewGroup, AutoCompleteTextFormConfig<String, BankAccount> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected BaseFilterListAdapter<BankAccount> createAdapter(LayoutInflater inflater, AutoCompleteTextFormConfig<String, BankAccount> config) {
        return new BankAccountFilterAdapter(inflater, config.getListItems());
    }

}
