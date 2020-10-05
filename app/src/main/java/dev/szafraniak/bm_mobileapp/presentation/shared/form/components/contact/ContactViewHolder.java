package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact;


import android.view.View;

import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContactViewHolder extends BaseViewHolder {
    public View individualView;
    public View companyView;
}