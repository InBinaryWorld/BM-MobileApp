package dev.szafraniak.bm_mobileapp.business.utils;

import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.google.android.material.datepicker.DateValidatorPointForward;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

public final class Validator {

    private final static String UPPERCASE_LETTER = "[A-ZŻŹĆĄŚĘŁÓŃ]";
    private final static String LOWERCASE_LETTER = "[a-zżźćńółęąś]";
    private final static String LETTER = "[" + UPPERCASE_LETTER + LOWERCASE_LETTER + "]";
    private final static String ALLOWED_SIGNS = "[^\\t\\n\\r\\f\\x0B]";

    public final static String WORD_1_20 = LETTER + "{1,20}";
    public final static String WORDS = LETTER + "+( " + LETTER + "+)*";
    public final static String BASE_1_6 = ALLOWED_SIGNS + "{1,6}";
    public final static String BASE_4_10 = ALLOWED_SIGNS + "{4,10}";
    public final static String BASE_1_20 = ALLOWED_SIGNS + "{1,20}";
    public final static String BASE_2_30 = ALLOWED_SIGNS + "{2,30}";
    public final static String BASE_2_40 = ALLOWED_SIGNS + "{2,40}";
    public final static String BASE_2_240 = ALLOWED_SIGNS + "{2,240}";

    public static final String BANK_ACCOUNT = "^(?:(?:IT|SM)\\d{2}[A-Z]\\d{22}|CY\\d{2}[A-Z]\\d{23}|NL\\d{2}[A-Z]{4}\\d{10}|LV\\d{2}[A-Z]{4}\\d{13}|(?:BG|BH|GB|IE)\\d{2}[A-Z]{4}\\d{14}|GI\\d{2}[A-Z]{4}\\d{15}|RO\\d{2}[A-Z]{4}\\d{16}|KW\\d{2}[A-Z]{4}\\d{22}|MT\\d{2}[A-Z]{4}\\d{23}|NO\\d{13}|(?:DK|FI|GL|FO)\\d{16}|MK\\d{17}|(?:AT|EE|KZ|LU|XK)\\d{18}|(?:BA|HR|LI|CH|CR)\\d{19}|(?:GE|DE|LT|ME|RS)\\d{20}|IL\\d{21}|(?:AD|CZ|ES|MD|SA)\\d{22}|PT\\d{23}|(?:BE|IS)\\d{24}|(?:FR|MR|MC)\\d{25}|(?:AL|DO|LB|PL)\\d{26}|(?:AZ|HU)\\d{27}|(?:GR|MU)\\d{28})$";
    public static final String PHONE_4_12 = "\\+?\\d{4,12}";
    public static final String BARCODE_5_20 = "\\S{5,20}";
    public final static String INVOICE_PREFIX_2_14 = ALLOWED_SIGNS + "{1,13}[^ \\d\\t\\n\\r\\f\\x0B]";
    public final static String HOUSE_NUMBER = "\\d{1,3}[a-z]?(-\\d{1,3}[A-Za-z]?)?";
    public final static String TAX_IDENTITY_NUMBER = "\\d{10}";

    public static boolean validateLastName(String value) {
        return Pattern.matches(WORD_1_20, value) && !value.isEmpty();
    }

    public static boolean validateFirstName(String value) {
        return Pattern.matches(WORD_1_20, value) && !value.isEmpty();
    }

    public static boolean validateProductModelName(String value) {
        return Pattern.matches(BASE_2_40, value) && !value.isEmpty();
    }

    public static boolean validateWarehouseName(String value) {
        return Pattern.matches(BASE_2_40, value) && !value.isEmpty();
    }

    public static boolean validateServiceModelName(String value) {
        return Pattern.matches(BASE_2_40, value) && !value.isEmpty();
    }

    public static boolean validateCompanyName(String value) {
        return Pattern.matches(BASE_2_40, value) && !value.isEmpty();
    }

    public static boolean validateQuantityUnit(String value) {
        return Pattern.matches(BASE_1_6, value) && !value.isEmpty();
    }

    public static boolean validateBarcode(String value) {
        return Pattern.matches(BARCODE_5_20, value);
    }

    public static boolean validateInvoicePrefix(String value) {
        return Pattern.matches(INVOICE_PREFIX_2_14, value);
    }

    public static boolean validateInvoiceNumber(String value) {
        return Pattern.matches(BASE_1_20, value) && !value.isEmpty();
    }

    public static boolean validateTaxIdentityNumber(String value) {
        return Pattern.matches(TAX_IDENTITY_NUMBER, value);
    }

    public static boolean validateCountry(String value) {
        return Pattern.matches(WORDS, value) && length(value, 2, 30);
    }

    public static boolean validateCity(String value) {
        return Pattern.matches(WORDS, value) && length(value, 2, 30);
    }

    public static boolean validatePostalCode(String value) {
        return Pattern.matches(BASE_4_10, value);
    }

    public static boolean validateStreet(String value) {
        return Pattern.matches(BASE_2_30, value) && length(value, 2, 30);
    }

    public static boolean validateApartmentNumber(String value) {
        return Pattern.matches(HOUSE_NUMBER, value);
    }

    public static boolean validateHouseNumber(String value) {
        return Pattern.matches(HOUSE_NUMBER, value);
    }

    public static boolean validatePhoneNumber(String value) {
        return Pattern.matches(PHONE_4_12, value);
    }

    public static boolean validateNetPrice(BigDecimal number) {
        return number.signum() >= 0 && number.scale() <= 2;
    }

    public static boolean validateQuantity(BigDecimal number) {
        return number.signum() >= 0 && number.scale() <= 5;
    }

    public static boolean validateTaxRate(BigDecimal number) {
        return number.signum() >= 0 && number.scale() == 0;
    }

    public static boolean validateFinancialEventAmount(BigDecimal bigDecimal) {
        return bigDecimal.scale() <= 2;
    }

    public static boolean validateBankAccountName(String value) {
        return Pattern.matches(BASE_2_40, value) && !value.isEmpty();
    }

    public static boolean validateFinancialEventTitle(String value) {
        return Pattern.matches(BASE_2_40, value) && !value.isEmpty();
    }

    public static boolean validateBankAccountNumber(String bankAccount) {
        return Pattern.matches(BANK_ACCOUNT, bankAccount) && !bankAccount.isEmpty();
    }

    public static boolean validateFinancialEventDescription(String value) {
        return Pattern.matches(BASE_2_240, value);
    }

    private static boolean length(String value, int min, int max) {
        int len = value.length();
        return len >= min && len <= max;
    }

    public static boolean validateDueDate(LocalDate dueDate) {
        return dueDate.compareTo(LocalDate.now()) >= 0;
    }

    public static boolean validateFinancesDate(LocalDate dueDate) {
        return dueDate.compareTo(LocalDate.now()) <= 0;
    }

    public static <T> boolean notNull(T value) {
        return value != null;
    }


    public static boolean validateFinancesEventDateTime(LocalDateTime value) {
        return LocalDateTime.now().compareTo(value) >= 0;
    }

    public static DateValidatorPointForward getFromValidatorInclusive(LocalDate localDate) {
        long mills = Parser.parseToMillsAtStartOfDay(localDate);
        return DateValidatorPointForward.from(mills);
    }

    public static DateValidatorPointBackward getBeforeValidatorInclusive(LocalDate localDate) {
        long mills = Parser.parseToMillsAtStartOfDay(localDate);
        return DateValidatorPointBackward.before(mills);
    }
}
