package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.service;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.BaseAutoCompleteListAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.text.TextAutoCompleteTextForm;

public class ServiceNameAutoCompleteForm extends TextAutoCompleteTextForm<ServiceModel> {

    public ServiceNameAutoCompleteForm(LayoutInflater inflater, ViewGroup viewGroup, AutoCompleteTextFormConfig<String, ServiceModel> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected BaseAutoCompleteListAdapter<ServiceModel> createAdapter(LayoutInflater inflater, AutoCompleteTextFormConfig<String, ServiceModel> config) {
        return new ServiceNameAutoCompleteAdapter(inflater, config.getListItems());
    }

}
