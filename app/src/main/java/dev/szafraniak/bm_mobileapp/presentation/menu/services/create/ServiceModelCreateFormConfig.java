package dev.szafraniak.bm_mobileapp.presentation.menu.services.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.CreateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRowConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price.PriceFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price.PriceFormRowConfig;

public class ServiceModelCreateFormConfig extends BaseFormConfig<CreateServiceModelRequest> {

    public ServiceModelCreateFormConfig(LayoutInflater inflater, ViewGroup viewGroup) {
        super(inflater, viewGroup);
    }

    @Override
    protected String getSubmitButtonText() {
        return "CREATE PRODUCT MODEL";
    }

    @Override
    public List<FormRowInterface<CreateServiceModelRequest>> createRowsConfiguration() {
        List<FormRowInterface<CreateServiceModelRequest>> configs = new ArrayList<>();
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getNameConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getQuantityUnitConfig()));
        configs.add(new PriceFormRow<>(this.inflater, this.viewGroup, getPriceConfig()));
        return configs;
    }

    private EditTextFormRowConfig<CreateServiceModelRequest> getNameConfig() {
        EditTextFormRowConfig<CreateServiceModelRequest> config = FormConfigurations.getServiceModelNameConfig();
        config.setFulFiller(CreateServiceModelRequest::setName);
        return config;
    }

    private EditTextFormRowConfig<CreateServiceModelRequest> getQuantityUnitConfig() {
        EditTextFormRowConfig<CreateServiceModelRequest> config = FormConfigurations.getQuantityUnitConfig();
        config.setFulFiller(CreateServiceModelRequest::setQuantityUnit);
        return config;
    }


    private PriceFormRowConfig<CreateServiceModelRequest> getPriceConfig() {
        PriceFormRowConfig<CreateServiceModelRequest> config = FormConfigurations.getPriceConfig();
        config.setFulFiller(CreateServiceModelRequest::setPriceSuggestion);
        return config;
    }
}

