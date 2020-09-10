package dev.szafraniak.bm_mobileapp.presentation.menu.services.details;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.utils.Formatters;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.config.BaseDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.DetailsRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.SimpleTextViewDetailsRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.SimpleTextViewDetailsRowConfig;

public class ServiceModelDetailsConfig extends BaseDetailsConfig<ServiceModel> {

    public ServiceModelDetailsConfig(LayoutInflater inflater, ViewGroup viewGroup) {
        super(inflater, viewGroup);
    }

    @Override
    public List<DetailsRowInterface<ServiceModel>> createRowsConfiguration() {
        List<DetailsRowInterface<ServiceModel>> configs = new ArrayList<>();
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getServiceNameConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getQuantityUnitConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getNetPriceConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getTaxRateConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getGrossPriceConfig()));
        return configs;
    }

    private SimpleTextViewDetailsRowConfig<ServiceModel> getServiceNameConfig() {
        SimpleTextViewDetailsRowConfig<ServiceModel> config = DetailsConfigurations.getServiceNameConfig();
        config.setValueExtractor(ServiceModel::getName);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<ServiceModel> getQuantityUnitConfig() {
        SimpleTextViewDetailsRowConfig<ServiceModel> config = DetailsConfigurations.getQuantityUnitConfig();
        config.setValueExtractor(ServiceModel::getQuantityUnit);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<ServiceModel> getNetPriceConfig() {
        SimpleTextViewDetailsRowConfig<ServiceModel> config = DetailsConfigurations.getNetPriceConfig();
        config.setValueExtractor(model -> {
            BigDecimal value = model.getPriceSuggestion().getNet();
            return Formatters.formatWithFraction(value);
        });
        return config;
    }

    private SimpleTextViewDetailsRowConfig<ServiceModel> getTaxRateConfig() {
        SimpleTextViewDetailsRowConfig<ServiceModel> config = DetailsConfigurations.getTaxRateConfig();
        config.setValueExtractor(model -> {
            BigDecimal value = model.getPriceSuggestion().getTaxRate();
            return Formatters.formatNoFraction(value);
        });
        return config;
    }

    private SimpleTextViewDetailsRowConfig<ServiceModel> getGrossPriceConfig() {
        SimpleTextViewDetailsRowConfig<ServiceModel> config = DetailsConfigurations.getGrossPriceConfig();
        config.setValueExtractor(model -> {
            BigDecimal value = model.getPriceSuggestion().getGross();
            return Formatters.formatWithFraction(value);
        });
        return config;
    }

}

