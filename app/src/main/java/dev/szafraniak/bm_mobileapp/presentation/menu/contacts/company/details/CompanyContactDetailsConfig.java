package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.config.BaseDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.DetailsRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.SimpleTextViewDetailsRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.SimpleTextViewDetailsRowConfig;

public class CompanyContactDetailsConfig extends BaseDetailsConfig<CompanyContact> {

    public CompanyContactDetailsConfig(LayoutInflater inflater, ViewGroup viewGroup) {
        super(inflater, viewGroup);
    }

    @Override
    public List<DetailsRowInterface<CompanyContact>> createRowsConfiguration() {
        List<DetailsRowInterface<CompanyContact>> configs = new ArrayList<>();
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getCompanyNameConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getTaxIdentityNumberConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getPhoneConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getCountryConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getCityConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getPostalCodeConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getStreetConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getHouseNumberConfig()));
        configs.add(new SimpleTextViewDetailsRow<>(this.inflater, this.viewGroup, getApartmentNumberConfig()));
        return configs;
    }

    private SimpleTextViewDetailsRowConfig<CompanyContact> getCompanyNameConfig() {
        SimpleTextViewDetailsRowConfig<CompanyContact> config = DetailsConfigurations.getCompanyNameConfig();
        config.setValueExtractor(CompanyContact::getName);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<CompanyContact> getTaxIdentityNumberConfig() {
        SimpleTextViewDetailsRowConfig<CompanyContact> config = DetailsConfigurations.getTaxIdentityNumberConfig();
        config.setValueExtractor(CompanyContact::getTaxIdentityNumber);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<CompanyContact> getPhoneConfig() {
        SimpleTextViewDetailsRowConfig<CompanyContact> config = DetailsConfigurations.getPhoneConfig();
        config.setValueExtractor(CompanyContact::getPhone);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<CompanyContact> getCountryConfig() {
        SimpleTextViewDetailsRowConfig<CompanyContact> config = DetailsConfigurations.getFirstNameConfig();
        config.setValueExtractor(contact -> contact.getAddress() != null ? contact.getAddress().getCountry() : null);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<CompanyContact> getCityConfig() {
        SimpleTextViewDetailsRowConfig<CompanyContact> config = DetailsConfigurations.getCityConfig();
        config.setValueExtractor(contact -> contact.getAddress() != null ? contact.getAddress().getCity() : null);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<CompanyContact> getPostalCodeConfig() {
        SimpleTextViewDetailsRowConfig<CompanyContact> config = DetailsConfigurations.getPostalCodeConfig();
        config.setValueExtractor(contact -> contact.getAddress() != null ? contact.getAddress().getPostalCode() : null);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<CompanyContact> getStreetConfig() {
        SimpleTextViewDetailsRowConfig<CompanyContact> config = DetailsConfigurations.getStreetConfig();
        config.setValueExtractor(contact -> contact.getAddress() != null ? contact.getAddress().getStreet() : null);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<CompanyContact> getHouseNumberConfig() {
        SimpleTextViewDetailsRowConfig<CompanyContact> config = DetailsConfigurations.getHouseNumberConfig();
        config.setValueExtractor(contact -> contact.getAddress() != null ? contact.getAddress().getHouseNumber() : null);
        return config;
    }

    private SimpleTextViewDetailsRowConfig<CompanyContact> getApartmentNumberConfig() {
        SimpleTextViewDetailsRowConfig<CompanyContact> config = DetailsConfigurations.getApartmentNumberConfig();
        config.setValueExtractor(contact -> contact.getAddress() != null ? contact.getAddress().getApartmentNumber() : null);
        return config;
    }
}

