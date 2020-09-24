package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.UpdateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormRow;

public class CompanyContactModifyFormConfig extends BaseFormRow.BaseFormConfig<UpdateCompanyContactRequest> {

    private final CompanyContact companyContact;

    public CompanyContactModifyFormConfig(LayoutInflater inflater, ViewGroup viewGroup, CompanyContact companyContact) {
        super(inflater, viewGroup);
        this.companyContact = companyContact;
    }

    @Override
    protected String getSubmitButtonText() {
        return "MODIFY CONTACT";
    }

    @Override
    public List<FormRowInterface<UpdateCompanyContactRequest>> createRowsConfiguration() {
        List<FormRowInterface<UpdateCompanyContactRequest>> configs = new ArrayList<>();
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

    private TextFormConfig<UpdateCompanyContactRequest> getCompanyNameConfig() {
        TextFormConfig<UpdateCompanyContactRequest> config = FormConfigurations.getCompanyNameConfig();
        config.setFulFiller(UpdateCompanyContactRequest::setName);
        config.setInitValue(companyContact.getName());
        return config;
    }

    private TextFormConfig<UpdateCompanyContactRequest> getTaxIdentityNumberConfig() {
        TextFormConfig<UpdateCompanyContactRequest> config = FormConfigurations.getTaxIdentityNumberConfig();
        config.setFulFiller(UpdateCompanyContactRequest::setTaxIdentityNumber);
        config.setInitValue(companyContact.getTaxIdentityNumber());
        return config;
    }

    private TextFormConfig<UpdateCompanyContactRequest> getPhoneConfig() {
        TextFormConfig<UpdateCompanyContactRequest> config = FormConfigurations.getPhoneConfig();
        config.setFulFiller(UpdateCompanyContactRequest::setPhone);
        config.setInitValue(companyContact.getPhone());
        return config;
    }

    private TextFormConfig<UpdateCompanyContactRequest> getCountryConfig() {
        TextFormConfig<UpdateCompanyContactRequest> config = FormConfigurations.getCountryConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCountry(value));
        config.setInitValue(companyContact.getAddress().getCountry());
        return config;
    }

    private TextFormConfig<UpdateCompanyContactRequest> getCityConfig() {
        TextFormConfig<UpdateCompanyContactRequest> config = FormConfigurations.getCityConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCity(value));
        config.setInitValue(companyContact.getAddress().getCity());
        return config;
    }

    private TextFormConfig<UpdateCompanyContactRequest> getPostalCodeConfig() {
        TextFormConfig<UpdateCompanyContactRequest> config = FormConfigurations.getPostalCodeConfig();
        config.setFulFiller((company, value) -> company.getAddress().setPostalCode(value));
        config.setInitValue(companyContact.getAddress().getPostalCode());
        return config;
    }

    private TextFormConfig<UpdateCompanyContactRequest> getStreetConfig() {
        TextFormConfig<UpdateCompanyContactRequest> config = FormConfigurations.getStreetConfig();
        config.setFulFiller((company, value) -> company.getAddress().setStreet(value));
        config.setInitValue(companyContact.getAddress().getStreet());
        return config;
    }

    private TextFormConfig<UpdateCompanyContactRequest> getHouseNumberConfig() {
        TextFormConfig<UpdateCompanyContactRequest> config = FormConfigurations.getHouseNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setHouseNumber(value));
        config.setInitValue(companyContact.getAddress().getHouseNumber());
        return config;
    }

    private TextFormConfig<UpdateCompanyContactRequest> getApartmentNumberConfig() {
        TextFormConfig<UpdateCompanyContactRequest> config = FormConfigurations.getApartmentNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setApartmentNumber(value));
        config.setInitValue(companyContact.getAddress().getApartmentNumber());
        return config;
    }
}

