package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.labeled;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;

public abstract class LabelFormRow<T, H extends BaseViewHolder,
        C extends LabelFormRowConfig<T>> extends BaseFormRow<T, H, C> {

    private final static String REQUIRED_HINT_SUFFIX = "*";

    public LabelFormRow(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        super(inflater, viewGroup, config);
        setLabel(getFinalLabel(config));
    }

    protected abstract void setLabel(String label);

    private String getFinalLabel(C config) {
        String suffix = config.isRequired() ? REQUIRED_HINT_SUFFIX : "";
        return String.format("%s%s", config.getLabel(), suffix);
    }
}
