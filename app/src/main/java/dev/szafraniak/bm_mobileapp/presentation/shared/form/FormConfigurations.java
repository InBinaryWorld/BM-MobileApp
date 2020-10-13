package dev.szafraniak.bm_mobileapp.presentation.shared.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentCash;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentTransfer;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.utils.Validator;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.contact.ClickableContactFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.payment.ClickablePaymentFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.InvoiceItemFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.product.ProductAutoCompleteFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.service.ServiceAutoCompleteFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.type.ItemType;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.type.ItemTypeFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.ContactFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.company.CompanyAutoCompleteFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.individual.IndividualAutoCompleteFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.type.ContactType;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.type.ContactTypeFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.PaymentMethodFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.transfer.PaymentTransferFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.type.PaymentMethodType;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.type.PaymentMethodTypeFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.price.PriceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.datePicker.DatePickerFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;

import static android.text.InputType.TYPE_CLASS_NUMBER;
import static android.text.InputType.TYPE_CLASS_PHONE;
import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL;
import static android.text.InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS;
import static android.text.InputType.TYPE_TEXT_FLAG_CAP_SENTENCES;
import static android.text.InputType.TYPE_TEXT_FLAG_CAP_WORDS;
import static android.text.InputType.TYPE_TEXT_VARIATION_PERSON_NAME;
import static android.text.InputType.TYPE_TEXT_VARIATION_POSTAL_ADDRESS;

public final class FormConfigurations {

    public static TextFormConfig<String> getServiceModelNameConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setLabel("Service Name");
        config.setInvalidMessage("2-60 Signs");
        config.setValidator(Validator::validateProductModelName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_SENTENCES);
        return config;
    }

    public static TextFormConfig<String> getWarehouseName() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setLabel("Warehouse Name");
        config.setInvalidMessage("2-40 Signs");
        config.setValidator(Validator::validateProductModelName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_SENTENCES);
        return config;
    }

    public static TextFormConfig<String> getProductModelNameConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setLabel("Product Name");
        config.setInvalidMessage("2-60 Signs");
        config.setValidator(Validator::validateProductModelName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_SENTENCES);
        return config;
    }

    public static TextFormConfig<String> getFirstNameConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setLabel("First Name");
        config.setInvalidMessage("1-20 Signs");
        config.setValidator(Validator::validateFirstName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_PERSON_NAME);
        return config;
    }

    public static TextFormConfig<String> getLastNameConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setLabel("Last Name");
        config.setInvalidMessage("1-20 Signs");
        config.setValidator(Validator::validateLastName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_PERSON_NAME);
        return config;
    }

    private static TextFormConfig<BigDecimal> getQuantityConfig() {
        TextFormConfig<BigDecimal> config = getBaseTextFormConfig();
        config.setLabel("Quantity");
        config.setInvalidMessage("Max scale: 5");
        config.setValidator(Validator::validateQuantity);
        config.setInputType(TYPE_CLASS_NUMBER | TYPE_NUMBER_FLAG_DECIMAL);
        return config;
    }

    public static TextFormConfig<String> getQuantityUnitConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setLabel("Quantity Unit");
        config.setInvalidMessage("2-6 Signs");
        config.setValidator(Validator::validateQuantityUnit);
        config.setInputType(TYPE_CLASS_TEXT);
        return config;
    }

    public static TextFormConfig<String> getBareCodeConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setRequired(false);
        config.setLabel("Bare Code");
        config.setInvalidMessage("5-20 Signs");
        config.setValidator(Validator::validateBareCode);
        config.setInputType(TYPE_CLASS_NUMBER);
        return config;
    }

    public static TextFormConfig<String> getInvoicePrefixConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setLabel("Invoice Prefix");
        config.setInvalidMessage("2-14 Signs, Last No Digit");
        config.setValidator(Validator::validateInvoicePrefix);
        config.setInputType(TYPE_CLASS_TEXT);
        return config;
    }

    public static TextFormConfig<String> getInvoiceNumberConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setLabel("Invoice Number");
        config.setInvalidMessage("3-20 Signs");
        config.setValidator(Validator::validateInvoiceNumber);
        config.setInputType(TYPE_CLASS_TEXT);
        return config;
    }

    public static TextFormConfig<String> getCompanyNameConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setLabel("Company name");
        config.setInvalidMessage("2-40 Signs");
        config.setValidator(Validator::validateCompanyName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_WORDS);
        return config;
    }

    public static TextFormConfig<String> getTaxIdentityNumberConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setLabel("Tax Identity Number");
        config.setInvalidMessage("10 Digits");
        config.setValidator(Validator::validateTaxIdentityNumber);
        config.setInputType(TYPE_CLASS_NUMBER);
        return config;
    }

    public static TextFormConfig<String> getPhoneConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setRequired(false);
        config.setLabel("Phone Number");
        config.setInvalidMessage("4-12 Digits, With Optional Plus Sign");
        config.setValidator(Validator::validatePhoneNumber);
        config.setInputType(TYPE_CLASS_PHONE);
        return config;
    }

    public static PriceFormConfig getPriceConfig() {
        Price defaultPrice = new Price();
        defaultPrice.setNet(BigDecimal.ZERO);
        defaultPrice.setTaxRate(BigDecimal.ZERO);
        defaultPrice.setGross(BigDecimal.ZERO);

        SimpleDetailsConfig<BigDecimal> grossConfig = DetailsConfigurations.getGrossPriceConfig();
        grossConfig.setVisibleOnSetValueNull(true);

        PriceFormConfig config = new PriceFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setDefaultValue(defaultPrice);
        config.setNetConfig(getNetPriceConfig());
        config.setTaxConfig(getTaxRatePriceConfig());
        config.setGrossConfig(grossConfig);
        return config;
    }


    private static TextFormConfig<BigDecimal> getTaxRatePriceConfig() {
        TextFormConfig<BigDecimal> config = getBaseTextFormConfig();
        config.setLabel("Tax Rate");
        config.setDefaultValue(BigDecimal.ZERO);
        config.setInvalidMessage("Required positive decimal number");
        config.setInputType(TYPE_CLASS_NUMBER);
        return config;
    }

    private static TextFormConfig<BigDecimal> getNetPriceConfig() {
        TextFormConfig<BigDecimal> config = getBaseTextFormConfig();
        config.setLabel("Net Price");
        config.setDefaultValue(BigDecimal.ZERO);
        config.setInvalidMessage("Required positive integer number");
        config.setInputType(TYPE_CLASS_NUMBER | TYPE_NUMBER_FLAG_DECIMAL);
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

    public static TextFormConfig<String> getCityConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setLabel("City");
        config.setInvalidMessage("2-30 Signs");
        config.setValidator(Validator::validateCity);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_POSTAL_ADDRESS);
        return config;
    }

    public static TextFormConfig<String> getPostalCodeConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setLabel("Postal Code");
        config.setInvalidMessage("Pattern XX-XXX");
        config.setValidator(Validator::validatePostalCode);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_POSTAL_ADDRESS);
        return config;
    }

    public static TextFormConfig<String> getStreetConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setLabel("Street");
        config.setInvalidMessage("2-30 Signs");
        config.setValidator(Validator::validateStreet);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_POSTAL_ADDRESS);
        return config;
    }

    public static TextFormConfig<String> getHouseNumberConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setLabel("House Number");
        config.setInvalidMessage("1-3 Digits And Optional Letter");
        config.setValidator(Validator::validateHouseNumber);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_POSTAL_ADDRESS);
        return config;
    }

    public static TextFormConfig<String> getApartmentNumberConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setRequired(false);
        config.setLabel("Apartment Number");
        config.setInvalidMessage("1-3 Digits And Optional Letter");
        config.setValidator(Validator::validateApartmentNumber);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_POSTAL_ADDRESS);
        return config;
    }

    private static TextFormConfig<String> getBankAccountNumberConfig() {
        TextFormConfig<String> config = getBaseTextFormConfig();
        config.setLabel("Account number");
        config.setInvalidMessage("Invalid Format");
        config.setValidator(Validator::validateBankAccountNumber);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_CHARACTERS);
        return config;
    }

    private static <T> TextFormConfig<T> getBaseTextFormConfig() {
        TextFormConfig<T> config = new TextFormConfig<>();
        config.setInvalidMessage("Invalid Value");
        config.setVisibleOnSetValueNull(true);
        config.setReadEmptyAsNull(true);
        config.setRequired(true);
        return config;
    }

    public static ClickableContactFormConfig getClickableContactConfig() {
        ClickableContactFormConfig config = new ClickableContactFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setRequired(true);
        config.setLabel("Contact");
        config.setEmptyText("Contact have not been provided");
        return config;
    }

    public static ClickablePaymentFormConfig getClickablePaymentConfig() {
        Map<Class<? extends PaymentMethod>, String> displayNames = new HashMap<>();
        displayNames.put(PaymentCash.class, "Cash");
        displayNames.put(PaymentTransfer.class, "Transfer");

        ClickablePaymentFormConfig config = new ClickablePaymentFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setRequired(true);
        config.setLabel("Payment");
        config.setDueDateLabel("Due date:");
        config.setPaymentTypeLabel("Payment method:");
        config.setEmptyText("Payment details have not been provided");
        config.setPaymentMethodDisplayNames(displayNames);
        return config;
    }

    private static PaymentMethodTypeFormConfig getPaymentTypeFormConfig() {
        HashMap<PaymentMethodType, String> displayValues = new HashMap<>();
        displayValues.put(PaymentMethodType.CASH, "Cash");
        displayValues.put(PaymentMethodType.TRANSFER, "Transfer");

        PaymentMethodTypeFormConfig config = new PaymentMethodTypeFormConfig();
        config.setSpinnerItems(new ArrayList<>(displayValues.keySet()));
        config.setDisplayValues(displayValues);
        config.setVisibleOnSetValueNull(true);
        config.setLabel("Payment Type");
        config.setRequired(true);
        config.setValidator(Validator::notNull);
        return config;
    }

    private static PaymentTransferFormConfig getPaymentTransferFormConfig(List<BankAccount> bankAccounts) {
        PaymentTransferFormConfig config = new PaymentTransferFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(getAccountNameAutoCompleteConfig(bankAccounts));
        config.setNumberConfig(getBankAccountNumberConfig());
        return config;
    }

    public static PaymentMethodFormConfig getPaymentMethodConfig(List<BankAccount> bankAccounts) {
        PaymentMethodFormConfig config = new PaymentMethodFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setDefaultValue(new PaymentCash());
        config.setPaymentTypeFormConfig(getPaymentTypeFormConfig());
        config.setPaymentTransferFormConfig(getPaymentTransferFormConfig(bankAccounts));
        return config;
    }

    private static AutoCompleteTextFormConfig<String, BankAccount> getAccountNameAutoCompleteConfig(
        List<BankAccount> bankAccounts
    ) {
        AutoCompleteTextFormConfig<String, BankAccount> config = getAutoCompleteTextFormConfig();
        config.setValidator(Validator::validateBankAccountName);
        config.setInputType(TYPE_CLASS_TEXT);
        config.setLabel("Account name");
        config.setInvalidMessage("2-30 Signs");
        config.setListItems(bankAccounts);
        return config;
    }

    private static <T, S> AutoCompleteTextFormConfig<T, S> getAutoCompleteTextFormConfig() {
        AutoCompleteTextFormConfig<T, S> config = new AutoCompleteTextFormConfig<>();
        config.setInvalidMessage("Invalid Value");
        config.setVisibleOnSetValueNull(true);
        config.setReadEmptyAsNull(true);
        config.setRequired(true);
        return config;
    }

    public static ContactFormConfig getContactFormConfig(List<IndividualContact> individuals, List<CompanyContact> companies) {
        ContactFormConfig config = new ContactFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setContactTypeForm(getContactTypeConfig());
        config.setCompanyConfig(getCompanyAutoCompleteFormConfig(companies));
        config.setIndividualConfig(getIndividualAutocompleteFormConfig(individuals));
        return config;
    }

    private static IndividualAutoCompleteFormConfig getIndividualAutocompleteFormConfig(List<IndividualContact> individuals) {
        IndividualAutoCompleteFormConfig config = new IndividualAutoCompleteFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setFirstNameConfig(getFirstNameAutoCompleteConfig(individuals));
        config.setLastNameConfig(getLastNameConfig());
        config.setAddressConfig(getAddressConfig());
        return config;
    }

    private static AutoCompleteTextFormConfig<String, IndividualContact> getFirstNameAutoCompleteConfig(List<IndividualContact> individuals) {
        AutoCompleteTextFormConfig<String, IndividualContact> config = getAutoCompleteTextFormConfig();
        config.setLabel("First Name");
        config.setInvalidMessage("1-20 Signs");
        config.setValidator(Validator::validateFirstName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_PERSON_NAME);
        config.setListItems(individuals);
        return config;
    }

    private static CompanyAutoCompleteFormConfig getCompanyAutoCompleteFormConfig(List<CompanyContact> companies) {
        CompanyAutoCompleteFormConfig config = new CompanyAutoCompleteFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setTaxIdConfig(getTaxIdentityNumberConfig());
        config.setAddressConfig(getAddressConfig());
        config.setCompanyNameConfig(getCompanyNameAutoCompleteConfig(companies));
        return config;
    }

    private static AutoCompleteTextFormConfig<String, CompanyContact> getCompanyNameAutoCompleteConfig(List<CompanyContact> companies) {
        AutoCompleteTextFormConfig<String, CompanyContact> config = getAutoCompleteTextFormConfig();
        config.setLabel("Company name");
        config.setInvalidMessage("2-40 Signs");
        config.setValidator(Validator::validateCompanyName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_WORDS);
        config.setListItems(companies);
        return config;
    }

    private static ContactTypeFormConfig getContactTypeConfig() {
        HashMap<ContactType, String> map = new HashMap<>();
        map.put(ContactType.INDIVIDUAL, "Individual Contact");
        map.put(ContactType.COMPANY, "Company Contact");

        ContactTypeFormConfig config = new ContactTypeFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setRequired(true);
        config.setLabel("Select contact type");
        config.setDefaultValue(ContactType.COMPANY);
        config.setSpinnerItems(new ArrayList<>(map.keySet()));
        config.setDisplayValues(map);
        return config;
    }

    public static DatePickerFormConfig getDueDateConfig() {
        DatePickerFormConfig config = new DatePickerFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setValidator(Validator::validateDueDate);
        config.setPickerValidator(Validator.getFromValidatorInclusive(LocalDate.now()));
        config.setRequired(true);
        config.setLabel("Due date");
        config.setEmptyText("The date has not been specified");
        config.setInvalidText("Invalid value");
        return config;

    }

    public static InvoiceItemFormConfig getInvoiceItemConfig(List<ProductModel> products, List<ServiceModel> services) {
        InvoiceItemFormConfig config = new InvoiceItemFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setItemTypeForm(getItemTypeConfig());
        config.setProductConfig(getProductAutoCompleteConfig(products));
        config.setServiceConfig(getServiceAutoCmplConfig(services));
        return config;
    }

    private static ServiceAutoCompleteFormConfig getServiceAutoCmplConfig(List<ServiceModel> services) {
        ServiceAutoCompleteFormConfig config = new ServiceAutoCompleteFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setQuantityUnitConfig(getQuantityUnitConfig());
        config.setQuantityConfig(getQuantityConfig());
        config.setPriceFormConfig(getPriceConfig());
        config.setServiceNameConfig(getServiceNameAutoCmplConfig(services));
        return config;
    }

    private static AutoCompleteTextFormConfig<String, ServiceModel> getServiceNameAutoCmplConfig(List<ServiceModel> services) {
        AutoCompleteTextFormConfig<String, ServiceModel> config = getAutoCompleteTextFormConfig();
        config.setLabel("Service name");
        config.setInvalidMessage("2-60 Signs");
        config.setValidator(Validator::validateServiceModelName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_SENTENCES);
        config.setListItems(services);
        return config;
    }

    private static ProductAutoCompleteFormConfig getProductAutoCompleteConfig(List<ProductModel> products) {
        ProductAutoCompleteFormConfig config = new ProductAutoCompleteFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setQuantityUnitConfig(getQuantityUnitConfig());
        config.setQuantityConfig(getQuantityConfig());
        config.setPriceFormConfig(getPriceConfig());
        config.setProductNameConfig(getProductNameAutoCmplConfig(products));
        return config;
    }

    private static AutoCompleteTextFormConfig<String, ProductModel> getProductNameAutoCmplConfig(List<ProductModel> products) {
        AutoCompleteTextFormConfig<String, ProductModel> config = getAutoCompleteTextFormConfig();
        config.setLabel("Product name");
        config.setInvalidMessage("2-60 Signs");
        config.setValidator(Validator::validateProductModelName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_SENTENCES);
        config.setListItems(products);
        return config;
    }


    private static ItemTypeFormConfig getItemTypeConfig() {
        HashMap<ItemType, String> map = new HashMap<>();
        map.put(ItemType.PRODUCT, "Product");
        map.put(ItemType.SERVICE, "Service");

        ItemTypeFormConfig config = new ItemTypeFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setRequired(true);
        config.setDefaultValue(ItemType.PRODUCT);
        config.setSpinnerItems(Arrays.asList(ItemType.values()));
        config.setLabel("Type");
        config.setDisplayValues(map);
        return config;
    }
}
