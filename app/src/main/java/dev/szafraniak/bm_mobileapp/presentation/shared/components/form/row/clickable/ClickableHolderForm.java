package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.clickable;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.labeled.LabelFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.labeled.LabelFormRowConfig;

public abstract class ClickableHolderForm<T, H extends BaseViewHolder,
        C extends LabelFormRowConfig<T>> extends LabelFormRow<T, H, C> {

    private T modelHolder;

    public ClickableHolderForm(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        super(inflater, viewGroup, config);
    }

    protected abstract void viewOnNullValue();

    protected abstract void viewOnNotNullValue(@NotNull T value);

    @Override
    protected void showValueOnView(T value) {
        modelHolder = value;
        if (value == null) {
            viewOnNullValue();
            return;
        }
        viewOnNotNullValue(value);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    public T getValue() {
        return modelHolder;
    }

}
