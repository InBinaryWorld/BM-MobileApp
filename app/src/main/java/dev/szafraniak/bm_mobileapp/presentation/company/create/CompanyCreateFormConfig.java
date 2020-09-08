package dev.szafraniak.bm_mobileapp.presentation.company.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRowConfig;

public class CompanyCreateFormConfig extends BaseFormConfig<CreateCompanyRequest> {

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
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCompanyNameConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getInvoicePrefixConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getTaxIdentityNumberConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCountryConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCityConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getPostalCodeConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getStreetConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getHouseNumberConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getApartmentNumberConfig()));
        return configs;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getCompanyNameConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = FormConfigurations.getCompanyNameConfig();
        config.setFulFiller(CreateCompanyRequest::setName);
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getInvoicePrefixConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = FormConfigurations.getInvoicePrefixConfig();
        config.setFulFiller(CreateCompanyRequest::setInvoicePrefix);
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getTaxIdentityNumberConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = FormConfigurations.getTaxIdentityNumberConfig();
        config.setFulFiller(CreateCompanyRequest::setTaxIdentityNumber);
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getCountryConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = FormConfigurations.getCountryConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setCountry(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getCityConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = FormConfigurations.getCityConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setCity(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getPostalCodeConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = FormConfigurations.getPostalCodeConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setPostalCode(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getStreetConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = FormConfigurations.getStreetConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setStreet(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getHouseNumberConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = FormConfigurations.getHouseNumberConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setHouseNumber(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getApartmentNumberConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = FormConfigurations.getApartmentNumberConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setApartmentNumber(value));
        return config;
    }

}

