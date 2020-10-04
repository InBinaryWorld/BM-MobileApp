package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.labeled.LabelFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.utils.ViewUtils;

public abstract class BaseSpinnerFormRow<T, C extends SpinnerFormRowConfig<T>> extends LabelFormRow<T, SpinnerViewHolder, C> {

    private BaseSpinnerAdapter<T> spinnerAdapter;

    @LayoutRes
    private final static int layoutId = R.layout.row_form_spinner;

    public BaseSpinnerFormRow(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        super(inflater, viewGroup, config);
    }

    protected abstract BaseSpinnerAdapter<T> createAdapter(LayoutInflater inflater, C config);

    @Override
    public T getValue() {
        SpinnerViewHolder holder = getViewHolder();
        Spinner spinner = holder.getSpinner();
        int position = spinner.getSelectedItemPosition();
        return spinnerAdapter.getItem(position);
    }

    @Override
    protected void showValueOnView(T value) {
        SpinnerViewHolder holder = getViewHolder();
        Spinner spinner = holder.getSpinner();
        int position = spinnerAdapter.getItemPosition(value);
        spinner.setSelection(position);
    }

    @Override
    protected void setupView(LayoutInflater inflater, C config) {
        SpinnerViewHolder holder = getViewHolder();
        spinnerAdapter = createAdapter(inflater, config);
        holder.spinner.setAdapter(spinnerAdapter);
        ViewUtils.addOnItemSelectedListener(holder.spinner, this::onValueChange);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void setLabel(String label) {
        SpinnerViewHolder holder = getViewHolder();
        holder.label.setText(label);
    }

    @Override
    protected SpinnerViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        SpinnerViewHolder holder = new SpinnerViewHolder();
        holder.view = inflater.inflate(layoutId, viewGroup, false);
        holder.label = holder.view.findViewById(R.id.tv_label);
        holder.spinner = holder.view.findViewById(R.id.spn_spinner);
        return holder;
    }

}
