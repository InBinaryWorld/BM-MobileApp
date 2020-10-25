package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.spinner.type;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.spinner.BaseSpinnerAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.spinner.BaseSpinnerFormRow;

public class BaseTypeForm<T> extends BaseSpinnerFormRow<T, T, BaseTypeFormConfig<T>> {
    public BaseTypeForm(LayoutInflater inflater, ViewGroup viewGroup, BaseTypeFormConfig<T> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected BaseTypeAdapter<T> createAdapter(LayoutInflater inflater, BaseTypeFormConfig<T> config) {
        return new BaseTypeAdapter<>(inflater, config);
    }

    @Override
    protected int getPositionByValue(BaseSpinnerAdapter<T, T> spinnerAdapter, T value) {
        return spinnerAdapter.getItemPosition(value);
    }

}
