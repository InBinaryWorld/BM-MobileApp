package dev.szafraniak.bm_mobileapp.business.models.entity.individualContact;

import dev.szafraniak.bm_mobileapp.business.models.entity.contact.CreateContactRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateIndividualContactRequest extends CreateContactRequest {

    private String firstName;

    private String lastName;

}
