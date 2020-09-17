package dev.szafraniak.bm_mobileapp.presentation.shared.details;

import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.SimpleTextViewDetailsRowConfig;

public final class DetailsConfigurations {

    public static <T> SimpleTextViewDetailsRowConfig<T> getWarehouseName() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Warehouse Name");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getProductNameConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Product Name");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getServiceNameConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Service Name");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getFirstNameConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("First Name");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getLastNameConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Last Name");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getInvoicePrefixConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Invoice Prefix");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getQuantityUnitConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Quantity Unit");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getNetPriceConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Net Price");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getTaxRateConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Tax Rate");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getGrossPriceConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Gross Price");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getBareCodeConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Bare Code");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getCompanyNameConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Company Name");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getTaxIdentityNumberConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Tax Identity Number");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getPhoneConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Phone");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getCountryConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Country");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getCityConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("City");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getPostalCodeConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("First Name");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getStreetConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Street");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getHouseNumberConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("House Number");
        return config;
    }

    public static <T> SimpleTextViewDetailsRowConfig<T> getApartmentNumberConfig() {
        SimpleTextViewDetailsRowConfig<T> config = getSimpleTextViewConfig();
        config.setLabel("Apartment Number");
        return config;
    }

    private static <T> SimpleTextViewDetailsRowConfig<T> getSimpleTextViewConfig() {
        SimpleTextViewDetailsRowConfig<T> config = new SimpleTextViewDetailsRowConfig<>();
        config.setDefaultValue("");
        config.setVisibleOnNull(false);
        return config;
    }
}
