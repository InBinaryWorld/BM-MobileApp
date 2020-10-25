package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.dateTimePicker;

import android.view.View;
import android.widget.TextView;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DateTimePickerFormViewHolder extends BaseViewHolder {
    public View error;
    public TextView errorTV;
}
