package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.dateTimePicker;

import java.time.LocalDateTime;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormRowConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.datePicker.DatePickerFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.timePicker.TimePickerFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DateTimePickerFormConfig extends BaseFormRowConfig<LocalDateTime> {

    private DatePickerFormConfig dateConfig;
    private TimePickerFormConfig timeConfig;
    private String invalidMessage;

}
