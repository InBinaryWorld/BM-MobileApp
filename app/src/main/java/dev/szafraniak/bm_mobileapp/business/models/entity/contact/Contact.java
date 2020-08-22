package dev.szafraniak.bm_mobileapp.business.models.entity.contact;

import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.FilterValue;
import lombok.Data;

@Data
public abstract class Contact extends FilterValue {

    private Long id;

    private String phone;

    private Address address;

    private List<Invoice> invoices;

    public abstract String getName();

    @Override
    protected String createDescriptionForFilter() {
        return String.format("%s %s %s", getName(), address.getDescriptionForFilter(), phone);
    }
}
