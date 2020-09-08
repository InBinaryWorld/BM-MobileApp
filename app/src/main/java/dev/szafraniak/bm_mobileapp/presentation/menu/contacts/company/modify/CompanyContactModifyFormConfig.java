package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.UpdateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRowConfig;

public class CompanyContactModifyFormConfig extends BaseFormConfig<UpdateCompanyContactRequest> {

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

    private EditTextFormRowConfig<UpdateCompanyContactRequest> getCompanyNameConfig() {
        EditTextFormRowConfig<UpdateCompanyContactRequest> config = FormConfigurations.getCompanyNameConfig();
        config.setFulFiller(UpdateCompanyContactRequest::setName);
        config.setInitValue(companyContact.getName());
        return config;
    }

    private EditTextFormRowConfig<UpdateCompanyContactRequest> getTaxIdentityNumberConfig() {
        EditTextFormRowConfig<UpdateCompanyContactRequest> config = FormConfigurations.getTaxIdentityNumberConfig();
        config.setFulFiller(UpdateCompanyContactRequest::setTaxIdentityNumber);
        config.setInitValue(companyContact.getTaxIdentityNumber());
        return config;
    }

    private EditTextFormRowConfig<UpdateCompanyContactRequest> getPhoneConfig() {
        EditTextFormRowConfig<UpdateCompanyContactRequest> config = FormConfigurations.getPhoneConfig();
        config.setFulFiller(UpdateCompanyContactRequest::setPhone);
        config.setInitValue(companyContact.getPhone());
        return config;
    }

    private EditTextFormRowConfig<UpdateCompanyContactRequest> getCountryConfig() {
        EditTextFormRowConfig<UpdateCompanyContactRequest> config = FormConfigurations.getCountryConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCountry(value));
        config.setInitValue(companyContact.getAddress().getCountry());
        return config;
    }

    private EditTextFormRowConfig<UpdateCompanyContactRequest> getCityConfig() {
        EditTextFormRowConfig<UpdateCompanyContactRequest> config = FormConfigurations.getCityConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCity(value));
        config.setInitValue(companyContact.getAddress().getCity());
        return config;
    }

    private EditTextFormRowConfig<UpdateCompanyContactRequest> getPostalCodeConfig() {
        EditTextFormRowConfig<UpdateCompanyContactRequest> config = FormConfigurations.getPostalCodeConfig();
        config.setFulFiller((company, value) -> company.getAddress().setPostalCode(value));
        config.setInitValue(companyContact.getAddress().getPostalCode());
        return config;
    }

    private EditTextFormRowConfig<UpdateCompanyContactRequest> getStreetConfig() {
        EditTextFormRowConfig<UpdateCompanyContactRequest> config = FormConfigurations.getStreetConfig();
        config.setFulFiller((company, value) -> company.getAddress().setStreet(value));
        config.setInitValue(companyContact.getAddress().getStreet());
        return config;
    }

    private EditTextFormRowConfig<UpdateCompanyContactRequest> getHouseNumberConfig() {
        EditTextFormRowConfig<UpdateCompanyContactRequest> config = FormConfigurations.getHouseNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setHouseNumber(value));
        config.setInitValue(companyContact.getAddress().getHouseNumber());
        return config;
    }

    private EditTextFormRowConfig<UpdateCompanyContactRequest> getApartmentNumberConfig() {
        EditTextFormRowConfig<UpdateCompanyContactRequest> config = FormConfigurations.getApartmentNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setApartmentNumber(value));
        config.setInitValue(companyContact.getAddress().getApartmentNumber());
        return config;
    }
}

