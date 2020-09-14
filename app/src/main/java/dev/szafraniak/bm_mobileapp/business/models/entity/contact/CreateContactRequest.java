package dev.szafraniak.bm_mobileapp.business.models.entity.contact;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import lombok.Data;

@Data
public abstract class CreateContactRequest {

    private Address address;

    private String phone;

}
