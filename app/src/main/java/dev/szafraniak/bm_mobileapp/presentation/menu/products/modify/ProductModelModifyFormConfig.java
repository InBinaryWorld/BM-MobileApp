package dev.szafraniak.bm_mobileapp.presentation.menu.products.modify;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.UpdateProductModelRequest;
import dev.szafraniak.bm_mobileapp.business.utils.Formatters;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price.PriceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price.PriceFormRow;

public class ProductModelModifyFormConfig extends BaseFormRow.BaseFormConfig<UpdateProductModelRequest> {

    private final ProductModel productModel;

    public ProductModelModifyFormConfig(LayoutInflater inflater, ViewGroup viewGroup, ProductModel productModel) {
        super(inflater, viewGroup);
        this.productModel = productModel;
    }

    @Override
    protected String getSubmitButtonText() {
        return "MODIFY CONTACT";
    }

    @Override
    public List<FormRowInterface<UpdateProductModelRequest>> createRowsConfiguration() {
        List<FormRowInterface<UpdateProductModelRequest>> configs = new ArrayList<>();
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getNameConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getQuantityUnitConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getBareCodeConfig()));
        configs.add(new PriceFormRow<>(this.inflater, this.viewGroup, getPriceConfig()));
        return configs;
    }

    private TextFormConfig<UpdateProductModelRequest> getNameConfig() {
        TextFormConfig<UpdateProductModelRequest> config = FormConfigurations.getProductModelNameConfig();
        config.setFulFiller(UpdateProductModelRequest::setName);
        config.setInitValue(productModel.getName());
        return config;
    }

    private TextFormConfig<UpdateProductModelRequest> getQuantityUnitConfig() {
        TextFormConfig<UpdateProductModelRequest> config = FormConfigurations.getQuantityUnitConfig();
        config.setFulFiller(UpdateProductModelRequest::setQuantityUnit);
        config.setInitValue(productModel.getQuantityUnit());
        return config;
    }

    private TextFormConfig<UpdateProductModelRequest> getBareCodeConfig() {
        TextFormConfig<UpdateProductModelRequest> config = FormConfigurations.getBareCodeConfig();
        config.setFulFiller(UpdateProductModelRequest::setBareCode);
        config.setInitValue(productModel.getBareCode());
        return config;
    }

    private PriceFormConfig<UpdateProductModelRequest> getPriceConfig() {
        Price price = productModel.getPriceSuggestion();
        PriceFormConfig<UpdateProductModelRequest> config = FormConfigurations.getPriceConfig();
        config.setNetInitValue(Formatters.formatWithFraction(price.getNet()));
        config.setGrossInitValue(Formatters.formatWithFraction(price.getGross()));
        config.setTaxRateInitValue(Formatters.formatNoFraction(price.getTaxRate()));
        config.setFulFiller(UpdateProductModelRequest::setPriceSuggestion);
        return config;
    }

}

