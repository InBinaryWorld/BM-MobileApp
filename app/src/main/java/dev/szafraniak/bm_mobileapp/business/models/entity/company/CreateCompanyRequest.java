package dev.szafraniak.bm_mobileapp.business.models.entity.company;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.CreateAddressRequest;
import lombok.Data;

@Data
public class CreateCompanyRequest {

    private Long nextInvoiceNumber;

    private String name;

    private String invoicePrefix;

    private String taxIdentityNumber;

    private CreateAddressRequest headquarter;

}
