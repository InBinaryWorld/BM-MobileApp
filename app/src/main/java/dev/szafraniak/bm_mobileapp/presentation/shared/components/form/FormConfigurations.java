package dev.szafraniak.bm_mobileapp.presentation.shared.components.form;

import android.app.Activity;
import android.content.Context;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentCash;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentTransfer;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.utils.Validator;
import dev.szafraniak.bm_mobileapp.presentation.company.create.form.CreateCompanyFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.bank.create.BankAccountCreateFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.bank.modify.BankAccountModifyFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.company.modify.ModifyCompanyFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create.CompanyContactCreateFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify.CompanyContactModifyFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.create.ContactCreateFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create.IndividualContactCreateFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify.IndividualContactModifyFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.create.FinancesEventCreateFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.modify.FinancesEventModifyFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form.CreateInvoiceBaseDataFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form.contact.ClickableContactFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form.payment.ClickablePaymentFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact.form.ContactFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact.form.ContactType;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact.form.company.CompanyAutoCompleteFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact.form.individual.IndividualAutoCompleteFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.InvoiceItemFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.ItemType;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.product.ProductAutoCompleteFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.service.ServiceAutoCompleteFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form.InvoiceItemsConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form.summary.InvoiceItemsSummaryConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.form.CreateInvoicePaymentFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.form.payment.PaymentMethodFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.form.payment.PaymentMethodType;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.form.payment.transfer.PaymentTransferFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.product.create.CreateProductFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.product.create.model.ProductModelSpinnerFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.product.modify.ModifyProductFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.create.CreateProductModelFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.modify.ModifyProductModelFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.create.CreateServiceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.modify.ModifyServiceModelFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.create.CreateWarehouseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify.UpdateWarehouseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.barcode.BarcodeFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.datePicker.DatePickerFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.dateTimePicker.DateTimePickerFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.list.ListFormRowConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.price.PriceFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.spinner.type.BaseTypeFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.timePicker.TimePickerFormConfig;

import static android.text.InputType.TYPE_CLASS_NUMBER;
import static android.text.InputType.TYPE_CLASS_PHONE;
import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL;
import static android.text.InputType.TYPE_NUMBER_FLAG_SIGNED;
import static android.text.InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS;
import static android.text.InputType.TYPE_TEXT_FLAG_CAP_SENTENCES;
import static android.text.InputType.TYPE_TEXT_FLAG_CAP_WORDS;
import static android.text.InputType.TYPE_TEXT_FLAG_MULTI_LINE;
import static android.text.InputType.TYPE_TEXT_VARIATION_PERSON_NAME;
import static android.text.InputType.TYPE_TEXT_VARIATION_POSTAL_ADDRESS;

public final class FormConfigurations {

    public static TextFormConfig<String> getServiceModelNameConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_service_name));
        config.setInvalidMessage(context.getString(R.string.forms_2_60));
        config.setValidator(Validator::validateProductModelName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_SENTENCES);
        return config;
    }

    public static TextFormConfig<String> getProductModelNameConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_product_name));
        config.setInvalidMessage(context.getString(R.string.forms_2_60));
        config.setValidator(Validator::validateProductModelName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_SENTENCES);
        return config;
    }

    public static TextFormConfig<String> getWarehouseName(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_warehouse_name));
        config.setInvalidMessage(context.getString(R.string.forms_2_40));
        config.setValidator(Validator::validateWarehouseName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_SENTENCES);
        return config;
    }

    public static TextFormConfig<String> getFirstNameConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_first_name));
        config.setInvalidMessage(context.getString(R.string.forms_1_20));
        config.setValidator(Validator::validateFirstName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_PERSON_NAME);
        return config;
    }

    public static TextFormConfig<String> getLastNameConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_last_name));
        config.setInvalidMessage(context.getString(R.string.forms_1_20));
        config.setValidator(Validator::validateLastName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_PERSON_NAME);
        return config;
    }

    public static TextFormConfig<BigDecimal> getQuantityConfig(Context context) {
        TextFormConfig<BigDecimal> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_quantity));
        config.setInvalidMessage(context.getString(R.string.forms_scale_5));
        config.setValidator(Validator::validateQuantity);
        config.setInputType(TYPE_CLASS_NUMBER | TYPE_NUMBER_FLAG_DECIMAL);
        return config;
    }

    public static TextFormConfig<String> getQuantityUnitConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_quantity_unity));
        config.setInvalidMessage(context.getString(R.string.forms_1_6));
        config.setValidator(Validator::validateQuantityUnit);
        config.setInputType(TYPE_CLASS_TEXT);
        return config;
    }

    public static BarcodeFormConfig getBarcodeConfig(Activity activity) {
        BarcodeFormConfig config = new BarcodeFormConfig();
        config.setValidator(Validator::validateBarcode);
        config.setLabel(activity.getString(R.string.forms_barcode));
        config.setInvalidMessage(activity.getString(R.string.form_2_20));
        config.setInputType(TYPE_CLASS_NUMBER);
        config.setVisibleOnSetValueNull(true);
        config.setReadEmptyAsNull(true);
        config.setActivity(activity);
        config.setRequired(false);
        config.setLines(1);
        return config;
    }

    public static TextFormConfig<String> getInvoicePrefixConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setInvalidMessage(context.getString(R.string.forms_2_14_last_no_digit));
        config.setLabel(context.getString(R.string.forms_invoice_prefix));
        config.setValidator(Validator::validateInvoicePrefix);
        config.setInputType(TYPE_CLASS_TEXT);
        return config;
    }

    public static TextFormConfig<String> getInvoiceNumberConfig(Context context, String invoicePrefix) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_invoice_number));
        config.setInvalidMessage(context.getString(R.string.forms_3_20));
        config.setValidator(Validator::validateInvoiceNumber);
        config.setInputType(TYPE_CLASS_TEXT);
        config.setDefaultValue(invoicePrefix);
        return config;
    }

    public static TextFormConfig<String> getCompanyNameConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_company_name));
        config.setInvalidMessage(context.getString(R.string.forms_2_40));
        config.setValidator(Validator::validateCompanyName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_WORDS);
        return config;
    }

    public static TextFormConfig<String> getTaxIdentityNumberConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_tax_id_number));
        config.setInvalidMessage(context.getString(R.string.forms_10_digits));
        config.setValidator(Validator::validateTaxIdentityNumber);
        config.setInputType(TYPE_CLASS_NUMBER);
        return config;
    }

    public static TextFormConfig<String> getPhoneConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setRequired(false);
        config.setLabel(context.getString(R.string.forms_phone_number));
        config.setInvalidMessage(context.getString(R.string.forms_4_12_digits_optional_plus));
        config.setValidator(Validator::validatePhoneNumber);
        config.setInputType(TYPE_CLASS_PHONE);
        return config;
    }

    public static PriceFormConfig getPriceConfig(Context context) {
        Price defaultPrice = new Price();
        defaultPrice.setNet(BigDecimal.ZERO);
        defaultPrice.setTaxRate(BigDecimal.ZERO);
        defaultPrice.setGross(BigDecimal.ZERO);

        SimpleDetailsConfig<BigDecimal> grossConfig = DetailsConfigurations.getGrossPriceConfig(context);
        grossConfig.setVisibleOnSetValueNull(true);

        PriceFormConfig config = new PriceFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setDefaultValue(defaultPrice);
        config.setNetConfig(getNetPriceConfig(context));
        config.setTaxConfig(getTaxRatePriceConfig(context));
        config.setGrossConfig(grossConfig);
        return config;
    }


    private static TextFormConfig<BigDecimal> getTaxRatePriceConfig(Context context) {
        TextFormConfig<BigDecimal> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_tax_rate));
        config.setInvalidMessage(context.getString(R.string.forms_positive_integer));
        config.setDefaultValue(BigDecimal.ZERO);
        config.setValidator(Validator::validateTaxRate);
        config.setInputType(TYPE_CLASS_NUMBER);
        return config;
    }

    private static TextFormConfig<BigDecimal> getNetPriceConfig(Context context) {
        TextFormConfig<BigDecimal> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_net_price));
        config.setInvalidMessage(context.getString(R.string.forms_positive_decimal));
        config.setDefaultValue(BigDecimal.ZERO);
        config.setValidator(Validator::validateNetPrice);
        config.setInputType(TYPE_CLASS_NUMBER | TYPE_NUMBER_FLAG_DECIMAL);
        return config;
    }

    public static AddressFormConfig getAddressConfig(Context context) {
        AddressFormConfig config = new AddressFormConfig();
        config.setCountryConfig(getCountryConfig(context));
        config.setVisibleOnSetValueNull(true);
        config.setCityConfig(getCityConfig(context));
        config.setPostalConfig(getPostalCodeConfig(context));
        config.setStreetConfig(getStreetConfig(context));
        config.setHouseConfig(getHouseNumberConfig(context));
        config.setApartmentConfig(getApartmentNumberConfig(context));
        return config;
    }

    public static TextFormConfig<String> getCountryConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_country));
        config.setInvalidMessage(context.getString(R.string.forms_2_30));
        config.setDefaultValue(context.getString(R.string.forms_poland));
        config.setValidator(Validator::validateCountry);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_POSTAL_ADDRESS | TYPE_TEXT_FLAG_CAP_WORDS);
        return config;
    }

    public static TextFormConfig<String> getCityConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_city));
        config.setInvalidMessage(context.getString(R.string.forms_2_30));
        config.setValidator(Validator::validateCity);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_POSTAL_ADDRESS);
        return config;
    }

    public static TextFormConfig<String> getPostalCodeConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_postal_code));
        config.setInvalidMessage(context.getString(R.string.forms_4_10_signs));
        config.setValidator(Validator::validatePostalCode);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_POSTAL_ADDRESS);
        return config;
    }

    public static TextFormConfig<String> getStreetConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_street));
        config.setInvalidMessage(context.getString(R.string.forms_2_30));
        config.setValidator(Validator::validateStreet);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_POSTAL_ADDRESS);
        return config;
    }

    public static TextFormConfig<String> getHouseNumberConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_house_number));
        config.setInvalidMessage(context.getString(R.string.forms_1_3_opt_letter));
        config.setValidator(Validator::validateHouseNumber);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_POSTAL_ADDRESS);
        return config;
    }

    public static TextFormConfig<String> getApartmentNumberConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setRequired(false);
        config.setLabel(context.getString(R.string.forms_apartment_number));
        config.setInvalidMessage(context.getString(R.string.forms_1_3_opt_letter));
        config.setValidator(Validator::validateApartmentNumber);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_POSTAL_ADDRESS);
        return config;
    }

    public static TextFormConfig<String> getBankAccountNumberConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_account_number));
        config.setInvalidMessage(context.getString(R.string.forms_invalid_bank_account));
        config.setValidator(Validator::validateBankAccountNumber);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_CHARACTERS);
        return config;
    }

    private static TextFormConfig<String> getFinancialEventDescriptionConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setLines(4);
        config.setRequired(false);
        config.setLabel(context.getString(R.string.forms_description));
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_SENTENCES | TYPE_TEXT_FLAG_MULTI_LINE);
        config.setInvalidMessage(context.getString(R.string.forms_2_240));
        config.setValidator(Validator::validateFinancialEventDescription);
        return config;
    }

    private static <T> TextFormConfig<T> getBaseTextFormConfig(Context context) {
        TextFormConfig<T> config = new TextFormConfig<>();
        config.setInvalidMessage(context.getString(R.string.forms_invalid_value));
        config.setVisibleOnSetValueNull(true);
        config.setReadEmptyAsNull(true);
        config.setRequired(true);
        config.setLines(1);
        return config;
    }

    public static ClickableContactFormConfig getClickableContactConfig(Context context) {
        ClickableContactFormConfig config = new ClickableContactFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setRequired(true);
        config.setLabel(context.getString(R.string.forms_contact));
        config.setEmptyText(context.getString(R.string.forms_provide_contact));
        return config;
    }

    public static ClickableContactFormConfig getReceiverClickableContactConfig(Context context) {
        ClickableContactFormConfig config = getClickableContactConfig(context);
        config.setLabel(context.getString(R.string.form_create_invoice_receiver));
        config.setRequired(false);
        return config;
    }

    public static ClickableContactFormConfig getBuyerClickableContactConfig(Context context) {
        ClickableContactFormConfig config = getClickableContactConfig(context);
        config.setLabel(context.getString(R.string.form_create_invoice_buyer));
        return config;
    }

    public static ClickablePaymentFormConfig getClickablePaymentConfig(Context context) {
        Map<Class<? extends PaymentMethod>, String> displayNames = new HashMap<>();
        displayNames.put(PaymentCash.class, context.getString(R.string.forms_cash));
        displayNames.put(PaymentTransfer.class, context.getString(R.string.forms_transfer));

        ClickablePaymentFormConfig config = new ClickablePaymentFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setRequired(true);
        config.setLabel(context.getString(R.string.forms_payment));
        config.setDueDateLabel(context.getString(R.string.forms_payment_due_date));
        config.setPaymentTypeLabel(context.getString(R.string.forms_payment_payment_method));
        config.setEmptyText(context.getString(R.string.forms_provide_payment_data));
        config.setPaymentMethodDisplayNames(displayNames);
        return config;
    }

    private static BaseTypeFormConfig<PaymentMethodType> getPaymentTypeFormConfig(Context context) {
        HashMap<PaymentMethodType, String> displayValues = new HashMap<>();
        displayValues.put(PaymentMethodType.CASH, context.getString(R.string.forms_cash));
        displayValues.put(PaymentMethodType.TRANSFER, context.getString(R.string.forms_transfer));

        BaseTypeFormConfig<PaymentMethodType> config = new BaseTypeFormConfig<>();
        config.setSpinnerItems(new ArrayList<>(displayValues.keySet()));
        config.setLabel(context.getString(R.string.forms_payment_method));
        config.setDisplayValues(displayValues);
        config.setVisibleOnSetValueNull(true);
        config.setRequired(true);
        config.setValidator(Validator::notNull);
        return config;
    }

    private static PaymentTransferFormConfig getPaymentTransferFormConfig(Context context, List<BankAccount> bankAccounts) {
        PaymentTransferFormConfig config = new PaymentTransferFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(getAccountNameAutoCompleteConfig(context, bankAccounts));
        config.setNumberConfig(getBankAccountNumberConfig(context));
        return config;
    }

    public static PaymentMethodFormConfig getPaymentMethodConfig(
        Context context,
        List<BankAccount> bankAccounts
    ) {
        PaymentMethodFormConfig config = new PaymentMethodFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setDefaultValue(new PaymentCash());
        config.setPaymentTypeFormConfig(getPaymentTypeFormConfig(context));
        config.setPaymentTransferFormConfig(getPaymentTransferFormConfig(context, bankAccounts));
        return config;
    }

    private static AutoCompleteTextFormConfig<String, BankAccount> getAccountNameAutoCompleteConfig(
        Context context,
        List<BankAccount> bankAccounts
    ) {
        AutoCompleteTextFormConfig<String, BankAccount> config = getAutoCompleteTextFormConfig(context);
        config.setValidator(Validator::validateBankAccountName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_WORDS);
        config.setLabel(context.getString(R.string.forms_account_name));
        config.setInvalidMessage(context.getString(R.string.forms_2_30));
        config.setListItems(bankAccounts);
        return config;
    }

    public static TextFormConfig<String> getBankAccountNameConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setValidator(Validator::validateBankAccountName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_WORDS);
        config.setLabel(context.getString(R.string.forms_name));
        config.setInvalidMessage(context.getString(R.string.forms_2_30));
        return config;
    }

    private static <T, S> AutoCompleteTextFormConfig<T, S> getAutoCompleteTextFormConfig(Context context) {
        AutoCompleteTextFormConfig<T, S> config = new AutoCompleteTextFormConfig<>();
        config.setInvalidMessage(context.getString(R.string.forms_invalid_value));
        config.setVisibleOnSetValueNull(true);
        config.setReadEmptyAsNull(true);
        config.setRequired(true);
        config.setLines(1);
        return config;
    }

    public static ContactFormConfig getContactFormConfig(Context context, List<IndividualContact> individuals, List<CompanyContact> companies) {
        ContactFormConfig config = new ContactFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setContactTypeForm(getContactTypeConfig(context));
        config.setCompanyConfig(getCompanyAutoCompleteFormConfig(context, companies));
        config.setIndividualConfig(getIndividualAutocompleteFormConfig(context, individuals));
        return config;
    }

    private static IndividualAutoCompleteFormConfig getIndividualAutocompleteFormConfig(
        Context context,
        List<IndividualContact> individuals
    ) {
        IndividualAutoCompleteFormConfig config = new IndividualAutoCompleteFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setFirstNameConfig(getFirstNameAutoCompleteConfig(context, individuals));
        config.setLastNameConfig(getLastNameConfig(context));
        config.setAddressConfig(getAddressConfig(context));
        return config;
    }

    private static AutoCompleteTextFormConfig<String, IndividualContact> getFirstNameAutoCompleteConfig(
        Context context,
        List<IndividualContact> individuals
    ) {
        AutoCompleteTextFormConfig<String, IndividualContact> config = getAutoCompleteTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_first_name));
        config.setInvalidMessage(context.getString(R.string.forms_1_20));
        config.setValidator(Validator::validateFirstName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_VARIATION_PERSON_NAME);
        config.setListItems(individuals);
        return config;
    }

    private static CompanyAutoCompleteFormConfig getCompanyAutoCompleteFormConfig(
        Context context,
        List<CompanyContact> companies
    ) {
        CompanyAutoCompleteFormConfig config = new CompanyAutoCompleteFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setTaxIdConfig(getTaxIdentityNumberConfig(context));
        config.setAddressConfig(getAddressConfig(context));
        config.setCompanyNameConfig(getCompanyNameAutoCompleteConfig(context, companies));
        return config;
    }

    private static AutoCompleteTextFormConfig<String, CompanyContact> getCompanyNameAutoCompleteConfig(
        Context context,
        List<CompanyContact> companies
    ) {
        AutoCompleteTextFormConfig<String, CompanyContact> config = getAutoCompleteTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_company_name));
        config.setInvalidMessage(context.getString(R.string.forms_2_40));
        config.setValidator(Validator::validateCompanyName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_WORDS);
        config.setListItems(companies);
        return config;
    }

    public static BaseTypeFormConfig<ContactType> getContactTypeConfig(Context context) {
        HashMap<ContactType, String> map = new HashMap<>();
        map.put(ContactType.INDIVIDUAL, context.getString(R.string.forms_individual_contact));
        map.put(ContactType.COMPANY, context.getString(R.string.forms_company_contact));

        BaseTypeFormConfig<ContactType> config = new BaseTypeFormConfig<>();
        config.setLabel(context.getString(R.string.forms_select_contact_type));
        config.setVisibleOnSetValueNull(true);
        config.setRequired(true);
        config.setDefaultValue(ContactType.COMPANY);
        config.setSpinnerItems(new ArrayList<>(map.keySet()));
        config.setDisplayValues(map);
        return config;
    }

    public static DatePickerFormConfig getDueDateConfig(Context context) {
        DatePickerFormConfig config = new DatePickerFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setValidator(Validator::validateDueDate);
        config.setPickerValidator(Validator.getFromValidatorInclusive(LocalDate.now()));
        config.setRequired(true);
        config.setLabel(context.getString(R.string.forms_due_date));
        config.setEmptyText(context.getString(R.string.forms_no_date_provided));
        config.setInvalidText(context.getString(R.string.forms_invalid_value));
        return config;
    }

    public static InvoiceItemFormConfig getInvoiceItemConfig(
        Context context,
        List<ProductModel> products,
        List<ServiceModel> services,
        Activity activity
    ) {
        InvoiceItemFormConfig config = new InvoiceItemFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setItemTypeForm(getItemTypeConfig(context));
        config.setProductConfig(getProductAutoCompleteConfig(context, products, activity));
        config.setServiceConfig(getServiceAutoCmplConfig(context, services));
        return config;
    }

    private static ServiceAutoCompleteFormConfig getServiceAutoCmplConfig(
        Context context,
        List<ServiceModel> services
    ) {
        ServiceAutoCompleteFormConfig config = new ServiceAutoCompleteFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setQuantityUnitConfig(getQuantityUnitConfig(context));
        config.setQuantityConfig(getQuantityConfig(context));
        config.setPriceFormConfig(getPriceConfig(context));
        config.setServiceNameConfig(getServiceNameAutoCmplConfig(context, services));
        return config;
    }

    private static AutoCompleteTextFormConfig<String, ServiceModel> getServiceNameAutoCmplConfig(
        Context context,
        List<ServiceModel> services
    ) {
        AutoCompleteTextFormConfig<String, ServiceModel> config = getAutoCompleteTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_service_name));
        config.setInvalidMessage(context.getString(R.string.forms_2_60));
        config.setValidator(Validator::validateServiceModelName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_SENTENCES);
        config.setListItems(services);
        return config;
    }

    private static ProductAutoCompleteFormConfig getProductAutoCompleteConfig(
        Context context,
        List<ProductModel> products,
        Activity activity
    ) {
        ProductAutoCompleteFormConfig config = new ProductAutoCompleteFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setQuantityUnitConfig(getQuantityUnitConfig(context));
        config.setQuantityConfig(getQuantityConfig(context));
        config.setPriceFormConfig(getPriceConfig(context));
        config.setProductNameConfig(getProductNameAutoCmplConfig(context, products));
        config.setAvailableProducts(products);
        config.setActivity(activity);
        return config;
    }

    private static AutoCompleteTextFormConfig<String, ProductModel> getProductNameAutoCmplConfig(
        Context context,
        List<ProductModel> products
    ) {
        AutoCompleteTextFormConfig<String, ProductModel> config = getAutoCompleteTextFormConfig(context);
        config.setLabel(context.getString(R.string.forms_product_name));
        config.setInvalidMessage(context.getString(R.string.forms_2_60));
        config.setValidator(Validator::validateProductModelName);
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_SENTENCES);
        config.setListItems(products);
        return config;
    }


    private static BaseTypeFormConfig<ItemType> getItemTypeConfig(Context context) {
        HashMap<ItemType, String> map = new HashMap<>();
        map.put(ItemType.PRODUCT, context.getString(R.string.forms_product));
        map.put(ItemType.SERVICE, context.getString(R.string.forms_service));

        BaseTypeFormConfig<ItemType> config = new BaseTypeFormConfig<>();
        config.setLabel(context.getString(R.string.forms_type));
        config.setSpinnerItems(Arrays.asList(ItemType.values()));
        config.setDefaultValue(ItemType.PRODUCT);
        config.setVisibleOnSetValueNull(true);
        config.setDisplayValues(map);
        config.setRequired(true);
        return config;
    }

    public static InvoiceItemsConfig getInvoiceItemsConfig(Context context) {
        InvoiceItemsConfig config = new InvoiceItemsConfig();
        config.setVisibleOnSetValueNull(true);
        config.setSummaryConfig(getItemsSummaryConfig(context));
        config.setItemsConfig(getItemsFormConfig(context));
        return config;
    }

    private static ListFormRowConfig<InvoiceItemFormModel> getItemsFormConfig(Context context) {
        ListFormRowConfig<InvoiceItemFormModel> config = new ListFormRowConfig<>();
        config.setVisibleOnSetValueNull(true);
        config.setDefaultValue(new ArrayList<>());
        config.setRequired(true);
        config.setValidator(list -> list.size() > 0);
        return config;
    }

    private static InvoiceItemsSummaryConfig getItemsSummaryConfig(Context context) {
        InvoiceItemsSummaryConfig config = new InvoiceItemsSummaryConfig();
        config.setVisibleOnSetValueNull(true);
        config.setDefaultValue(new ArrayList<>());
        return config;
    }

    public static FinancesEventModifyFormConfig getFinancesEventModifyConfig(Context context) {
        FinancesEventModifyFormConfig config = new FinancesEventModifyFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setTitleConfig(getFinancesEventTitleConfig(context));
        config.setAmountConfig(getFinancialEventAmountConfig(context));
        config.setDateTimePickerConfig(getDateTimePickerConfig(context));
        config.setDescriptionConfig(getFinancialEventDescriptionConfig(context));
        return config;
    }

    public static FinancesEventCreateFormConfig getFinancesEventCreateConfig(Context context) {
        FinancesEventCreateFormConfig config = new FinancesEventCreateFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setTitleConfig(getFinancesEventTitleConfig(context));
        config.setAmountConfig(getFinancialEventAmountConfig(context));
        config.setDateTimePickerConfig(getDateTimePickerConfig(context));
        config.setDescriptionConfig(getFinancialEventDescriptionConfig(context));
        return config;
    }


    private static DateTimePickerFormConfig getDateTimePickerConfig(Context context) {
        DateTimePickerFormConfig config = new DateTimePickerFormConfig();
        config.setRequired(true);
        config.setInvalidMessage(context.getString(R.string.forms_cannot_set_future_date));
        config.setValidator(Validator::validateFinancesEventDateTime);
        config.setVisibleOnSetValueNull(true);
        config.setDefaultValue(LocalDateTime.now());
        config.setDateConfig(getFinancesDateConfig(context));
        config.setTimeConfig(getFinancesTimeConfig(context));
        return config;
    }

    private static TimePickerFormConfig getFinancesTimeConfig(Context context) {
        TimePickerFormConfig config = new TimePickerFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setRequired(true);
        config.setDefaultValue(LocalTime.now());
        config.setLabel(context.getString(R.string.forms_time));
        config.setEmptyText(context.getString(R.string.forms_no_provided_date));
        config.setInvalidText(context.getString(R.string.forms_invalid_value));
        return config;
    }

    private static DatePickerFormConfig getFinancesDateConfig(Context context) {
        DatePickerFormConfig config = new DatePickerFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setValidator(Validator::validateFinancesDate);
        config.setPickerValidator(Validator.getBeforeValidatorInclusive(LocalDate.now()));
        config.setRequired(true);
        config.setLabel(context.getString(R.string.forms_date));
        config.setEmptyText(context.getString(R.string.forms_no_provided_date));
        config.setInvalidText(context.getString(R.string.forms_invalid_value));
        return config;
    }

    private static TextFormConfig<BigDecimal> getFinancialEventAmountConfig(Context context) {
        TextFormConfig<BigDecimal> config = getBaseTextFormConfig(context);
        config.setValidator(Validator::validateFinancialEventAmount);
        config.setInvalidMessage(context.getString(R.string.forms_scale_2));
        config.setInputType(TYPE_CLASS_NUMBER | TYPE_NUMBER_FLAG_DECIMAL | TYPE_NUMBER_FLAG_SIGNED);
        config.setLabel(context.getString(R.string.forms_amount_of_change));
        return config;
    }

    private static TextFormConfig<String> getFinancesEventTitleConfig(Context context) {
        TextFormConfig<String> config = getBaseTextFormConfig(context);
        config.setValidator(Validator::validateFinancialEventTitle);
        config.setInvalidMessage(context.getString(R.string.forms_2_40));
        config.setInputType(TYPE_CLASS_TEXT | TYPE_TEXT_FLAG_CAP_SENTENCES);
        config.setLabel(context.getString(R.string.forms_title));
        return config;
    }

    public static ProductModelSpinnerFormConfig getProductModelConfig(Context context, List<ProductModel> models) {
        ProductModelSpinnerFormConfig config = new ProductModelSpinnerFormConfig();
        config.setLabel(context.getString(R.string.forms_product_model));
        config.setValidator(Validator::notNull);
        config.setVisibleOnSetValueNull(true);
        config.setSpinnerItems(models);
        config.setRequired(true);
        return config;
    }

    public static CompanyContactCreateFormConfig getCompanyContactCreateConfig(Context context) {
        CompanyContactCreateFormConfig config = new CompanyContactCreateFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getCompanyNameConfig(context));
        config.setTaxIdConfig(FormConfigurations.getTaxIdentityNumberConfig(context));
        config.setPhoneConfig(FormConfigurations.getPhoneConfig(context));
        config.setAddressConfig(FormConfigurations.getAddressConfig(context));
        return config;
    }

    public static IndividualContactCreateFormConfig getIndividualContactCreateConfig(Context context) {
        IndividualContactCreateFormConfig config = new IndividualContactCreateFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setFirstNameConfig(FormConfigurations.getFirstNameConfig(context));
        config.setLastNameConfig(FormConfigurations.getLastNameConfig(context));
        config.setPhoneConfig(FormConfigurations.getPhoneConfig(context));
        config.setAddressConfig(FormConfigurations.getAddressConfig(context));
        return config;
    }

    public static CreateServiceFormConfig getCreateServiceFormConfig(Context context) {
        CreateServiceFormConfig config = new CreateServiceFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getServiceModelNameConfig(context));
        config.setQuantityUniteConfig(FormConfigurations.getQuantityUnitConfig(context));
        config.setPriceFormConfig(FormConfigurations.getPriceConfig(context));
        return config;
    }

    public static ModifyServiceModelFormConfig getModifyServiceModelFormConfig(Context context) {
        ModifyServiceModelFormConfig config = new ModifyServiceModelFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getServiceModelNameConfig(context));
        config.setQuantityUniteConfig(FormConfigurations.getQuantityUnitConfig(context));
        config.setPriceFormConfig(FormConfigurations.getPriceConfig(context));
        return config;
    }

    public static CreateProductModelFormConfig getCreateProductModelFormConfig(Activity activity) {
        CreateProductModelFormConfig config = new CreateProductModelFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getProductModelNameConfig(activity));
        config.setBarcodeConfig(FormConfigurations.getBarcodeConfig(activity));
        config.setQuantityUniteConfig(FormConfigurations.getQuantityUnitConfig(activity));
        config.setPriceFormConfig(FormConfigurations.getPriceConfig(activity));
        return config;
    }

    public static ModifyProductModelFormConfig getModifyProductModelFormConfig(Activity activity) {
        ModifyProductModelFormConfig config = new ModifyProductModelFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getProductModelNameConfig(activity));
        config.setBarcodeConfig(FormConfigurations.getBarcodeConfig(activity));
        config.setQuantityUniteConfig(FormConfigurations.getQuantityUnitConfig(activity));
        config.setPriceFormConfig(FormConfigurations.getPriceConfig(activity));
        return config;
    }

    public static CreateWarehouseFormConfig getCreateWarehouseFormConfig(Context context) {
        CreateWarehouseFormConfig config = new CreateWarehouseFormConfig();
        config.setNameConfig(FormConfigurations.getWarehouseName(context));
        config.setAddressConfig(FormConfigurations.getAddressConfig(context));
        return config;
    }

    public static UpdateWarehouseFormConfig getUpdateWarehouseFormConfig(Context context) {
        UpdateWarehouseFormConfig config = new UpdateWarehouseFormConfig();
        config.setNameConfig(FormConfigurations.getWarehouseName(context));
        config.setAddressConfig(FormConfigurations.getAddressConfig(context));
        return config;
    }

    public static IndividualContactModifyFormConfig getIndividualContactModifyFormConfig(Context context) {
        IndividualContactModifyFormConfig config = new IndividualContactModifyFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setFirstNameConfig(FormConfigurations.getFirstNameConfig(context));
        config.setLastNameConfig(FormConfigurations.getLastNameConfig(context));
        config.setPhoneConfig(FormConfigurations.getPhoneConfig(context));
        config.setAddressConfig(FormConfigurations.getAddressConfig(context));
        return config;
    }

    public static CreateProductFormConfig getCreateProductFormConfig(
        Context context,
        List<ProductModel> models
    ) {
        CreateProductFormConfig config = new CreateProductFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setProductModelConfig(FormConfigurations.getProductModelConfig(context, models));
        config.setQuantityConfig(FormConfigurations.getQuantityConfig(context));
        return config;
    }

    public static ModifyProductFormConfig getModifyProductFormConfig(
        Context context,
        Product product
    ) {
        ModifyProductFormConfig config = new ModifyProductFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(DetailsConfigurations.getProductNameConfig(context));
        config.setBarCodeConfig(DetailsConfigurations.getBarcodeConfig(context));
        config.setQuantityFormConfig(FormConfigurations.getQuantityConfig(context));
        config.setProduct(product);
        return config;
    }

    public static CreateCompanyFormConfig getCreateCompanyFormConfig(Context context) {
        CreateCompanyFormConfig config = new CreateCompanyFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getCompanyNameConfig(context));
        config.setInvoicePrefixConfig(FormConfigurations.getInvoicePrefixConfig(context));
        config.setTaxIdentityConfig(FormConfigurations.getTaxIdentityNumberConfig(context));
        config.setAddressConfig(FormConfigurations.getAddressConfig(context));
        return config;
    }

    public static ModifyCompanyFormConfig getModifyCompanyFormConfig(Context context) {
        ModifyCompanyFormConfig config = new ModifyCompanyFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getCompanyNameConfig(context));
        config.setInvoicePrefixConfig(FormConfigurations.getInvoicePrefixConfig(context));
        config.setTaxIdentityConfig(FormConfigurations.getTaxIdentityNumberConfig(context));
        config.setAddressConfig(FormConfigurations.getAddressConfig(context));
        return config;
    }

    public static CreateInvoiceBaseDataFormConfig getCreateInvoiceBaseDataFormConfig(
        Context context,
        String invoicePrefix
    ) {
        CreateInvoiceBaseDataFormConfig config = new CreateInvoiceBaseDataFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setInvoiceNumberConfig(getInvoiceNumberConfig(context, invoicePrefix));
        config.setBuyerConfig(getBuyerClickableContactConfig(context));
        config.setReceiverConfig(getReceiverClickableContactConfig(context));
        config.setPaymentConfig(getClickablePaymentConfig(context));
        return config;
    }

    public static CompanyContactModifyFormConfig getCompanyContactModifyFormConfig(Context context) {
        CompanyContactModifyFormConfig config = new CompanyContactModifyFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getCompanyNameConfig(context));
        config.setPhoneConfig(FormConfigurations.getPhoneConfig(context));
        config.setTaxIdConfig(FormConfigurations.getTaxIdentityNumberConfig(context));
        config.setAddressConfig(FormConfigurations.getAddressConfig(context));
        return config;
    }

    public static BankAccountCreateFormConfig getBankAccountCreateFormConfig(Context context) {
        BankAccountCreateFormConfig config = new BankAccountCreateFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getBankAccountNameConfig(context));
        config.setNumberConfig(FormConfigurations.getBankAccountNumberConfig(context));
        return config;
    }

    public static BankAccountModifyFormConfig getBankAccountModifyFormConfig(Context context) {
        BankAccountModifyFormConfig config = new BankAccountModifyFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getBankAccountNameConfig(context));
        config.setNumberConfig(FormConfigurations.getBankAccountNumberConfig(context));
        return config;
    }

    public static ContactCreateFormConfig getContactCreateFormConfig(Context context) {
        ContactCreateFormConfig config = new ContactCreateFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setCompanyConfig(FormConfigurations.getCompanyContactCreateConfig(context));
        config.setIndividualConfig(FormConfigurations.getIndividualContactCreateConfig(context));
        config.setContactTypeForm(FormConfigurations.getContactTypeConfig(context));
        return config;
    }

    public static CreateInvoicePaymentFormConfig getCreateInvoicePaymentFormConfig(
        Context context,
        List<BankAccount> accounts
    ) {
        CreateInvoicePaymentFormConfig config = new CreateInvoicePaymentFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setPaymentConfig(getPaymentMethodConfig(context, accounts));
        config.setDueDateFormConfig(getDueDateConfig(context));
        return config;
    }


}
