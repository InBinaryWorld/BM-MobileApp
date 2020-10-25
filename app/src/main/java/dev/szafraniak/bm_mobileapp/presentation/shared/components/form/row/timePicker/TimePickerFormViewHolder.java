package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.timePicker;

import android.view.View;
import android.widget.TextView;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TimePickerFormViewHolder extends BaseViewHolder {
    public View emptyView;
    public View dataView;
    public TextView label;
    public TextView error;
    public TextView value;
    public TextView empty;
}
