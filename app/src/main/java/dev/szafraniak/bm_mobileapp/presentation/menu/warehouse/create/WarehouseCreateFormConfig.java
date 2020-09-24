package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.CreateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormRow;

public class WarehouseCreateFormConfig extends BaseFormRow.BaseFormConfig<CreateWarehouseRequest> {

    public WarehouseCreateFormConfig(LayoutInflater inflater, ViewGroup viewGroup) {
        super(inflater, viewGroup);
    }

    @Override
    protected String getSubmitButtonText() {
        return "CREATE PRODUCT MODEL";
    }

    @Override
    public List<FormRowInterface<CreateWarehouseRequest>> createRowsConfiguration() {
        List<FormRowInterface<CreateWarehouseRequest>> configs = new ArrayList<>();
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getNameConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCountryConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCityConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getPostalCodeConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getStreetConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getHouseNumberConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getApartmentNumberConfig()));
        return configs;
    }

    private TextFormConfig<CreateWarehouseRequest> getNameConfig() {
        TextFormConfig<CreateWarehouseRequest> config = FormConfigurations.getWarehouseName();
        config.setFulFiller(CreateWarehouseRequest::setName);
        return config;
    }

    private TextFormConfig<CreateWarehouseRequest> getCountryConfig() {
        TextFormConfig<CreateWarehouseRequest> config = FormConfigurations.getCountryConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCountry(value));
        return config;
    }

    private TextFormConfig<CreateWarehouseRequest> getCityConfig() {
        TextFormConfig<CreateWarehouseRequest> config = FormConfigurations.getCityConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCity(value));
        return config;
    }

    private TextFormConfig<CreateWarehouseRequest> getPostalCodeConfig() {
        TextFormConfig<CreateWarehouseRequest> config = FormConfigurations.getPostalCodeConfig();
        config.setFulFiller((company, value) -> company.getAddress().setPostalCode(value));
        return config;
    }

    private TextFormConfig<CreateWarehouseRequest> getStreetConfig() {
        TextFormConfig<CreateWarehouseRequest> config = FormConfigurations.getStreetConfig();
        config.setFulFiller((company, value) -> company.getAddress().setStreet(value));
        return config;
    }

    private TextFormConfig<CreateWarehouseRequest> getHouseNumberConfig() {
        TextFormConfig<CreateWarehouseRequest> config = FormConfigurations.getHouseNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setHouseNumber(value));
        return config;
    }

    private TextFormConfig<CreateWarehouseRequest> getApartmentNumberConfig() {
        TextFormConfig<CreateWarehouseRequest> config = FormConfigurations.getApartmentNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setApartmentNumber(value));
        return config;
    }

}

