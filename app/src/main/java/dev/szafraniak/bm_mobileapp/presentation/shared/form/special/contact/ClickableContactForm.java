package dev.szafraniak.bm_mobileapp.presentation.shared.form.special.contact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.business.utils.Validator;
import dev.szafraniak.bm_mobileapp.presentation.shared.Callback;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;

public class ClickableContactForm extends BaseForm<Contact, ClickableContactFormViewHolder, ClickableContactFormConfig> {

    private static final String REQUIRED_HINT_SUFFIX = "*";
    private Contact contactHolder;

    @LayoutRes
    private final static int layoutId = R.layout.row_form_clickable_contact;
    private Callback onClickCallback;

    public ClickableContactForm(LayoutInflater inflater, ViewGroup viewGroup, ClickableContactFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(Contact value) {
        contactHolder = value;
        boolean areDataPresent = value != null && value.getAddress() != null;
        ClickableContactFormViewHolder holder = getViewHolder();
        holder.dataView.setVisibility(areDataPresent ? View.VISIBLE : View.GONE);
        holder.emptyView.setVisibility(areDataPresent ? View.GONE : View.VISIBLE);
        if (areDataPresent) {
            holder.name.setText(value.getName());
            holder.address.setText(value.getAddress().getShortAddress());
        }
    }

    @Override
    protected ClickableContactFormViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, ClickableContactFormConfig config) {
        ClickableContactFormViewHolder holder = new ClickableContactFormViewHolder();
        holder.view = inflater.inflate(layoutId, viewGroup, false);
        holder.label = holder.view.findViewById(R.id.tv_label);
        holder.empty = holder.view.findViewById(R.id.tv_empty);
        holder.address = holder.view.findViewById(R.id.tv_address);
        holder.address = holder.view.findViewById(R.id.tv_address);
        holder.dataView = holder.view.findViewById(R.id.cl_data_view);
        holder.emptyView = holder.view.findViewById(R.id.cl_empty_view);
        return holder;
    }

    @Override
    protected void setupView(ClickableContactFormConfig config) {
        String suffix = config.isRequired() ? REQUIRED_HINT_SUFFIX : "";
        String label = String.format("%s%s", config.getLabel(), suffix);
        ClickableContactFormViewHolder holder = getViewHolder();
        holder.label.setText(label);
        holder.empty.setText(config.getEmptyText());
        holder.view.setOnClickListener(this::onClick);
    }

    public void setOnClickAction(Callback onClickCallback) {
        this.onClickCallback = onClickCallback;
    }

    private void onClick(View view) {
        if (onClickCallback != null) {
            onClickCallback.call();
        }
    }

    @Override
    public Contact getValue() {
        return contactHolder;
    }

    @Override
    public boolean isValid() {
        Contact value = getValue();
        if (value == null) {
            return !getConfig().isRequired();
        }
        return Validator.validateContact(value);
    }
}
