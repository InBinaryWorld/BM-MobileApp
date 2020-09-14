package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.CreateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRowConfig;

public class WarehouseCreateFormConfig extends BaseFormConfig<CreateWarehouseRequest> {

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
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getNameConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCountryConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCityConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getPostalCodeConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getStreetConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getHouseNumberConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getApartmentNumberConfig()));
        return configs;
    }

    private EditTextFormRowConfig<CreateWarehouseRequest> getNameConfig() {
        EditTextFormRowConfig<CreateWarehouseRequest> config = FormConfigurations.getWarehouseName();
        config.setFulFiller(CreateWarehouseRequest::setName);
        return config;
    }

    private EditTextFormRowConfig<CreateWarehouseRequest> getCountryConfig() {
        EditTextFormRowConfig<CreateWarehouseRequest> config = FormConfigurations.getCountryConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCountry(value));
        return config;
    }

    private EditTextFormRowConfig<CreateWarehouseRequest> getCityConfig() {
        EditTextFormRowConfig<CreateWarehouseRequest> config = FormConfigurations.getCityConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCity(value));
        return config;
    }

    private EditTextFormRowConfig<CreateWarehouseRequest> getPostalCodeConfig() {
        EditTextFormRowConfig<CreateWarehouseRequest> config = FormConfigurations.getPostalCodeConfig();
        config.setFulFiller((company, value) -> company.getAddress().setPostalCode(value));
        return config;
    }

    private EditTextFormRowConfig<CreateWarehouseRequest> getStreetConfig() {
        EditTextFormRowConfig<CreateWarehouseRequest> config = FormConfigurations.getStreetConfig();
        config.setFulFiller((company, value) -> company.getAddress().setStreet(value));
        return config;
    }

    private EditTextFormRowConfig<CreateWarehouseRequest> getHouseNumberConfig() {
        EditTextFormRowConfig<CreateWarehouseRequest> config = FormConfigurations.getHouseNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setHouseNumber(value));
        return config;
    }

    private EditTextFormRowConfig<CreateWarehouseRequest> getApartmentNumberConfig() {
        EditTextFormRowConfig<CreateWarehouseRequest> config = FormConfigurations.getApartmentNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setApartmentNumber(value));
        return config;
    }

}

