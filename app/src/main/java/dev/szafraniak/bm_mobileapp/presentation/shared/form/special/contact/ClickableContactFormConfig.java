package dev.szafraniak.bm_mobileapp.presentation.shared.form.special.contact;

import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClickableContactFormConfig extends BaseFormConfig<Contact> {

    private String label;
    private String emptyText;
    private boolean required;
}
