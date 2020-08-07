package dev.szafraniak.bm_mobileapp.business.models.entity.individualContact;

import dev.szafraniak.bm_mobileapp.business.models.entity.contact.UpdateContactRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateIndividualContactRequest extends UpdateContactRequest {

    private String firstName;

    private String lastName;

}
