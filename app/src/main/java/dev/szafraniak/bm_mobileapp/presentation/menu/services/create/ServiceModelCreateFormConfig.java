package dev.szafraniak.bm_mobileapp.presentation.menu.services.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.CreateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price.PriceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price.PriceFormRow;

public class ServiceModelCreateFormConfig extends BaseFormRow.BaseFormConfig<CreateServiceModelRequest> {

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
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getNameConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getQuantityUnitConfig()));
        configs.add(new PriceFormRow<>(this.inflater, this.viewGroup, getPriceConfig()));
        return configs;
    }

    private TextFormConfig<CreateServiceModelRequest> getNameConfig() {
        TextFormConfig<CreateServiceModelRequest> config = FormConfigurations.getServiceModelNameConfig();
        config.setFulFiller(CreateServiceModelRequest::setName);
        return config;
    }

    private TextFormConfig<CreateServiceModelRequest> getQuantityUnitConfig() {
        TextFormConfig<CreateServiceModelRequest> config = FormConfigurations.getQuantityUnitConfig();
        config.setFulFiller(CreateServiceModelRequest::setQuantityUnit);
        return config;
    }


    private PriceFormConfig<CreateServiceModelRequest> getPriceConfig() {
        PriceFormConfig<CreateServiceModelRequest> config = FormConfigurations.getPriceConfig();
        config.setFulFiller(CreateServiceModelRequest::setPriceSuggestion);
        return config;
    }
}

