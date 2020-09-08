package dev.szafraniak.bm_mobileapp.presentation.shared.form;

import dev.szafraniak.bm_mobileapp.business.utils.FormInputFormatter;
import dev.szafraniak.bm_mobileapp.business.utils.Validator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowDisableMode;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext.EditTextFormRowConfig;

public final class FormConfigurations {

    public static <T> EditTextFormRowConfig<T> getFirstNameConfig() {
        EditTextFormRowConfig<T> config = getBaseEditConfig();
        config.setLabelText("First Name");
        config.setInvalidMessage("1-20 Signs");
        config.setValidator(Validator::validateFirstName);
        return config;
    }

    public static <T> EditTextFormRowConfig<T> getLastNameConfig() {
        EditTextFormRowConfig<T> config = getBaseEditConfig();
        config.setLabelText("Last Name");
        config.setInvalidMessage("1-20 Signs");
        config.setValidator(Validator::validateLastName);
        return config;
    }

    public static <T> EditTextFormRowConfig<T> getInvoicePrefixConfig() {
        EditTextFormRowConfig<T> config = getBaseEditConfig();
        config.setLabelText("Invoice Prefix");
        config.setInvalidMessage("2-14 Signs, Last No Digit");
        config.setValidator(Validator::validateInvoicePrefix);
        return config;
    }

    public static <T> EditTextFormRowConfig<T> getCompanyNameConfig() {
        EditTextFormRowConfig<T> config = getBaseEditConfig();
        config.setLabelText("Company name");
        config.setInvalidMessage("2-40 Signs");
        config.setValidator(Validator::validateCompanyName);
        return config;
    }

    public static <T> EditTextFormRowConfig<T> getTaxIdentityNumberConfig() {
        EditTextFormRowConfig<T> config = getBaseEditConfig();
        config.setLabelText("Tax Identity Number");
        config.setInvalidMessage("10 Digits");
        config.setValidator(Validator::validateTaxIdentityNumber);
        return config;
    }

    public static <T> EditTextFormRowConfig<T> getPhoneConfig() {
        EditTextFormRowConfig<T> config = getBaseEditConfig();
        config.setRequired(false);
        config.setLabelText("Phone Number");
        config.setInvalidMessage("4-12 Digits, With Optional Plus Sign");
        config.setValidator(Validator::validatePhoneNumber);
        return config;
    }

    public static <T> EditTextFormRowConfig<T> getCountryConfig() {
        EditTextFormRowConfig<T> config = getBaseEditConfig();
        config.setLabelText("Country");
        config.setInitValue("Poland");
        config.setEnabled(false);
        config.setDisableCustomValue("Poland");
        config.setDisableValueMode(FormRowDisableMode.CUSTOM);
        config.setValidator(Validator::validateCountry);
        return config;
    }

    public static <T> EditTextFormRowConfig<T> getCityConfig() {
        EditTextFormRowConfig<T> config = getBaseEditConfig();
        config.setLabelText("City");
        config.setInvalidMessage("2-30 Signs");
        config.setValidator(Validator::validateCity);
        return config;
    }

    public static <T> EditTextFormRowConfig<T> getPostalCodeConfig() {
        EditTextFormRowConfig<T> config = getBaseEditConfig();
        config.setLabelText("Postal Code");
        config.setInvalidMessage("Pattern XX-XXX");
        config.setValidator(Validator::validatePostalCode);
        return config;
    }

    public static <T> EditTextFormRowConfig<T> getStreetConfig() {
        EditTextFormRowConfig<T> config = getBaseEditConfig();
        config.setLabelText("Street");
        config.setInvalidMessage("2-30 Signs");
        config.setValidator(Validator::validateStreet);
        return config;
    }

    public static <T> EditTextFormRowConfig<T> getHouseNumberConfig() {
        EditTextFormRowConfig<T> config = getBaseEditConfig();
        config.setLabelText("House Number");
        config.setInvalidMessage("1-3 Digits And Optional Letter");
        config.setValidator(Validator::validateHouseNumber);
        return config;
    }

    public static <T> EditTextFormRowConfig<T> getApartmentNumberConfig() {
        EditTextFormRowConfig<T> config = getBaseEditConfig();
        config.setRequired(false);
        config.setLabelText("Apartment Number");
        config.setInvalidMessage("1-3 Digits And Optional Letter");
        config.setValidator(Validator::validateApartmentNumber);
        return config;
    }

    private static <T> EditTextFormRowConfig<T> getBaseEditConfig() {
        EditTextFormRowConfig<T> config = new EditTextFormRowConfig<>();
        config.setEnabled(true);
        config.setRequired(true);
        config.setInitValue(null);
        config.setInvalidMessage("Invalid Value");
        config.setDisableValueMode(FormRowDisableMode.NULL);
        config.setFormatter(FormInputFormatter::formatNull);
        return config;
    }
}
