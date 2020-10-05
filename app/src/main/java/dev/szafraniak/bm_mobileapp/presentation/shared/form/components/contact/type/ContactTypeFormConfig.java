package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.type;

import java.util.HashMap;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.SpinnerFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContactTypeFormConfig extends SpinnerFormRowConfig<ContactType> {

    private HashMap<ContactType, String> displayValues;

}
