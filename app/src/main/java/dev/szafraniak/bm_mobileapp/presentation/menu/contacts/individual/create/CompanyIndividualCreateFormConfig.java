package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.SimpleBaseConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRowConfig;

public class CompanyIndividualCreateFormConfig extends SimpleBaseConfig<CreateIndividualContactRequest> {

    public CompanyIndividualCreateFormConfig(LayoutInflater inflater, ViewGroup viewGroup) {
        super(inflater, viewGroup);
    }

    @Override
    protected String getSubmitButtonText() {
        return "CREATE COMPANY";
    }

    @Override
    public List<FormRowInterface<CreateIndividualContactRequest>> createRowsConfiguration() {
        List<FormRowInterface<CreateIndividualContactRequest>> configs = new ArrayList<>();
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getFirstNameConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getLastNameConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getPhoneConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCountryConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCityConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getPostalCodeConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getStreetConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getHouseNumberConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getApartmentNumberConfig()));
        return configs;
    }

    private EditTextFormRowConfig<CreateIndividualContactRequest> getFirstNameConfig() {
        EditTextFormRowConfig<CreateIndividualContactRequest> config = FormConfigurations.getFirstNameConfig();
        config.setFulFiller(CreateIndividualContactRequest::setFirstName);
        return config;
    }

    private EditTextFormRowConfig<CreateIndividualContactRequest> getLastNameConfig() {
        EditTextFormRowConfig<CreateIndividualContactRequest> config = FormConfigurations.getLastNameConfig();
        config.setFulFiller(CreateIndividualContactRequest::setLastName);
        return config;
    }

    private EditTextFormRowConfig<CreateIndividualContactRequest> getPhoneConfig() {
        EditTextFormRowConfig<CreateIndividualContactRequest> config = FormConfigurations.getPhoneConfig();
        config.setFulFiller(CreateIndividualContactRequest::setPhone);
        return config;
    }

    private EditTextFormRowConfig<CreateIndividualContactRequest> getCountryConfig() {
        EditTextFormRowConfig<CreateIndividualContactRequest> config = FormConfigurations.getCountryConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCountry(value));
        return config;
    }

    private EditTextFormRowConfig<CreateIndividualContactRequest> getCityConfig() {
        EditTextFormRowConfig<CreateIndividualContactRequest> config = FormConfigurations.getCityConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCity(value));
        return config;
    }

    private EditTextFormRowConfig<CreateIndividualContactRequest> getPostalCodeConfig() {
        EditTextFormRowConfig<CreateIndividualContactRequest> config = FormConfigurations.getPostalCodeConfig();
        config.setFulFiller((company, value) -> company.getAddress().setPostalCode(value));
        return config;
    }

    private EditTextFormRowConfig<CreateIndividualContactRequest> getStreetConfig() {
        EditTextFormRowConfig<CreateIndividualContactRequest> config = FormConfigurations.getStreetConfig();
        config.setFulFiller((company, value) -> company.getAddress().setStreet(value));
        return config;
    }

    private EditTextFormRowConfig<CreateIndividualContactRequest> getHouseNumberConfig() {
        EditTextFormRowConfig<CreateIndividualContactRequest> config = FormConfigurations.getHouseNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setHouseNumber(value));
        return config;
    }

    private EditTextFormRowConfig<CreateIndividualContactRequest> getApartmentNumberConfig() {
        EditTextFormRowConfig<CreateIndividualContactRequest> config = FormConfigurations.getApartmentNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setApartmentNumber(value));
        return config;
    }
}

