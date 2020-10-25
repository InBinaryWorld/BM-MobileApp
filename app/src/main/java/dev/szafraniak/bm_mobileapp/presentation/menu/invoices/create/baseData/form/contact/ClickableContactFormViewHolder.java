package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form.contact;

import android.view.View;
import android.widget.TextView;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClickableContactFormViewHolder extends BaseViewHolder {
    public View emptyView;
    public View dataView;
    public TextView label;
    public TextView name;
    public TextView address;
    public TextView empty;
}
