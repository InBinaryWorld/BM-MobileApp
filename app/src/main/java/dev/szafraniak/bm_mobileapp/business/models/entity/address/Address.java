package dev.szafraniak.bm_mobileapp.business.models.entity.address;

import lombok.Data;

@Data
public class Address {

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
        return String.format("%s, %s", city, country);
    }

    public String getFullAddress() {
        return String.format("%s %s, %s %s, %s", street, getFullNumber(), postalCode, city, country);
    }

}
