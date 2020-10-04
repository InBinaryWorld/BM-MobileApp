package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.contact;

import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.labeled.LabelFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClickableContactFormConfig extends LabelFormRowConfig<Contact> {

    private String emptyText;
}
