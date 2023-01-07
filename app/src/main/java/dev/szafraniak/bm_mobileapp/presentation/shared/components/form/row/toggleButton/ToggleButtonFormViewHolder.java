package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.toggleButton;

import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ToggleButtonFormViewHolder extends BaseViewHolder {
    public TextView label;
    public TextView description;
    public TextView error;
    public SwitchMaterial toggle;
}
