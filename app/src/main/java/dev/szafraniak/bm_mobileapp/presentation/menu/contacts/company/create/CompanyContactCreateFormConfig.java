package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormRow;

public class CompanyContactCreateFormConfig extends BaseFormRow.BaseFormConfig<CreateCompanyContactRequest> {

    public CompanyContactCreateFormConfig(LayoutInflater inflater, ViewGroup viewGroup) {
        super(inflater, viewGroup);
    }

    @Override
    protected String getSubmitButtonText() {
        return "CREATE CONTACT";
    }

    @Override
    public List<FormRowInterface<CreateCompanyContactRequest>> createRowsConfiguration() {
        List<FormRowInterface<CreateCompanyContactRequest>> configs = new ArrayList<>();
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCompanyNameConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getTaxIdentityNumberConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getPhoneConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCountryConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCityConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getPostalCodeConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getStreetConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getHouseNumberConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getApartmentNumberConfig()));
        return configs;
    }

    private TextFormConfig<CreateCompanyContactRequest> getCompanyNameConfig() {
        TextFormConfig<CreateCompanyContactRequest> config = FormConfigurations.getCompanyNameConfig();
        config.setFulFiller(CreateCompanyContactRequest::setName);
        return config;
    }

    private TextFormConfig<CreateCompanyContactRequest> getTaxIdentityNumberConfig() {
        TextFormConfig<CreateCompanyContactRequest> config = FormConfigurations.getTaxIdentityNumberConfig();
        config.setFulFiller(CreateCompanyContactRequest::setTaxIdentityNumber);
        return config;
    }

    private TextFormConfig<CreateCompanyContactRequest> getPhoneConfig() {
        TextFormConfig<CreateCompanyContactRequest> config = FormConfigurations.getPhoneConfig();
        config.setFulFiller(CreateCompanyContactRequest::setPhone);
        return config;
    }

    private TextFormConfig<CreateCompanyContactRequest> getCountryConfig() {
        TextFormConfig<CreateCompanyContactRequest> config = FormConfigurations.getCountryConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCountry(value));
        return config;
    }

    private TextFormConfig<CreateCompanyContactRequest> getCityConfig() {
        TextFormConfig<CreateCompanyContactRequest> config = FormConfigurations.getCityConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCity(value));
        return config;
    }

    private TextFormConfig<CreateCompanyContactRequest> getPostalCodeConfig() {
        TextFormConfig<CreateCompanyContactRequest> config = FormConfigurations.getPostalCodeConfig();
        config.setFulFiller((company, value) -> company.getAddress().setPostalCode(value));
        return config;
    }

    private TextFormConfig<CreateCompanyContactRequest> getStreetConfig() {
        TextFormConfig<CreateCompanyContactRequest> config = FormConfigurations.getStreetConfig();
        config.setFulFiller((company, value) -> company.getAddress().setStreet(value));
        return config;
    }

    private TextFormConfig<CreateCompanyContactRequest> getHouseNumberConfig() {
        TextFormConfig<CreateCompanyContactRequest> config = FormConfigurations.getHouseNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setHouseNumber(value));
        return config;
    }

    private TextFormConfig<CreateCompanyContactRequest> getApartmentNumberConfig() {
        TextFormConfig<CreateCompanyContactRequest> config = FormConfigurations.getApartmentNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setApartmentNumber(value));
        return config;
    }

}

