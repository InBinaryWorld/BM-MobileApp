package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRowConfig;

public class CompanyContactCreateFormConfig extends BaseFormConfig<CreateCompanyContactRequest> {

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
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCompanyNameConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getTaxIdentityNumberConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getPhoneConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCountryConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCityConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getPostalCodeConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getStreetConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getHouseNumberConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getApartmentNumberConfig()));
        return configs;
    }

    private EditTextFormRowConfig<CreateCompanyContactRequest> getCompanyNameConfig() {
        EditTextFormRowConfig<CreateCompanyContactRequest> config = FormConfigurations.getCompanyNameConfig();
        config.setFulFiller(CreateCompanyContactRequest::setName);
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyContactRequest> getTaxIdentityNumberConfig() {
        EditTextFormRowConfig<CreateCompanyContactRequest> config = FormConfigurations.getTaxIdentityNumberConfig();
        config.setFulFiller(CreateCompanyContactRequest::setTaxIdentityNumber);
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyContactRequest> getPhoneConfig() {
        EditTextFormRowConfig<CreateCompanyContactRequest> config = FormConfigurations.getPhoneConfig();
        config.setFulFiller(CreateCompanyContactRequest::setPhone);
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyContactRequest> getCountryConfig() {
        EditTextFormRowConfig<CreateCompanyContactRequest> config = FormConfigurations.getCountryConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCountry(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyContactRequest> getCityConfig() {
        EditTextFormRowConfig<CreateCompanyContactRequest> config = FormConfigurations.getCityConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCity(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyContactRequest> getPostalCodeConfig() {
        EditTextFormRowConfig<CreateCompanyContactRequest> config = FormConfigurations.getPostalCodeConfig();
        config.setFulFiller((company, value) -> company.getAddress().setPostalCode(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyContactRequest> getStreetConfig() {
        EditTextFormRowConfig<CreateCompanyContactRequest> config = FormConfigurations.getStreetConfig();
        config.setFulFiller((company, value) -> company.getAddress().setStreet(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyContactRequest> getHouseNumberConfig() {
        EditTextFormRowConfig<CreateCompanyContactRequest> config = FormConfigurations.getHouseNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setHouseNumber(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyContactRequest> getApartmentNumberConfig() {
        EditTextFormRowConfig<CreateCompanyContactRequest> config = FormConfigurations.getApartmentNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setApartmentNumber(value));
        return config;
    }

}

