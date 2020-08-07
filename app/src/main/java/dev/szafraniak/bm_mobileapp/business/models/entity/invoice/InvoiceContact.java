package dev.szafraniak.bm_mobileapp.business.models.entity.invoice;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import lombok.Data;

@Data
public abstract class InvoiceContact {

    private Address address;

}
