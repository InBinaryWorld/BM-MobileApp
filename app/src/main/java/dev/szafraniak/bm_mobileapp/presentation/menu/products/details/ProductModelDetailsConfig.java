package dev.szafraniak.bm_mobileapp.presentation.menu.products.details;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.utils.Formatters;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.config.BaseDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.DetailsRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.SimpleTextViewDetailsRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.SimpleTextViewDetailsRowConfig;

public class ProductModelDetailsConfig extends BaseDetailsConfig<ProductModel> {

    public ProductModelDetailsConfig(LayoutInflater inflater, ViewGroup viewGroup) {
        super(inflater, viewGroup);
    }

    @Override
    public List<DetailsRowInterface<ProductModel>> createRowsConfiguration() {
        List<DetailsRowInterface<ProductModel>> configs = new ArrayList<>();
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getProductNameConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getQuantityUnitConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getBareCodeConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getNetPriceConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getTaxRateConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getGrossPriceConfig()));
        return configs;
    }

    private SimpleTextViewDetailsRowConfig<ProductModel> getProductNameConfig() {
        SimpleTextViewDetailsRowConfig<ProductModel> config = DetailsConfigurations.getProductNameConfig();
        config.setValueExtractor(ProductModel::getName);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<ProductModel> getQuantityUnitConfig() {
        SimpleTextViewDetailsRowConfig<ProductModel> config = DetailsConfigurations.getQuantityUnitConfig();
        config.setValueExtractor(ProductModel::getQuantityUnit);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<ProductModel> getBareCodeConfig() {
        SimpleTextViewDetailsRowConfig<ProductModel> config = DetailsConfigurations.getBareCodeConfig();
        config.setValueExtractor(ProductModel::getBareCode);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<ProductModel> getNetPriceConfig() {
        SimpleTextViewDetailsRowConfig<ProductModel> config = DetailsConfigurations.getNetPriceConfig();
        config.setValueExtractor(model -> {
            BigDecimal value = model.getPriceSuggestion().getNet();
            return Formatters.formatWithFraction(value);
        });
        return config;
    }

    private SimpleTextViewDetailsRowConfig<ProductModel> getTaxRateConfig() {
        SimpleTextViewDetailsRowConfig<ProductModel> config = DetailsConfigurations.getTaxRateConfig();
        config.setValueExtractor(model -> {
            BigDecimal value = model.getPriceSuggestion().getTaxRate();
            return Formatters.formatNoFraction(value);
        });
        return config;
    }

    private SimpleTextViewDetailsRowConfig<ProductModel> getGrossPriceConfig() {
        SimpleTextViewDetailsRowConfig<ProductModel> config = DetailsConfigurations.getGrossPriceConfig();
        config.setValueExtractor(model -> {
            BigDecimal value = model.getPriceSuggestion().getGross();
            return Formatters.formatWithFraction(value);
        });
        return config;
    }

}

