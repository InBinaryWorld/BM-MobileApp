package dev.szafraniak.bm_mobileapp.business.models.entity.invoice;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InvoiceIndividual extends InvoiceContact {

    private String type = "individual";

    private String firstName;

    private String lastName;
}
