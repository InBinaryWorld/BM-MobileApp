package dev.szafraniak.bm_mobileapp.business.models.entity.individualContact;

import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IndividualContact extends Contact {

    private String firstName;

    private String lastName;

}
