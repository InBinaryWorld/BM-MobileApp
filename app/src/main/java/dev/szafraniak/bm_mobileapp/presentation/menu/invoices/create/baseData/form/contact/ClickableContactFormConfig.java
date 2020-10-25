package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form.contact;

import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.labeled.LabelFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClickableContactFormConfig extends LabelFormRowConfig<Contact> {

    private String emptyText;
}
