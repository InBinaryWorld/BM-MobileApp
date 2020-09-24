package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.UpdateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormRow;

public class WarehouseModifyFormConfig extends BaseFormRow.BaseFormConfig<UpdateWarehouseRequest> {

    private final Warehouse warehouse;

    public WarehouseModifyFormConfig(LayoutInflater inflater, ViewGroup viewGroup, Warehouse warehouse) {
        super(inflater, viewGroup);
        this.warehouse = warehouse;
    }

    @Override
    protected String getSubmitButtonText() {
        return "MODIFY CONTACT";
    }

    @Override
    public List<FormRowInterface<UpdateWarehouseRequest>> createRowsConfiguration() {
        List<FormRowInterface<UpdateWarehouseRequest>> configs = new ArrayList<>();
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCompanyNameConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCountryConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCityConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getPostalCodeConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getStreetConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getHouseNumberConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getApartmentNumberConfig()));
        return configs;
    }

    private TextFormConfig<UpdateWarehouseRequest> getCompanyNameConfig() {
        TextFormConfig<UpdateWarehouseRequest> config = FormConfigurations.getWarehouseName();
        config.setFulFiller(UpdateWarehouseRequest::setName);
        config.setInitValue(warehouse.getName());
        return config;
    }

    private TextFormConfig<UpdateWarehouseRequest> getCountryConfig() {
        TextFormConfig<UpdateWarehouseRequest> config = FormConfigurations.getCountryConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCountry(value));
        if (warehouse.getAddress() != null) {
            config.setInitValue(warehouse.getAddress().getCity());
        }
        return config;
    }

    private TextFormConfig<UpdateWarehouseRequest> getCityConfig() {
        TextFormConfig<UpdateWarehouseRequest> config = FormConfigurations.getCityConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCity(value));
        if (warehouse.getAddress() != null) {
            config.setInitValue(warehouse.getAddress().getCity());
        }
        return config;
    }

    private TextFormConfig<UpdateWarehouseRequest> getPostalCodeConfig() {
        TextFormConfig<UpdateWarehouseRequest> config = FormConfigurations.getPostalCodeConfig();
        config.setFulFiller((company, value) -> company.getAddress().setPostalCode(value));
        if (warehouse.getAddress() != null) {
            config.setInitValue(warehouse.getAddress().getStreet());
        }
        return config;
    }

    private TextFormConfig<UpdateWarehouseRequest> getStreetConfig() {
        TextFormConfig<UpdateWarehouseRequest> config = FormConfigurations.getStreetConfig();
        config.setFulFiller((company, value) -> company.getAddress().setStreet(value));
        if (warehouse.getAddress() != null) {
            config.setInitValue(warehouse.getAddress().getStreet());
        }
        return config;
    }

    private TextFormConfig<UpdateWarehouseRequest> getHouseNumberConfig() {
        TextFormConfig<UpdateWarehouseRequest> config = FormConfigurations.getHouseNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setHouseNumber(value));
        if (warehouse.getAddress() != null) {
            config.setInitValue(warehouse.getAddress().getHouseNumber());
        }
        return config;
    }

    private TextFormConfig<UpdateWarehouseRequest> getApartmentNumberConfig() {
        TextFormConfig<UpdateWarehouseRequest> config = FormConfigurations.getApartmentNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setApartmentNumber(value));
        if (warehouse.getAddress() != null) {
            config.setInitValue(warehouse.getAddress().getApartmentNumber());
        }
        return config;
    }
}

