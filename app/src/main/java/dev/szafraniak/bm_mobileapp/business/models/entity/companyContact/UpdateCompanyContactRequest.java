package dev.szafraniak.bm_mobileapp.business.models.entity.companyContact;

import dev.szafraniak.bm_mobileapp.business.models.entity.contact.UpdateContactRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateCompanyContactRequest extends UpdateContactRequest {

    private String name;

    private String taxIdentityNumber;

}
