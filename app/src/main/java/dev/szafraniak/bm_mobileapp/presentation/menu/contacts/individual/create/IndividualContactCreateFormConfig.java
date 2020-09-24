package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormRow;

public class IndividualContactCreateFormConfig extends BaseFormRow.BaseFormConfig<CreateIndividualContactRequest> {

    public IndividualContactCreateFormConfig(LayoutInflater inflater, ViewGroup viewGroup) {
        super(inflater, viewGroup);
    }

    @Override
    protected String getSubmitButtonText() {
        return "CREATE CONTACT";
    }

    @Override
    public List<FormRowInterface<CreateIndividualContactRequest>> createRowsConfiguration() {
        List<FormRowInterface<CreateIndividualContactRequest>> configs = new ArrayList<>();
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getFirstNameConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getLastNameConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getPhoneConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCountryConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCityConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getPostalCodeConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getStreetConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getHouseNumberConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getApartmentNumberConfig()));
        return configs;
    }

    private TextFormConfig<CreateIndividualContactRequest> getFirstNameConfig() {
        TextFormConfig<CreateIndividualContactRequest> config = FormConfigurations.getFirstNameConfig();
        config.setFulFiller(CreateIndividualContactRequest::setFirstName);
        return config;
    }

    private TextFormConfig<CreateIndividualContactRequest> getLastNameConfig() {
        TextFormConfig<CreateIndividualContactRequest> config = FormConfigurations.getLastNameConfig();
        config.setFulFiller(CreateIndividualContactRequest::setLastName);
        return config;
    }

    private TextFormConfig<CreateIndividualContactRequest> getPhoneConfig() {
        TextFormConfig<CreateIndividualContactRequest> config = FormConfigurations.getPhoneConfig();
        config.setFulFiller(CreateIndividualContactRequest::setPhone);
        return config;
    }

    private TextFormConfig<CreateIndividualContactRequest> getCountryConfig() {
        TextFormConfig<CreateIndividualContactRequest> config = FormConfigurations.getCountryConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCountry(value));
        return config;
    }

    private TextFormConfig<CreateIndividualContactRequest> getCityConfig() {
        TextFormConfig<CreateIndividualContactRequest> config = FormConfigurations.getCityConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCity(value));
        return config;
    }

    private TextFormConfig<CreateIndividualContactRequest> getPostalCodeConfig() {
        TextFormConfig<CreateIndividualContactRequest> config = FormConfigurations.getPostalCodeConfig();
        config.setFulFiller((company, value) -> company.getAddress().setPostalCode(value));
        return config;
    }

    private TextFormConfig<CreateIndividualContactRequest> getStreetConfig() {
        TextFormConfig<CreateIndividualContactRequest> config = FormConfigurations.getStreetConfig();
        config.setFulFiller((company, value) -> company.getAddress().setStreet(value));
        return config;
    }

    private TextFormConfig<CreateIndividualContactRequest> getHouseNumberConfig() {
        TextFormConfig<CreateIndividualContactRequest> config = FormConfigurations.getHouseNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setHouseNumber(value));
        return config;
    }

    private TextFormConfig<CreateIndividualContactRequest> getApartmentNumberConfig() {
        TextFormConfig<CreateIndividualContactRequest> config = FormConfigurations.getApartmentNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setApartmentNumber(value));
        return config;
    }
}

