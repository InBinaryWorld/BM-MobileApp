package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.config.BaseDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.DetailsRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.SimpleTextViewDetailsRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.SimpleTextViewDetailsRowConfig;

public class IndividualContactDetailsConfig extends BaseDetailsConfig<IndividualContact> {

    public IndividualContactDetailsConfig(LayoutInflater inflater, ViewGroup viewGroup) {
        super(inflater, viewGroup);
    }

    @Override
    public List<DetailsRowInterface<IndividualContact>> createRowsConfiguration() {
        List<DetailsRowInterface<IndividualContact>> configs = new ArrayList<>();
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getFirstNameConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getLastNameConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getPhoneConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getCountryConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getCityConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getPostalCodeConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getStreetConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getHouseNumberConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getApartmentNumberConfig()));
        return configs;
    }

    private SimpleTextViewDetailsRowConfig<IndividualContact> getFirstNameConfig() {
        SimpleTextViewDetailsRowConfig<IndividualContact> config = DetailsConfigurations.getFirstNameConfig();
        config.setValueExtractor(IndividualContact::getFirstName);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<IndividualContact> getLastNameConfig() {
        SimpleTextViewDetailsRowConfig<IndividualContact> config = DetailsConfigurations.getLastNameConfig();
        config.setValueExtractor(IndividualContact::getLastName);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<IndividualContact> getPhoneConfig() {
        SimpleTextViewDetailsRowConfig<IndividualContact> config = DetailsConfigurations.getPhoneConfig();
        config.setValueExtractor(IndividualContact::getPhone);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<IndividualContact> getCountryConfig() {
        SimpleTextViewDetailsRowConfig<IndividualContact> config = DetailsConfigurations.getFirstNameConfig();
        config.setValueExtractor(contact -> contact.getAddress() != null ? contact.getAddress().getCountry() : null);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<IndividualContact> getCityConfig() {
        SimpleTextViewDetailsRowConfig<IndividualContact> config = DetailsConfigurations.getCityConfig();
        config.setValueExtractor(contact -> contact.getAddress() != null ? contact.getAddress().getCity() : null);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<IndividualContact> getPostalCodeConfig() {
        SimpleTextViewDetailsRowConfig<IndividualContact> config = DetailsConfigurations.getPostalCodeConfig();
        config.setValueExtractor(contact -> contact.getAddress() != null ? contact.getAddress().getPostalCode() : null);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<IndividualContact> getStreetConfig() {
        SimpleTextViewDetailsRowConfig<IndividualContact> config = DetailsConfigurations.getStreetConfig();
        config.setValueExtractor(contact -> contact.getAddress() != null ? contact.getAddress().getStreet() : null);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<IndividualContact> getHouseNumberConfig() {
        SimpleTextViewDetailsRowConfig<IndividualContact> config = DetailsConfigurations.getHouseNumberConfig();
        config.setValueExtractor(contact -> contact.getAddress() != null ? contact.getAddress().getHouseNumber() : null);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<IndividualContact> getApartmentNumberConfig() {
        SimpleTextViewDetailsRowConfig<IndividualContact> config = DetailsConfigurations.getApartmentNumberConfig();
        config.setValueExtractor(contact -> contact.getAddress() != null ? contact.getAddress().getApartmentNumber() : null);
        return config;
    }
}

