package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.type;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.BaseSpinnerFormRow;

public class ContactTypeForm extends BaseSpinnerFormRow<ContactType, ContactTypeFormConfig> {
    public ContactTypeForm(LayoutInflater inflater, ViewGroup viewGroup, ContactTypeFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected ContactTypeAdapter createAdapter(LayoutInflater inflater, ContactTypeFormConfig config) {
        return new ContactTypeAdapter(inflater, config);
    }

}
