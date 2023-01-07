package dev.szafraniak.bm_mobileapp.presentation.shared.components.details;

import android.content.Context;

import java.util.HashMap;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details.CompanyContactDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details.IndividualContactDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details.InvoiceDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details.state.InvoiceStatusFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.details.ProductModelDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.details.ServiceModelDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details.WarehouseDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.address.AddressDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.price.PriceDetailsConfig;

public final class DetailsConfigurations {

    public static <T> SimpleDetailsConfig<T> getWarehouseName(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_warehouse_name));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getProductNameConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_product_name));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getProductGroupNameConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_product_group_name));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getServiceNameConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_service_name));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getFirstNameConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_first_name));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getLastNameConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_last_name));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getQuantityUnitConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_quantity_unit));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getNetPriceConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_net_price));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getTaxRateConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_tax_rate));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getGrossPriceConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_gross_price));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getGrossAmountConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_gross_amount));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getBarcodeConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_barcode));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getCompanyNameConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_company_name));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getTaxIdConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_tax_id_number));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getPhoneConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_phone));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getCountryConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_country));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getCityConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_city));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getPostalCodeConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_postal_code));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getStreetConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_street));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getHouseNumberConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_house_number));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getApartmentNumberConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_apartment_number));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getBuyerNameConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_buyer));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getDateOfPaymentConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_date_of_payment));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getCreationDateConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_creation_date));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getSellDateConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_sell_date));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getDueDateConfiguration(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_due_date));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getIssueDateConfiguration(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_issue_date));
        return config;
    }

    public static <T> SimpleDetailsConfig<T> getInvoiceNumberConfig(Context context) {
        SimpleDetailsConfig<T> config = getSimpleConfig();
        config.setLabel(context.getString(R.string.details_invoice_number));
        return config;
    }

    private static <T> SimpleDetailsConfig<T> getSimpleConfig() {
        SimpleDetailsConfig<T> config = new SimpleDetailsConfig<>();
        config.setVisibleOnSetValueNull(false);
        return config;
    }

    private static InvoiceStatusFormConfig getInvoiceStatusFormConfig(Context context) {
        HashMap<Boolean, String> map = new HashMap<>();
        map.put(true, context.getString(R.string.details_paid));
        map.put(false, context.getString(R.string.details_unpaid));

        InvoiceStatusFormConfig config = new InvoiceStatusFormConfig();
        config.setVisibleOnSetValueNull(false);
        config.setLabel(context.getString(R.string.details_payment_state));
        config.setDisplayValues(map);
        config.setDefaultValue(false);
        return config;
    }

    public static AddressDetailsConfig getAddressConfig(Context context) {
        AddressDetailsConfig config = new AddressDetailsConfig();
        config.setDefaultValue(null);
        config.setVisibleOnSetValueNull(false);
        config.setCountryConfig(getCountryConfig(context));
        config.setCityConfig(getCityConfig(context));
        config.setPostalCodeConfig(getPostalCodeConfig(context));
        config.setStreetConfig(getStreetConfig(context));
        config.setHouseNumberConfig(getHouseNumberConfig(context));
        config.setApartmentNumberConfig(getApartmentNumberConfig(context));
        return config;
    }

    public static PriceDetailsConfig getPriceConfig(Context context) {
        PriceDetailsConfig config = new PriceDetailsConfig();
        config.setDefaultValue(null);
        config.setVisibleOnSetValueNull(false);
        config.setNetConfig(getNetPriceConfig(context));
        config.setTaxConfig(getTaxRateConfig(context));
        config.setGrossConfig(getGrossPriceConfig(context));
        return config;
    }

    public static WarehouseDetailsConfig getWarehouseDetailsConfig(Context context) {
        WarehouseDetailsConfig config = new WarehouseDetailsConfig();
        config.setDefaultValue(null);
        config.setVisibleOnSetValueNull(true);
        config.setWarehouseNameConfig(DetailsConfigurations.getWarehouseName(context));
        config.setAddressDetailsConfig(DetailsConfigurations.getAddressConfig(context));
        return config;
    }

    public static ProductModelDetailsConfig getProductModelDetailsConfig(Context context) {
        ProductModelDetailsConfig config = new ProductModelDetailsConfig();
        config.setDefaultValue(null);
        config.setVisibleOnSetValueNull(false);
        config.setProductModelNameConfig(DetailsConfigurations.getProductNameConfig(context));
        config.setBarcodeConfig(DetailsConfigurations.getBarcodeConfig(context));
        config.setQuantityUnitConfig(DetailsConfigurations.getQuantityUnitConfig(context));
        config.setProductGroupNameConfig(DetailsConfigurations.getProductGroupNameConfig(context));
        config.setPriceDetailsConfig(DetailsConfigurations.getPriceConfig(context));
        return config;
    }

    public static ServiceModelDetailsConfig getServiceModelDetailsConfig(Context context) {
        ServiceModelDetailsConfig config = new ServiceModelDetailsConfig();
        config.setDefaultValue(null);
        config.setVisibleOnSetValueNull(true);
        config.setServiceModelNameConfig(DetailsConfigurations.getServiceNameConfig(context));
        config.setQuantityUnitConfig(DetailsConfigurations.getQuantityUnitConfig(context));
        config.setPriceDetailsConfig(DetailsConfigurations.getPriceConfig(context));
        return config;
    }

    public static IndividualContactDetailsConfig getIndividualContactDetailsConfig(Context context) {
        IndividualContactDetailsConfig config = new IndividualContactDetailsConfig();
        config.setDefaultValue(null);
        config.setVisibleOnSetValueNull(true);
        config.setFirstNameConfig(DetailsConfigurations.getFirstNameConfig(context));
        config.setLastNameConfig(DetailsConfigurations.getLastNameConfig(context));
        config.setPhoneConfig(DetailsConfigurations.getPhoneConfig(context));
        config.setAddressConfig(DetailsConfigurations.getAddressConfig(context));
        return config;
    }

    public static InvoiceDetailsConfig getInvoiceDetailsConfig(Context context) {
        InvoiceDetailsConfig config = new InvoiceDetailsConfig();
        config.setVisibleOnSetValueNull(true);
        config.setBuyerNameConfig(DetailsConfigurations.getBuyerNameConfig(context));
        config.setCreationDateConfig(DetailsConfigurations.getCreationDateConfig(context));
        config.setDateOfPaymentConfig(DetailsConfigurations.getDateOfPaymentConfig(context));
        config.setDueDateConfig(DetailsConfigurations.getDueDateConfiguration(context));
        config.setSellDateConfig(DetailsConfigurations.getSellDateConfig(context));
        config.setIssueDateConfig(DetailsConfigurations.getIssueDateConfiguration(context));
        config.setInvoiceNumberConfig(DetailsConfigurations.getInvoiceNumberConfig(context));
        config.setGrossConfig(DetailsConfigurations.getGrossAmountConfig(context));
        config.setStatusConfig(getInvoiceStatusFormConfig(context));
        return config;
    }

    public static CompanyContactDetailsConfig getCompanyContactDetailsConfig(Context context) {
        CompanyContactDetailsConfig config = new CompanyContactDetailsConfig();
        config.setDefaultValue(null);
        config.setVisibleOnSetValueNull(true);
        config.setCompanyNameConfig(DetailsConfigurations.getCompanyNameConfig(context));
        config.setTaxIdConfig(DetailsConfigurations.getTaxIdConfig(context));
        config.setPhoneConfig(DetailsConfigurations.getPhoneConfig(context));
        config.setAddressConfig(DetailsConfigurations.getAddressConfig(context));
        return config;
    }


}
