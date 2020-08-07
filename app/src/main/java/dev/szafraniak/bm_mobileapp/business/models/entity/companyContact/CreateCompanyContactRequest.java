package dev.szafraniak.bm_mobileapp.business.models.entity.companyContact;

import dev.szafraniak.bm_mobileapp.business.models.entity.contact.CreateContactRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateCompanyContactRequest extends CreateContactRequest {

    private String name;

    private String taxIdentityNumber;

}
