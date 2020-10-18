package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.timePicker;

import java.time.LocalTime;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.labeled.LabelFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TimePickerFormConfig extends LabelFormRowConfig<LocalTime> {

    private String emptyText;
    private String invalidText;

}
