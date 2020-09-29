package dev.szafraniak.bm_mobileapp.presentation.shared.form;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.utils.Validator;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.models.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.models.price.PriceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.number.NumberEditTextFormRowConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRowConfig;

public final class FormConfigurations {

    public static TextEditTextFormRowConfig getServiceModelNameConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setLabelText("Service Name");
        config.setInvalidMessage("2-60 Signs");
        config.setValidator(Validator::validateProductModelName);
        return config;
    }

    public static TextEditTextFormRowConfig getWarehouseName() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setLabelText("Warehouse Name");
        config.setInvalidMessage("2-40 Signs");
        config.setValidator(Validator::validateProductModelName);
        return config;
    }

    public static TextEditTextFormRowConfig getProductModelNameConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setLabelText("Product Name");
        config.setInvalidMessage("2-60 Signs");
        config.setValidator(Validator::validateProductModelName);
        return config;
    }

    public static TextEditTextFormRowConfig getFirstNameConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setLabelText("First Name");
        config.setInvalidMessage("1-20 Signs");
        config.setValidator(Validator::validateFirstName);
        return config;
    }

    public static TextEditTextFormRowConfig getLastNameConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setLabelText("Last Name");
        config.setInvalidMessage("1-20 Signs");
        config.setValidator(Validator::validateLastName);
        return config;
    }

    public static TextEditTextFormRowConfig getQuantityUnitConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setLabelText("Quantity Unit");
        config.setInvalidMessage("2-6 Signs");
        config.setValidator(Validator::validateQuantityUnit);
        return config;
    }

    public static TextEditTextFormRowConfig getBareCodeConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setRequired(false);
        config.setLabelText("Bare Code");
        config.setInvalidMessage("5-20 Signs");
        config.setValidator(Validator::validateBareCode);
        return config;
    }

    public static TextEditTextFormRowConfig getInvoicePrefixConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setLabelText("Invoice Prefix");
        config.setInvalidMessage("2-14 Signs, Last No Digit");
        config.setValidator(Validator::validateInvoicePrefix);
        return config;
    }

    public static TextEditTextFormRowConfig getInvoiceNumberConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setLabelText("Invoice Number");
        config.setInvalidMessage("3-20 Signs");
        config.setValidator(Validator::validateInvoiceNumber);
        return config;
    }

    public static TextEditTextFormRowConfig getCompanyNameConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setLabelText("Company name");
        config.setInvalidMessage("2-40 Signs");
        config.setValidator(Validator::validateCompanyName);
        return config;
    }

    public static TextEditTextFormRowConfig getTaxIdentityNumberConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setLabelText("Tax Identity Number");
        config.setInvalidMessage("10 Digits");
        config.setValidator(Validator::validateTaxIdentityNumber);
        return config;
    }

    public static TextEditTextFormRowConfig getPhoneConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setRequired(false);
        config.setLabelText("Phone Number");
        config.setInvalidMessage("4-12 Digits, With Optional Plus Sign");
        config.setValidator(Validator::validatePhoneNumber);
        return config;
    }

    public static PriceFormConfig getPriceConfig() {
        Price defaultPrice = new Price();
        defaultPrice.setNet(BigDecimal.ZERO);
        defaultPrice.setTaxRate(BigDecimal.ZERO);
        defaultPrice.setGross(BigDecimal.ZERO);

        PriceFormConfig config = new PriceFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setDefaultValue(defaultPrice);
        config.setInitValue(defaultPrice);
        config.setNetConfig(getNetPriceConfig());
        config.setTaxConfig(getTaxRatePriceConfig());
        config.setGrossConfig(getGrossPriceConfig());
        return config;
    }


    private static NumberEditTextFormRowConfig getTaxRatePriceConfig() {
        NumberEditTextFormRowConfig config = getBaseNumberEditTextConfig();
        config.setLabelText("Tax Rate");
        config.setInvalidMessage("Required positive decimal number");
        return config;
    }

    private static NumberEditTextFormRowConfig getNetPriceConfig() {
        NumberEditTextFormRowConfig config = getBaseNumberEditTextConfig();
        config.setInvalidMessage("Net Price");
        config.setLabelText("Required positive integer number");
        return config;
    }

    private static SimpleDetailsConfig<BigDecimal> getGrossPriceConfig() {
        SimpleDetailsConfig<BigDecimal> config = new SimpleDetailsConfig<>();
        config.setVisibleOnSetValueNull(true);
        config.setLabel("Gross Price");
        return config;
    }

    private static NumberEditTextFormRowConfig getBaseNumberEditTextConfig() {
        NumberEditTextFormRowConfig config = new NumberEditTextFormRowConfig();
        config.setRequired(true);
        config.setZeroOnEmpty(false);
        config.setVisibleOnSetValueNull(true);
        return config;
    }

    public static AddressFormConfig getAddressConfig() {
        SimpleDetailsConfig<String> countryConfig = DetailsConfigurations.getCountryConfig();
        countryConfig.setVisibleOnSetValueNull(true);
        countryConfig.setDefaultValue("Poland");

        AddressFormConfig config = new AddressFormConfig();
        config.setCountryConfig(countryConfig);
        config.setCityConfig(getCityConfig());
        config.setVisibleOnSetValueNull(true);
        config.setCityConfig(getCityConfig());
        config.setPostalConfig(getPostalCodeConfig());
        config.setStreetConfig(getStreetConfig());
        config.setHouseConfig(getHouseNumberConfig());
        config.setApartmentConfig(getApartmentNumberConfig());
        return config;
    }

    public static TextEditTextFormRowConfig getCityConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setLabelText("City");
        config.setInvalidMessage("2-30 Signs");
        config.setValidator(Validator::validateCity);
        return config;
    }

    public static TextEditTextFormRowConfig getPostalCodeConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setLabelText("Postal Code");
        config.setInvalidMessage("Pattern XX-XXX");
        config.setValidator(Validator::validatePostalCode);
        return config;
    }

    public static TextEditTextFormRowConfig getStreetConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setLabelText("Street");
        config.setInvalidMessage("2-30 Signs");
        config.setValidator(Validator::validateStreet);
        return config;
    }

    public static TextEditTextFormRowConfig getHouseNumberConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setLabelText("House Number");
        config.setInvalidMessage("1-3 Digits And Optional Letter");
        config.setValidator(Validator::validateHouseNumber);
        return config;
    }

    public static TextEditTextFormRowConfig getApartmentNumberConfig() {
        TextEditTextFormRowConfig config = getBaseEditConfig();
        config.setRequired(false);
        config.setLabelText("Apartment Number");
        config.setInvalidMessage("1-3 Digits And Optional Letter");
        config.setValidator(Validator::validateApartmentNumber);
        return config;
    }

    private static TextEditTextFormRowConfig getBaseEditConfig() {
        TextEditTextFormRowConfig config = new TextEditTextFormRowConfig();
        config.setInvalidMessage("Invalid Value");
        config.setVisibleOnSetValueNull(true);
        config.setReadEmptyAsNull(true);
        config.setRequired(true);
        return config;
    }


}
