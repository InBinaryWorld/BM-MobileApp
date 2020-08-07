package dev.szafraniak.bm_mobileapp.business.models.entity.company;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.UpdateAddressRequest;
import lombok.Data;

@Data
public class UpdateCompanyRequest {

    private String name;

    private String invoicePrefix;

    private String taxIdentityNumber;

    private UpdateAddressRequest headquarter;
}
