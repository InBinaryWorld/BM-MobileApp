package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.company;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.BaseAutoCompleteListAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.text.TextAutoCompleteTextForm;

public class CompanyNameAutoCompleteForm extends TextAutoCompleteTextForm<CompanyContact> {

    public CompanyNameAutoCompleteForm(LayoutInflater inflater, ViewGroup viewGroup, AutoCompleteTextFormConfig<String, CompanyContact> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected BaseAutoCompleteListAdapter<CompanyContact> createAdapter(LayoutInflater inflater, AutoCompleteTextFormConfig<String, CompanyContact> config) {
        return new CompanyNameAutoCompleteAdapter(inflater, config.getListItems());
    }

}
