package dev.szafraniak.bm_mobileapp.presentation.company.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.business.utils.FormInputFormatter;
import dev.szafraniak.bm_mobileapp.business.utils.Validator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.SimpleBaseConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowDisableMode;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRowConfig;

public class CompanyCreateFormConfig extends SimpleBaseConfig<CreateCompanyRequest> {

    public CompanyCreateFormConfig(LayoutInflater inflater, ViewGroup viewGroup) {
        super(inflater, viewGroup);
    }

    @Override
    protected String getSubmitButtonText() {
        return "CREATE COMPANY";
    }

    @Override
    public List<FormRowInterface<CreateCompanyRequest>> createRowsConfiguration() {
        List<FormRowInterface<CreateCompanyRequest>> configs = new ArrayList<>();
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCompanyNameConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getInvoicePrefixConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getTaxIdentityNumberConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCountryConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getCityConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getPostalCodeConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getStreetConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getHouseNumberConfig()));
        configs.add(new EditTextFormRow<>(this.inflater, this.viewGroup, getApartmentNumberConfig()));
        return configs;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getCompanyNameConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = getBaseCompanyEditConfig();
        config.setLabelText("Company name");
        config.setInvalidMessage("2-40 Signs");
        config.setValidator(Validator::validateCompanyName);
        config.setFulFiller(CreateCompanyRequest::setName);
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getInvoicePrefixConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = getBaseCompanyEditConfig();
        config.setLabelText("Invoice Prefix");
        config.setInvalidMessage("2-14 Signs, Last No Digit");
        config.setValidator(Validator::validateInvoicePrefix);
        config.setFulFiller(CreateCompanyRequest::setInvoicePrefix);
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getTaxIdentityNumberConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = getBaseCompanyEditConfig();
        config.setLabelText("Tax Identity Number");
        config.setInvalidMessage("10 Digits");
        config.setValidator(Validator::validateTaxIdentityNumber);
        config.setFulFiller(CreateCompanyRequest::setTaxIdentityNumber);
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getCountryConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = getBaseCompanyEditConfig();
        config.setLabelText("Country");
        config.setInitValue("Poland");
        config.setEnabled(false);
        config.setDisableCustomValue("Poland");
        config.setDisableValueMode(FormRowDisableMode.CUSTOM);
        config.setValidator(Validator::validateCountry);
        config.setFulFiller((company, value) -> company.getHeadquarter().setCountry(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getCityConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = getBaseCompanyEditConfig();
        config.setLabelText("City");
        config.setInvalidMessage("2-30 Signs");
        config.setValidator(Validator::validateCity);
        config.setFulFiller((company, value) -> company.getHeadquarter().setCity(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getPostalCodeConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = getBaseCompanyEditConfig();
        config.setLabelText("Postal Code");
        config.setInvalidMessage("Pattern XX-XXX");
        config.setValidator(Validator::validatePostalCode);
        config.setFulFiller((company, value) -> company.getHeadquarter().setPostalCode(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getStreetConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = getBaseCompanyEditConfig();
        config.setLabelText("Street");
        config.setInvalidMessage("2-30 Signs");
        config.setValidator(Validator::validateStreet);
        config.setFulFiller((company, value) -> company.getHeadquarter().setStreet(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getHouseNumberConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = getBaseCompanyEditConfig();
        config.setLabelText("House Number");
        config.setInvalidMessage("1-3 Digits And Optional Letter");
        config.setValidator(Validator::validateHouseNumber);
        config.setFulFiller((company, value) -> company.getHeadquarter().setHouseNumber(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getApartmentNumberConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = getBaseCompanyEditConfig();
        config.setRequired(false);
        config.setLabelText("Apartment Number");
        config.setInvalidMessage("1-3 Digits And Optional Letter");
        config.setValidator(Validator::validateApartmentNumber);
        config.setFulFiller((company, value) -> company.getHeadquarter().setApartmentNumber(value));
        return config;
    }

    private EditTextFormRowConfig<CreateCompanyRequest> getBaseCompanyEditConfig() {
        EditTextFormRowConfig<CreateCompanyRequest> config = new EditTextFormRowConfig<>();
        config.setEnabled(true);
        config.setRequired(true);
        config.setInitValue(null);
        config.setInvalidMessage("Invalid Value");
        config.setDisableValueMode(FormRowDisableMode.NULL);
        config.setFormatter(FormInputFormatter::formatNull);
        return config;
    }
}

