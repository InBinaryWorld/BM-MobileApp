package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.company.CompanyAutoCompleteForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.individual.IndividualAutoCompleteForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.type.ContactType;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.type.ContactTypeForm;

import static dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.type.ContactType.COMPANY;
import static dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.type.ContactType.INDIVIDUAL;

public class ContactForm extends BaseForm<Contact, ContactViewHolder, ContactFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    ContactTypeForm contactTypeForm;
    IndividualAutoCompleteForm individualForm;
    CompanyAutoCompleteForm companyForm;


    public ContactForm(LayoutInflater inflater, ViewGroup viewGroup, ContactFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    public Contact getValue() {
        ContactType type = contactTypeForm.getValue();
        System.out.println("type !!! " + type);
        if (INDIVIDUAL.equals(type)) {
            return individualForm.getValue();
        } else if (COMPANY.equals(type)) {
            return companyForm.getValue();
        }
        System.out.println("null !!! " + type);
        return null;
    }

    @Override
    public boolean isValid() {
        ContactType type = contactTypeForm.getValue();
        return INDIVIDUAL.equals(type) && individualForm.isValid()
            || COMPANY.equals(type) && companyForm.isValid();
    }

    @Override
    protected void showValueOnView(Contact value) {
        boolean isIndividual = value instanceof IndividualContact;
        contactTypeForm.setValue(isIndividual ? INDIVIDUAL : COMPANY);
        if (isIndividual) {
            individualForm.setValue((IndividualContact) value);
        } else {
            companyForm.setValue((CompanyContact) value);
        }
    }

    @Override
    protected ContactViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, ContactFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        contactTypeForm = new ContactTypeForm(inflater, groupList, config.getContactTypeForm());
        individualForm = new IndividualAutoCompleteForm(inflater, groupList, config.getIndividualConfig());
        companyForm = new CompanyAutoCompleteForm(inflater, groupList, config.getCompanyConfig());

        View individualFormView = individualForm.getView();
        View companyFormView = companyForm.getView();
        groupList.addView(contactTypeForm.getView());
        groupList.addView(companyFormView);
        groupList.addView(individualFormView);

        ContactViewHolder holder = new ContactViewHolder();
        holder.view = groupList;
        holder.companyView = companyFormView;
        holder.individualView = individualFormView;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, ContactFormConfig config) {
        contactTypeForm.setOnValueChange(this::onTypeChange);
        individualForm.setOnValidationStateChanged(this::onValueChange);
        companyForm.setOnValidationStateChanged(this::onValueChange);
    }

    private void onTypeChange(boolean isValid) {
        ContactViewHolder holder = getViewHolder();
        boolean isIndividual = INDIVIDUAL.equals(contactTypeForm.getValue());
        holder.individualView.setVisibility(isIndividual ? View.VISIBLE : View.GONE);
        holder.companyView.setVisibility(!isIndividual ? View.VISIBLE : View.GONE);
        onValueChange();
    }

}
