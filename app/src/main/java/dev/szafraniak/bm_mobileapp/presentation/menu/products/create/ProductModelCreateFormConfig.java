package dev.szafraniak.bm_mobileapp.presentation.menu.products.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.CreateProductModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRowConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price.PriceFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price.PriceFormRowConfig;

public class ProductModelCreateFormConfig extends BaseFormConfig<CreateProductModelRequest> {

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
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getNameConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getQuantityUnitConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getBareCodeConfig()));
        configs.add(new PriceFormRow<>(this.inflater, this.viewGroup, getPriceConfig()));
        return configs;
    }

    private EditTextFormRowConfig<CreateProductModelRequest> getNameConfig() {
        EditTextFormRowConfig<CreateProductModelRequest> config = FormConfigurations.getProductModelNameConfig();
        config.setFulFiller(CreateProductModelRequest::setName);
        return config;
    }

    private EditTextFormRowConfig<CreateProductModelRequest> getQuantityUnitConfig() {
        EditTextFormRowConfig<CreateProductModelRequest> config = FormConfigurations.getQuantityUnitConfig();
        config.setFulFiller(CreateProductModelRequest::setQuantityUnit);
        return config;
    }

    private EditTextFormRowConfig<CreateProductModelRequest> getBareCodeConfig() {
        EditTextFormRowConfig<CreateProductModelRequest> config = FormConfigurations.getBareCodeConfig();
        config.setFulFiller(CreateProductModelRequest::setBareCode);
        return config;
    }

    private PriceFormRowConfig<CreateProductModelRequest> getPriceConfig() {
        PriceFormRowConfig<CreateProductModelRequest> config = FormConfigurations.getPriceConfig();
        config.setFulFiller(CreateProductModelRequest::setPriceSuggestion);
        return config;
    }
}

