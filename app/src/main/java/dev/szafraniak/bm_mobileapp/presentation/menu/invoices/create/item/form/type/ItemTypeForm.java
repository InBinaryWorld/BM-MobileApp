package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.type;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.BaseSpinnerFormRow;

public class ItemTypeForm extends BaseSpinnerFormRow<ItemType, ItemTypeFormConfig> {
    public ItemTypeForm(LayoutInflater inflater, ViewGroup viewGroup, ItemTypeFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected ItemTypeAdapter createAdapter(LayoutInflater inflater, ItemTypeFormConfig config) {
        return new ItemTypeAdapter(inflater, config);
    }

}
