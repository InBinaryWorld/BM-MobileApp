package dev.szafraniak.bm_mobileapp.presentation.menu.products.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.CreateProductModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price.PriceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price.PriceFormRow;

public class ProductModelCreateFormConfig extends BaseFormRow.BaseFormConfig<CreateProductModelRequest> {

    public ProductModelCreateFormConfig(LayoutInflater inflater, ViewGroup viewGroup) {
        super(inflater, viewGroup);
    }

    @Override
    protected String getSubmitButtonText() {
        return "CREATE PRODUCT MODEL";
    }

    @Override
    public List<FormRowInterface<CreateProductModelRequest>> createRowsConfiguration() {
        List<FormRowInterface<CreateProductModelRequest>> configs = new ArrayList<>();
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getNameConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getQuantityUnitConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getBareCodeConfig()));
        configs.add(new PriceFormRow<>(this.inflater, this.viewGroup, getPriceConfig()));
        return configs;
    }

    private TextFormConfig<CreateProductModelRequest> getNameConfig() {
        TextFormConfig<CreateProductModelRequest> config = FormConfigurations.getProductModelNameConfig();
        config.setFulFiller(CreateProductModelRequest::setName);
        return config;
    }

    private TextFormConfig<CreateProductModelRequest> getQuantityUnitConfig() {
        TextFormConfig<CreateProductModelRequest> config = FormConfigurations.getQuantityUnitConfig();
        config.setFulFiller(CreateProductModelRequest::setQuantityUnit);
        return config;
    }

    private TextFormConfig<CreateProductModelRequest> getBareCodeConfig() {
        TextFormConfig<CreateProductModelRequest> config = FormConfigurations.getBareCodeConfig();
        config.setFulFiller(CreateProductModelRequest::setBareCode);
        return config;
    }

    private PriceFormConfig<CreateProductModelRequest> getPriceConfig() {
        PriceFormConfig<CreateProductModelRequest> config = FormConfigurations.getPriceConfig();
        config.setFulFiller(CreateProductModelRequest::setPriceSuggestion);
        return config;
    }
}

