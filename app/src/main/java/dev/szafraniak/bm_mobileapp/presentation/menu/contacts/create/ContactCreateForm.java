package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.create;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.CreateContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create.CompanyContactCreateForm;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create.IndividualContactCreateForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.ContactType;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.ContactViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.baseType.BaseTypeForm;

import static dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.ContactType.COMPANY;
import static dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.ContactType.INDIVIDUAL;

public class ContactCreateForm extends BaseForm<CreateContactRequest, ContactViewHolder, ContactCreateFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group_with_padding;

    BaseTypeForm<ContactType> contactTypeForm;
    CompanyContactCreateForm companyForm;
    IndividualContactCreateForm individualForm;


    public ContactCreateForm(LayoutInflater inflater, ViewGroup viewGroup, ContactCreateFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }


    @Override
    public CreateContactRequest getValue() {
        ContactType type = contactTypeForm.getValue();
        if (INDIVIDUAL.equals(type)) {
            return individualForm.getValue();
        } else if (COMPANY.equals(type)) {
            return companyForm.getValue();
        }
        return null;
    }

    @Override
    public boolean isValid() {
        ContactType type = contactTypeForm.getValue();
        return INDIVIDUAL.equals(type) && individualForm.isValid()
            || COMPANY.equals(type) && companyForm.isValid();
    }

    @Override
    protected void showValueOnView(CreateContactRequest value) {
        if (value == null) {
            return;
        }
        boolean isIndividual = value instanceof CreateIndividualContactRequest;
        contactTypeForm.setValue(isIndividual ? INDIVIDUAL : COMPANY);
        if (isIndividual) {
            individualForm.setValue((CreateIndividualContactRequest) value);
        } else {
            companyForm.setValue((CreateCompanyContactRequest) value);
        }
    }

    @Override
    protected ContactViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, ContactCreateFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        contactTypeForm = new BaseTypeForm<ContactType>(inflater, groupList, config.getContactTypeForm());
        individualForm = new IndividualContactCreateForm(inflater, groupList, config.getIndividualConfig());
        companyForm = new CompanyContactCreateForm(inflater, groupList, config.getCompanyConfig());

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
    protected void setupView(LayoutInflater inflater, ContactCreateFormConfig config) {
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


