package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.contact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import org.jetbrains.annotations.NotNull;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.clickable.ClickableHolderForm;

public abstract class ClickableContactForm extends ClickableHolderForm<Contact, ClickableContactFormViewHolder, ClickableContactFormConfig> {

    @LayoutRes
    private final static int layoutId = R.layout.row_form_clickable_contact;

    public ClickableContactForm(LayoutInflater inflater, ViewGroup viewGroup, ClickableContactFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void viewOnNullValue() {
        ClickableContactFormViewHolder holder = getViewHolder();
        holder.dataView.setVisibility(View.GONE);
        holder.emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void viewOnNotNullValue(@NotNull Contact value) {
        ClickableContactFormViewHolder holder = getViewHolder();
        holder.dataView.setVisibility(View.VISIBLE);
        holder.emptyView.setVisibility(View.GONE);
        holder.name.setText(value.getName());
        holder.address.setText(value.getAddress().getShortAddress());
    }


    @Override
    protected void setLabel(String label) {
        ClickableContactFormViewHolder holder = getViewHolder();
        holder.label.setText(label);
    }

    @Override
    protected ClickableContactFormViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, ClickableContactFormConfig config) {
        ClickableContactFormViewHolder holder = new ClickableContactFormViewHolder();
        holder.view = inflater.inflate(layoutId, viewGroup, false);
        holder.label = holder.view.findViewById(R.id.tv_label);
        holder.empty = holder.view.findViewById(R.id.tv_empty);
        holder.name = holder.view.findViewById(R.id.tv_contact_name);
        holder.address = holder.view.findViewById(R.id.tv_address);
        holder.dataView = holder.view.findViewById(R.id.cl_data_view);
        holder.emptyView = holder.view.findViewById(R.id.cl_empty_view);
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, ClickableContactFormConfig config) {
        ClickableContactFormViewHolder holder = getViewHolder();
        holder.empty.setText(config.getEmptyText());
        holder.view.setOnClickListener(this::navigateToContactForm);
    }

    protected abstract void navigateToContactForm(View clickedView);

}
