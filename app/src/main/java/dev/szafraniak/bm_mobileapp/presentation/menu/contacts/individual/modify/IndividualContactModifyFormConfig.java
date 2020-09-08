package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.UpdateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRowConfig;

public class IndividualContactModifyFormConfig extends BaseFormConfig<UpdateIndividualContactRequest> {

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

    private EditTextFormRowConfig<UpdateIndividualContactRequest> getFirstNameConfig() {
        EditTextFormRowConfig<UpdateIndividualContactRequest> config = FormConfigurations.getFirstNameConfig();
        config.setFulFiller(UpdateIndividualContactRequest::setFirstName);
        config.setInitValue(individualContact.getFirstName());
        return config;
    }

    private EditTextFormRowConfig<UpdateIndividualContactRequest> getLastNameConfig() {
        EditTextFormRowConfig<UpdateIndividualContactRequest> config = FormConfigurations.getLastNameConfig();
        config.setFulFiller(UpdateIndividualContactRequest::setLastName);
        config.setInitValue(individualContact.getLastName());
        return config;
    }

    private EditTextFormRowConfig<UpdateIndividualContactRequest> getPhoneConfig() {
        EditTextFormRowConfig<UpdateIndividualContactRequest> config = FormConfigurations.getPhoneConfig();
        config.setFulFiller(UpdateIndividualContactRequest::setPhone);
        config.setInitValue(individualContact.getPhone());
        return config;
    }

    private EditTextFormRowConfig<UpdateIndividualContactRequest> getCountryConfig() {
        EditTextFormRowConfig<UpdateIndividualContactRequest> config = FormConfigurations.getCountryConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCountry(value));
        config.setInitValue(individualContact.getAddress().getCountry());
        return config;
    }

    private EditTextFormRowConfig<UpdateIndividualContactRequest> getCityConfig() {
        EditTextFormRowConfig<UpdateIndividualContactRequest> config = FormConfigurations.getCityConfig();
        config.setFulFiller((company, value) -> company.getAddress().setCity(value));
        config.setInitValue(individualContact.getAddress().getCity());
        return config;
    }

    private EditTextFormRowConfig<UpdateIndividualContactRequest> getPostalCodeConfig() {
        EditTextFormRowConfig<UpdateIndividualContactRequest> config = FormConfigurations.getPostalCodeConfig();
        config.setFulFiller((company, value) -> company.getAddress().setPostalCode(value));
        config.setInitValue(individualContact.getAddress().getPostalCode());
        return config;
    }

    private EditTextFormRowConfig<UpdateIndividualContactRequest> getStreetConfig() {
        EditTextFormRowConfig<UpdateIndividualContactRequest> config = FormConfigurations.getStreetConfig();
        config.setFulFiller((company, value) -> company.getAddress().setStreet(value));
        config.setInitValue(individualContact.getAddress().getStreet());
        return config;
    }

    private EditTextFormRowConfig<UpdateIndividualContactRequest> getHouseNumberConfig() {
        EditTextFormRowConfig<UpdateIndividualContactRequest> config = FormConfigurations.getHouseNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setHouseNumber(value));
        config.setInitValue(individualContact.getAddress().getHouseNumber());
        return config;
    }

    private EditTextFormRowConfig<UpdateIndividualContactRequest> getApartmentNumberConfig() {
        EditTextFormRowConfig<UpdateIndividualContactRequest> config = FormConfigurations.getApartmentNumberConfig();
        config.setFulFiller((company, value) -> company.getAddress().setApartmentNumber(value));
        config.setInitValue(individualContact.getAddress().getApartmentNumber());
        return config;
    }
}

