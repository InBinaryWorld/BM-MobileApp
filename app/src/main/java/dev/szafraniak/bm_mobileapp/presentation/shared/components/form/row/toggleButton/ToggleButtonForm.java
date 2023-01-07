package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.toggleButton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.utils.ViewUtils;


public class ToggleButtonForm extends BaseFormRow<Boolean, ToggleButtonFormViewHolder, ToggleButtonFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.row_toggle_button;

    public ToggleButtonForm(LayoutInflater inflater, ViewGroup viewGroup, ToggleButtonFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
        ToggleButtonFormViewHolder holder = getViewHolder();
        holder.error.setVisibility(isValid ? View.GONE : View.VISIBLE);
    }

    @Override
    protected void showValueOnView(Boolean value) {
        getViewHolder().toggle.setChecked(value);
        onValueChange();
    }

    @Override
    protected ToggleButtonFormViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, ToggleButtonFormConfig config) {
        ToggleButtonFormViewHolder holder = new ToggleButtonFormViewHolder();
        holder.view = inflater.inflate(layoutId, viewGroup, false);
        holder.label = holder.view.findViewById(R.id.tv_label);
        holder.description = holder.view.findViewById(R.id.tv_description);
        holder.error = holder.view.findViewById(R.id.tv_invalid_view);
        holder.toggle = holder.view.findViewById(R.id.sw_toggle);
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, ToggleButtonFormConfig config) {
        ToggleButtonFormViewHolder holder = getViewHolder();
        holder.error.setVisibility(View.GONE);
        holder.error.setText(config.getInvalidText());
        holder.label.setText(config.getLabel());
        holder.description.setText(config.getDescription());
        holder.view.setClickable(true);
        ViewUtils.addOnToggleChangeListener(holder.toggle, this::onValueChange);
    }

    @Override
    public Boolean getValue() {
        ToggleButtonFormViewHolder holder = getViewHolder();
        return holder.toggle.isChecked();
    }

}
