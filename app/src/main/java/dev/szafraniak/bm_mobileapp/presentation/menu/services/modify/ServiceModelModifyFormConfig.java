package dev.szafraniak.bm_mobileapp.presentation.menu.services.modify;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.UpdateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.business.utils.Formatters;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price.PriceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price.PriceFormRow;

public class ServiceModelModifyFormConfig extends BaseFormRow.BaseFormConfig<UpdateServiceModelRequest> {

    private final ServiceModel serviceModel;

    public ServiceModelModifyFormConfig(LayoutInflater inflater, ViewGroup viewGroup, ServiceModel serviceModel) {
        super(inflater, viewGroup);
        this.serviceModel = serviceModel;
    }

    @Override
    protected String getSubmitButtonText() {
        return "MODIFY SERVICE";
    }

    @Override
    public List<FormRowInterface<UpdateServiceModelRequest>> createRowsConfiguration() {
        List<FormRowInterface<UpdateServiceModelRequest>> configs = new ArrayList<>();
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getNameConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getQuantityUnitConfig()));
        configs.add(new PriceFormRow<>(this.inflater, this.viewGroup, getPriceConfig()));
        return configs;
    }

    private TextFormConfig<UpdateServiceModelRequest> getNameConfig() {
        TextFormConfig<UpdateServiceModelRequest> config = FormConfigurations.getServiceModelNameConfig();
        config.setFulFiller(UpdateServiceModelRequest::setName);
        config.setInitValue(serviceModel.getName());
        return config;
    }

    private TextFormConfig<UpdateServiceModelRequest> getQuantityUnitConfig() {
        TextFormConfig<UpdateServiceModelRequest> config = FormConfigurations.getQuantityUnitConfig();
        config.setFulFiller(UpdateServiceModelRequest::setQuantityUnit);
        config.setInitValue(serviceModel.getQuantityUnit());
        return config;
    }

    private PriceFormConfig<UpdateServiceModelRequest> getPriceConfig() {
        Price price = serviceModel.getPriceSuggestion();
        PriceFormConfig<UpdateServiceModelRequest> config = FormConfigurations.getPriceConfig();
        config.setNetInitValue(Formatters.formatWithFraction(price.getNet()));
        config.setGrossInitValue(Formatters.formatWithFraction(price.getGross()));
        config.setTaxRateInitValue(Formatters.formatNoFraction(price.getTaxRate()));
        config.setFulFiller(UpdateServiceModelRequest::setPriceSuggestion);
        return config;
    }

}

