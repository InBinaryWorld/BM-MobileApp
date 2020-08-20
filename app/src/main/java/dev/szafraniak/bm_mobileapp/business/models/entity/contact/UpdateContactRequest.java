package dev.szafraniak.bm_mobileapp.business.models.entity.contact;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.UpdateAddressRequest;
import lombok.Data;

@Data
public abstract class UpdateContactRequest {

    private UpdateAddressRequest address;

    private String phone;

}
