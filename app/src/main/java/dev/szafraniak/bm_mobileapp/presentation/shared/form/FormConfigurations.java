package dev.szafraniak.bm_mobileapp.presentation.shared.form;

import dev.szafraniak.bm_mobileapp.business.utils.Formatters;
import dev.szafraniak.bm_mobileapp.business.utils.Validator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.FormRowDisableMode;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price.PriceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price.PriceFormParser;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price.PriceValidator;

public final class FormConfigurations {

    public static <T> TextFormConfig<T> getServiceModelNameConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setLabelText("Service Name");
        config.setInvalidMessage("2-60 Signs");
        config.setValidator(Validator::validateProductModelName);
        return config;
    }

    public static <T> TextFormConfig<T> getWarehouseName() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setLabelText("Warehouse Name");
        config.setInvalidMessage("2-40 Signs");
        config.setValidator(Validator::validateProductModelName);
        return config;
    }

    public static <T> TextFormConfig<T> getProductModelNameConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setLabelText("Product Name");
        config.setInvalidMessage("2-60 Signs");
        config.setValidator(Validator::validateProductModelName);
        return config;
    }

    public static <T> TextFormConfig<T> getFirstNameConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setLabelText("First Name");
        config.setInvalidMessage("1-20 Signs");
        config.setValidator(Validator::validateFirstName);
        return config;
    }

    public static <T> TextFormConfig<T> getLastNameConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setLabelText("Last Name");
        config.setInvalidMessage("1-20 Signs");
        config.setValidator(Validator::validateLastName);
        return config;
    }

    public static <T> TextFormConfig<T> getQuantityUnitConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setLabelText("Quantity Unit");
        config.setInvalidMessage("2-6 Signs");
        config.setValidator(Validator::validateQuantityUnit);
        return config;
    }

    public static <T> TextFormConfig<T> getBareCodeConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setRequired(false);
        config.setLabelText("Bare Code");
        config.setInvalidMessage("5-20 Signs");
        config.setValidator(Validator::validateBareCode);
        return config;
    }

    public static <T> TextFormConfig<T> getInvoicePrefixConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setLabelText("Invoice Prefix");
        config.setInvalidMessage("2-14 Signs, Last No Digit");
        config.setValidator(Validator::validateInvoicePrefix);
        return config;
    }

    public static <T> TextFormConfig<T> getCompanyNameConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setLabelText("Company name");
        config.setInvalidMessage("2-40 Signs");
        config.setValidator(Validator::validateCompanyName);
        return config;
    }

    public static <T> TextFormConfig<T> getTaxIdentityNumberConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setLabelText("Tax Identity Number");
        config.setInvalidMessage("10 Digits");
        config.setValidator(Validator::validateTaxIdentityNumber);
        return config;
    }

    public static <T> TextFormConfig<T> getPhoneConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setRequired(false);
        config.setLabelText("Phone Number");
        config.setInvalidMessage("4-12 Digits, With Optional Plus Sign");
        config.setValidator(Validator::validatePhoneNumber);
        return config;
    }

    public static <T> TextFormConfig<T> getCountryConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setLabelText("Country");
        config.setInitValue("Poland");
        config.setEnabled(false);
        config.setDisableCustomValue("Poland");
        config.setDisableValueMode(FormRowDisableMode.CUSTOM);
        config.setValidator(Validator::validateCountry);
        return config;
    }

    public static <T> TextFormConfig<T> getCityConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setLabelText("City");
        config.setInvalidMessage("2-30 Signs");
        config.setValidator(Validator::validateCity);
        return config;
    }

    public static <T> TextFormConfig<T> getPostalCodeConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setLabelText("Postal Code");
        config.setInvalidMessage("Pattern XX-XXX");
        config.setValidator(Validator::validatePostalCode);
        return config;
    }

    public static <T> TextFormConfig<T> getStreetConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setLabelText("Street");
        config.setInvalidMessage("2-30 Signs");
        config.setValidator(Validator::validateStreet);
        return config;
    }

    public static <T> TextFormConfig<T> getHouseNumberConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setLabelText("House Number");
        config.setInvalidMessage("1-3 Digits And Optional Letter");
        config.setValidator(Validator::validateHouseNumber);
        return config;
    }

    public static <T> TextFormConfig<T> getApartmentNumberConfig() {
        TextFormConfig<T> config = getBaseEditConfig();
        config.setRequired(false);
        config.setLabelText("Apartment Number");
        config.setInvalidMessage("1-3 Digits And Optional Letter");
        config.setValidator(Validator::validateApartmentNumber);
        return config;
    }

    private static <T> TextFormConfig<T> getBaseEditConfig() {
        TextFormConfig<T> config = new TextFormConfig<>();
        config.setEnabled(true);
        config.setRequired(true);
        config.setInitValue(null);
        config.setInvalidMessage("Invalid Value");
        config.setDisableValueMode(FormRowDisableMode.NULL);
        config.setParser(Formatters::parseNullIfEmpty);
        return config;
    }

    public static <T> PriceFormConfig<T> getPriceConfig() {
        PriceFormConfig<T> config = new PriceFormConfig<>();
        config.setEnabled(true);
        config.setRequired(true);
        config.setNetInitValue("0");
        config.setGrossInitValue("0");
        config.setTaxRateInitValue("0");
        config.setNetLabel("Net Price");
        config.setGrossLabel("Gross Price");
        config.setTaxRateLabel("Tax Rate");
        config.setNetInvalidMessage("Required positive number");
        config.setTaxInvalidMessage("Required positive decimal number");
        config.setValidator(new PriceValidator());
        config.setParser(new PriceFormParser());
        config.setDisableValueMode(FormRowDisableMode.NULL);
        return config;
    }
}
