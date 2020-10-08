package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.datePicker;

import com.google.android.material.datepicker.CalendarConstraints;

import java.time.LocalDate;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.labeled.LabelFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DatePickerFormConfig extends LabelFormRowConfig<LocalDate> {

    private String emptyText;
    private String invalidText;
    private CalendarConstraints.DateValidator pickerValidator;

}
