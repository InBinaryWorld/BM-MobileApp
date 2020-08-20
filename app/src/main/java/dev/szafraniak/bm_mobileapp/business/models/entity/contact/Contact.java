package dev.szafraniak.bm_mobileapp.business.models.entity.contact;

import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import lombok.Data;

@Data
public abstract class Contact {

    private Long id;

    private String phone;

    private Address address;

    private List<Invoice> invoices;

    public abstract String getName();


}
