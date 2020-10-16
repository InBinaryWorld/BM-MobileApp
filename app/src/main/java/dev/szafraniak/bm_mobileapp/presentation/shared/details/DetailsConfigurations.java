package dev.szafraniak.bm_mobileapp.presentation.shared.details;

import dev.szafraniak.bm_mobileapp.presentation.shared.details.models.address.AddressDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.models.price.PriceDetailsConfig;

public final class DetailsConfigurations {

    public static <T> SimpleDetailsConfig<T> getWarehouseName() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Warehouse Name");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getProductNameConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Product Name");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getProductGroupNameConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Product Group Name");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getServiceNameConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Service Name");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getFirstNameConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("First Name");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getLastNameConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Last Name");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getInvoicePrefixConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Invoice Prefix");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getQuantityUnitConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Quantity Unit");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getNetPriceConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Net Price");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getTaxRateConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Tax Rate");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getGrossPriceConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Gross Price");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getBareCodeConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Bare Code");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getCompanyNameConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Company Name");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getTaxIdConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Tax Identity Number");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getPhoneConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Phone");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getCountryConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Country");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getCityConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("City");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getPostalCodeConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("First Name");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getStreetConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Street");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getHouseNumberConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("House Number");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getApartmentNumberConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Apartment Number");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getBuyerNameConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Buyer");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getCreationDateConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Creation Date");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getGrossValueConfiguration() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Gross Value");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getDueDateConfiguration() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Due Date");
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getInvoiceNumberConfig() {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel("Invoice number");
        return config;
    }

    private static <T> SimpleDetailsConfig<T> getSimpleConfig() {
        SimpleDetailsConfig<T> config = new SimpleDetailsConfig<>();
        config.setVisibleOnSetValueNull(false);
        return config;
    }

    public static AddressDetailsConfig getAddressConfig() {
        AddressDetailsConfig config = new AddressDetailsConfig();
        config.setDefaultValue(null);
        config.setVisibleOnSetValueNull(false);
        config.setCountryConfig(getCountryConfig());
        config.setCityConfig(getCityConfig());
        config.setPostalCodeConfig(getPostalCodeConfig());
        config.setStreetConfig(getStreetConfig());
        config.setHouseNumberConfig(getHouseNumberConfig());
        config.setApartmentNumberConfig(getApartmentNumberConfig());
        return config;
    }

    public static PriceDetailsConfig getPriceConfig() {
        PriceDetailsConfig config = new PriceDetailsConfig();
        config.setDefaultValue(null);
        config.setVisibleOnSetValueNull(false);
        config.setNetConfig(getNetPriceConfig());
        config.setTaxConfig(getTaxRateConfig());
        config.setGrossConfig(getGrossPriceConfig());
        return config;
    }
}
