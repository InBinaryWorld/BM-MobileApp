package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner;

import android.widget.Spinner;
import android.widget.TextView;

import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SpinnerViewHolder extends BaseViewHolder {
    public TextView label;
    public Spinner spinner;
}