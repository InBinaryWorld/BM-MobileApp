package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form;


import android.view.View;

import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InvoiceItemViewHolder extends BaseViewHolder {
    public View productView;
    public View serviceView;
}