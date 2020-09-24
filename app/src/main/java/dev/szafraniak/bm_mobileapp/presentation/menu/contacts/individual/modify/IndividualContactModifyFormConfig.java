package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.UpdateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormRow;

public class IndividualContactModifyFormConfig extends BaseFormRow.BaseFormConfig<UpdateIndividualContactRequest> {

    private final IndividualContact individualContact;

    public IndividualContactModifyFormConfig(LayoutInflater inflater, ViewGroup viewGroup, IndividualContact individualContact) {
        super(inflater, viewGroup);
        this.individualContact = individualContact;
    }

    @Override
    protected String getSubmitButtonText() {
        return "MODIFY CONTACT";
    }

    @Override
    public List<FormRowInterface<UpdateIndividualContactRequest>> createRowsConfiguration() {
        List<FormRowInterface<UpdateIndividualContactRequest>> configs = new ArrayList<>();
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

    private TextFormConfig<UpdateIndividualContactRequest> getFirstNameConfig() {
        TextFormConfig<UpdateIndividualContactRequest> config = FormConfigurations.getFirstNameConfig();
        config.setFulFiller(UpdateIndividualContactRequest::setFirstName);
        config.setInitValue(individualContact.getFirstName());
        return config;
    }

    private TextFormConfig<UpdateIndividualContactRequest> getLastNameConfig() {
        TextFormConfig<UpdateIndividualContactRequest> config = FormConfigurations.getLastNameConfig();
        config.setFulFiller(UpdateIndividualContactRequest::setLastName);
        config.setInitValue(individualContact.getLastName());
        return config;
    }

    private TextFormConfig<UpdateIndividualContactRequest> getPhoneConfig() {
        TextFormConfig<UpdateIndividualContactRequest> config = FormConfigurations.getPhoneConfig();
        config.setFulFiller(UpdateIndividualContactRequest::setPhone);
        config.setInitValue(individualContact.getPhone());
        return config;
    }

    private TextFormConfig<UpdateIndividualContactRequest> getCountryConfig() {
        TextFormConfig<UpdateIndividualContactRequest> config = FormConfigurations.getCountryConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCountry(value));
        config.setInitValue(individualContact.getAddress().getCountry());
        return config;
    }

    private TextFormConfig<UpdateIndividualContactRequest> getCityConfig() {
        TextFormConfig<UpdateIndividualContactRequest> config = FormConfigurations.getCityConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCity(value));
        config.setInitValue(individualContact.getAddress().getCity());
        return config;
    }

    private TextFormConfig<UpdateIndividualContactRequest> getPostalCodeConfig() {
        TextFormConfig<UpdateIndividualContactRequest> config = FormConfigurations.getPostalCodeConfig();
        config.setFulFiller((company, value) -> company.getAddress().setPostalCode(value));
        config.setInitValue(individualContact.getAddress().getPostalCode());
        return config;
    }

    private TextFormConfig<UpdateIndividualContactRequest> getStreetConfig() {
        TextFormConfig<UpdateIndividualContactRequest> config = FormConfigurations.getStreetConfig();
        config.setFulFiller((company, value) -> company.getAddress().setStreet(value));
        config.setInitValue(individualContact.getAddress().getStreet());
        return config;
    }

    private TextFormConfig<UpdateIndividualContactRequest> getHouseNumberConfig() {
        TextFormConfig<UpdateIndividualContactRequest> config = FormConfigurations.getHouseNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setHouseNumber(value));
        config.setInitValue(individualContact.getAddress().getHouseNumber());
        return config;
    }

    private TextFormConfig<UpdateIndividualContactRequest> getApartmentNumberConfig() {
        TextFormConfig<UpdateIndividualContactRequest> config = FormConfigurations.getApartmentNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setApartmentNumber(value));
        config.setInitValue(individualContact.getAddress().getApartmentNumber());
        return config;
    }
}

