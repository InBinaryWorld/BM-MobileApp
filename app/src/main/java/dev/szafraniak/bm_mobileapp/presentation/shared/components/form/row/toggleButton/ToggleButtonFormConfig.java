package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.toggleButton;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.labeled.LabelFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ToggleButtonFormConfig extends LabelFormRowConfig<Boolean> {

    private String description;
    private String invalidText;

}
