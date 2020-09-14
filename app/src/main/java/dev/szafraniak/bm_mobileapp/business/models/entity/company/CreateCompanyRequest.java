package dev.szafraniak.bm_mobileapp.business.models.entity.company;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import lombok.Data;

@Data
public class CreateCompanyRequest {

    private String name;

    private String invoicePrefix;

    private String taxIdentityNumber;

    private Address headquarter;

}
