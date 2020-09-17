package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.UpdateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRowConfig;

public class WarehouseModifyFormConfig extends BaseFormConfig<UpdateWarehouseRequest> {

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
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCompanyNameConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCountryConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCityConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getPostalCodeConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getStreetConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getHouseNumberConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getApartmentNumberConfig()));
        return configs;
    }

    private EditTextFormRowConfig<UpdateWarehouseRequest> getCompanyNameConfig() {
        EditTextFormRowConfig<UpdateWarehouseRequest> config = FormConfigurations.getWarehouseName();
        config.setFulFiller(UpdateWarehouseRequest::setName);
        config.setInitValue(warehouse.getName());
        return config;
    }

    private EditTextFormRowConfig<UpdateWarehouseRequest> getCountryConfig() {
        EditTextFormRowConfig<UpdateWarehouseRequest> config = FormConfigurations.getCountryConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCountry(value));
        if (warehouse.getAddress() != null) {
            config.setInitValue(warehouse.getAddress().getCity());
        }
        return config;
    }

    private EditTextFormRowConfig<UpdateWarehouseRequest> getCityConfig() {
        EditTextFormRowConfig<UpdateWarehouseRequest> config = FormConfigurations.getCityConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCity(value));
        if (warehouse.getAddress() != null) {
            config.setInitValue(warehouse.getAddress().getCity());
        }
        return config;
    }

    private EditTextFormRowConfig<UpdateWarehouseRequest> getPostalCodeConfig() {
        EditTextFormRowConfig<UpdateWarehouseRequest> config = FormConfigurations.getPostalCodeConfig();
        config.setFulFiller((company, value) -> company.getAddress().setPostalCode(value));
        if (warehouse.getAddress() != null) {
            config.setInitValue(warehouse.getAddress().getStreet());
        }
        return config;
    }

    private EditTextFormRowConfig<UpdateWarehouseRequest> getStreetConfig() {
        EditTextFormRowConfig<UpdateWarehouseRequest> config = FormConfigurations.getStreetConfig();
        config.setFulFiller((company, value) -> company.getAddress().setStreet(value));
        if (warehouse.getAddress() != null) {
            config.setInitValue(warehouse.getAddress().getStreet());
        }
        return config;
    }

    private EditTextFormRowConfig<UpdateWarehouseRequest> getHouseNumberConfig() {
        EditTextFormRowConfig<UpdateWarehouseRequest> config = FormConfigurations.getHouseNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setHouseNumber(value));
        if (warehouse.getAddress() != null) {
            config.setInitValue(warehouse.getAddress().getHouseNumber());
        }
        return config;
    }

    private EditTextFormRowConfig<UpdateWarehouseRequest> getApartmentNumberConfig() {
        EditTextFormRowConfig<UpdateWarehouseRequest> config = FormConfigurations.getApartmentNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setApartmentNumber(value));
        if (warehouse.getAddress() != null) {
            config.setInitValue(warehouse.getAddress().getApartmentNumber());
        }
        return config;
    }
}

