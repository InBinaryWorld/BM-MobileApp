package dev.szafraniak.bm_mobileapp.business.models.entity.contact;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.CreateAddressRequest;
import lombok.Data;

@Data
public abstract class CreateContactRequest {

    private CreateAddressRequest address;

    private String phone;

}
