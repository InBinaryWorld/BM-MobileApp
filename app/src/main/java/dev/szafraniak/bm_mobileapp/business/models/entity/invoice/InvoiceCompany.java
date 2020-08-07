package dev.szafraniak.bm_mobileapp.business.models.entity.invoice;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InvoiceCompany extends InvoiceContact {


    private String type = "company";

    private String name;

    private String taxIdentityNumber;

}
