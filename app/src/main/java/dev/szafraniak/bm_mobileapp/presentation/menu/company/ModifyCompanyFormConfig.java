package dev.szafraniak.bm_mobileapp.presentation.menu.company;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.UpdateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormRow;

public class ModifyCompanyFormConfig extends BaseFormRow.BaseFormConfig<UpdateCompanyRequest> {

    private final Company company;

    public ModifyCompanyFormConfig(LayoutInflater inflater, ViewGroup viewGroup, Company company) {
        super(inflater, viewGroup);
        this.company = company;
    }

    @Override
    protected String getSubmitButtonText() {
        return "MODIFY COMPANY";
    }

    @Override
    public List<FormRowInterface<UpdateCompanyRequest>> createRowsConfiguration() {
        List<FormRowInterface<UpdateCompanyRequest>> configs = new ArrayList<>();
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCompanyNameConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getTaxIdentityNumberConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getInvoicePrefix()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCountryConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getCityConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getPostalCodeConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getStreetConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getHouseNumberConfig()));
        configs.add(new TextFormRow<>(this.inflater, this.viewGroup, getApartmentNumberConfig()));
        return configs;
    }


    private TextFormConfig<UpdateCompanyRequest> getCompanyNameConfig() {
        TextFormConfig<UpdateCompanyRequest> config = FormConfigurations.getCompanyNameConfig();
        config.setFulFiller(UpdateCompanyRequest::setName);
        config.setInitValue(company.getName());
        return config;
    }

    private TextFormConfig<UpdateCompanyRequest> getTaxIdentityNumberConfig() {
        TextFormConfig<UpdateCompanyRequest> config = FormConfigurations.getTaxIdentityNumberConfig();
        config.setFulFiller(UpdateCompanyRequest::setTaxIdentityNumber);
        config.setInitValue(company.getTaxIdentityNumber());
        return config;
    }

    private TextFormConfig<UpdateCompanyRequest> getInvoicePrefix() {
        TextFormConfig<UpdateCompanyRequest> config = FormConfigurations.getInvoicePrefixConfig();
        config.setFulFiller(UpdateCompanyRequest::setInvoicePrefix);
        config.setInitValue(company.getInvoicePrefix());
        return config;
    }

    private TextFormConfig<UpdateCompanyRequest> getCountryConfig() {
        TextFormConfig<UpdateCompanyRequest> config = FormConfigurations.getCountryConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setCountry(value));
        config.setInitValue(company.getHeadquarter().getCountry());
        return config;
    }

    private TextFormConfig<UpdateCompanyRequest> getCityConfig() {
        TextFormConfig<UpdateCompanyRequest> config = FormConfigurations.getCityConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setCity(value));
        config.setInitValue(company.getHeadquarter().getCity());
        return config;
    }

    private TextFormConfig<UpdateCompanyRequest> getPostalCodeConfig() {
        TextFormConfig<UpdateCompanyRequest> config = FormConfigurations.getPostalCodeConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setPostalCode(value));
        config.setInitValue(company.getHeadquarter().getPostalCode());
        return config;
    }

    private TextFormConfig<UpdateCompanyRequest> getStreetConfig() {
        TextFormConfig<UpdateCompanyRequest> config = FormConfigurations.getStreetConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setStreet(value));
        config.setInitValue(company.getHeadquarter().getStreet());
        return config;
    }

    private TextFormConfig<UpdateCompanyRequest> getHouseNumberConfig() {
        TextFormConfig<UpdateCompanyRequest> config = FormConfigurations.getHouseNumberConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setHouseNumber(value));
        config.setInitValue(company.getHeadquarter().getHouseNumber());
        return config;
    }

    private TextFormConfig<UpdateCompanyRequest> getApartmentNumberConfig() {
        TextFormConfig<UpdateCompanyRequest> config = FormConfigurations.getApartmentNumberConfig();
        config.setFulFiller((company, value) -> company.getHeadquarter().setApartmentNumber(value));
        config.setInitValue(company.getHeadquarter().getApartmentNumber());
        return config;
    }
}

