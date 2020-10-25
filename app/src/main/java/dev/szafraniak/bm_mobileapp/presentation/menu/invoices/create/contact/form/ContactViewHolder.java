package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact.form;


import android.view.View;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContactViewHolder extends BaseViewHolder {
    public View individualView;
    public View companyView;
}