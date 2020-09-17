package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.config.BaseDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.DetailsRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.SimpleTextViewDetailsRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.SimpleTextViewDetailsRowConfig;

public class WarehouseDetailsConfig extends BaseDetailsConfig<Warehouse> {

    public WarehouseDetailsConfig(LayoutInflater inflater, ViewGroup viewGroup) {
        super(inflater, viewGroup);
    }

    @Override
    public List<DetailsRowInterface<Warehouse>> createRowsConfiguration() {
        List<DetailsRowInterface<Warehouse>> configs = new ArrayList<>();
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getCompanyNameConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getCountryConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getCityConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getPostalCodeConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getStreetConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getHouseNumberConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getApartmentNumberConfig()));
        return configs;
    }

    private SimpleTextViewDetailsRowConfig<Warehouse> getCompanyNameConfig() {
        SimpleTextViewDetailsRowConfig<Warehouse> config = DetailsConfigurations.getWarehouseName();
        config.setValueExtractor(Warehouse::getName);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<Warehouse> getCountryConfig() {
        SimpleTextViewDetailsRowConfig<Warehouse> config = DetailsConfigurations.getFirstNameConfig();
        config.setValueExtractor(warehouse -> warehouse.getAddress() != null ? warehouse.getAddress().getCountry() : null);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<Warehouse> getCityConfig() {
        SimpleTextViewDetailsRowConfig<Warehouse> config = DetailsConfigurations.getCityConfig();
        config.setValueExtractor(warehouse -> warehouse.getAddress() != null ? warehouse.getAddress().getCity() : null);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<Warehouse> getPostalCodeConfig() {
        SimpleTextViewDetailsRowConfig<Warehouse> config = DetailsConfigurations.getPostalCodeConfig();
        config.setValueExtractor(warehouse -> warehouse.getAddress() != null ? warehouse.getAddress().getPostalCode() : null);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<Warehouse> getStreetConfig() {
        SimpleTextViewDetailsRowConfig<Warehouse> config = DetailsConfigurations.getStreetConfig();
        config.setValueExtractor(warehouse -> warehouse.getAddress() != null ? warehouse.getAddress().getStreet() : null);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<Warehouse> getHouseNumberConfig() {
        SimpleTextViewDetailsRowConfig<Warehouse> config = DetailsConfigurations.getHouseNumberConfig();
        config.setValueExtractor(warehouse -> warehouse.getAddress() != null ? warehouse.getAddress().getHouseNumber() : null);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<Warehouse> getApartmentNumberConfig() {
        SimpleTextViewDetailsRowConfig<Warehouse> config = DetailsConfigurations.getApartmentNumberConfig();
        config.setValueExtractor(warehouse -> warehouse.getAddress() != null ? warehouse.getAddress().getApartmentNumber() : null);
        return config;
    }
}

