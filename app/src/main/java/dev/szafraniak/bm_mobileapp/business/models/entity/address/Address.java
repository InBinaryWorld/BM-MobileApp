package dev.szafraniak.bm_mobileapp.business.models.entity.address;

import dev.szafraniak.bm_mobileapp.presentation.shared.search.FilterValue;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Address extends FilterValue {

    private Long id;

    private String country;

    private String postalCode;

    private String city;

    private String street;

    private String houseNumber;

    private String apartmentNumber;


    public String getFullNumber() {
        String apartmentPart = apartmentNumber != null ? String.format("/%s", apartmentNumber) : "";
        return String.format("%s%s", houseNumber, apartmentPart);
    }

    public String getShortAddress() {
        return String.format("%s %s, %s", postalCode, city, country);
    }

    public String getFullAddress() {
        return String.format("%s %s, %s %s, %s", street == null ? city : street, getFullNumber(), postalCode, city, country);
    }

    @Override
    protected String createDescriptionForFilter() {
        return this.getFullAddress();
    }
}
