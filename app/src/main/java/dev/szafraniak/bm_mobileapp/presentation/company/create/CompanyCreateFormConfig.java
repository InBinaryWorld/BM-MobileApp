package dev.szafraniak.bm_mobileapp.presentation.company.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormRow;

public class CompanyCreateFormConfig extends BaseFormRow.BaseFormConfig<CreateCompanyRequest> {

    public CompanyCreateFormConfig(LayoutInflater inflater, ViewGroup viewGroup) {
        super(inflater, viewGroup);
    }

    @Override
    protected String getSubmitButtonText() {
        return "CREATE COMPANY";
    }

    @Override
    public List<FormRowInterface<CreateCompanyRequest>> createRowsConfiguration() {
        List<FormRowInterface<CreateCompanyRequest>> configs = new ArrayList<>();
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCompanyNameConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getInvoicePrefixConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getTaxIdentityNumberConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCountryConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCityConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getPostalCodeConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getStreetConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getHouseNumberConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getApartmentNumberConfig()));
        return configs;
    }

    private TextFormConfig<CreateCompanyRequest> getCompanyNameConfig() {
        TextFormConfig<CreateCompanyRequest> config = FormConfigurations.getCompanyNameConfig();
        config.setFulFiller(CreateCompanyRequest::setName);
        return config;
    }

    private TextFormConfig<CreateCompanyRequest> getInvoicePrefixConfig() {
        TextFormConfig<CreateCompanyRequest> config = FormConfigurations.getInvoicePrefixConfig();
        config.setFulFiller(CreateCompanyRequest::setInvoicePrefix);
        return config;
    }

    private TextFormConfig<CreateCompanyRequest> getTaxIdentityNumberConfig() {
        TextFormConfig<CreateCompanyRequest> config = FormConfigurations.getTaxIdentityNumberConfig();
        config.setFulFiller(CreateCompanyRequest::setTaxIdentityNumber);
        return config;
    }

    private TextFormConfig<CreateCompanyRequest> getCountryConfig() {
        TextFormConfig<CreateCompanyRequest> config = FormConfigurations.getCountryConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setCountry(value));
        return config;
    }

    private TextFormConfig<CreateCompanyRequest> getCityConfig() {
        TextFormConfig<CreateCompanyRequest> config = FormConfigurations.getCityConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setCity(value));
        return config;
    }

    private TextFormConfig<CreateCompanyRequest> getPostalCodeConfig() {
        TextFormConfig<CreateCompanyRequest> config = FormConfigurations.getPostalCodeConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setPostalCode(value));
        return config;
    }

    private TextFormConfig<CreateCompanyRequest> getStreetConfig() {
        TextFormConfig<CreateCompanyRequest> config = FormConfigurations.getStreetConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setStreet(value));
        return config;
    }

    private TextFormConfig<CreateCompanyRequest> getHouseNumberConfig() {
        TextFormConfig<CreateCompanyRequest> config = FormConfigurations.getHouseNumberConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setHouseNumber(value));
        return config;
    }

    private TextFormConfig<CreateCompanyRequest> getApartmentNumberConfig() {
        TextFormConfig<CreateCompanyRequest> config = FormConfigurations.getApartmentNumberConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setApartmentNumber(value));
        return config;
    }

}

