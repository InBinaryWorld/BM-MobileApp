package dev.szafraniak.bm_mobileapp.business.models.entity.companyContact;

import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompanyContact extends Contact {

    private String name;

    private String taxIdentityNumber;

}
