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
}
