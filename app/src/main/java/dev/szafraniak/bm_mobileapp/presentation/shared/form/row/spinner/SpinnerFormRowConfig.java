package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner;

import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.labeled.LabelFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SpinnerFormRowConfig<T> extends LabelFormRowConfig<T> {

    private List<T> spinnerItems;

}
