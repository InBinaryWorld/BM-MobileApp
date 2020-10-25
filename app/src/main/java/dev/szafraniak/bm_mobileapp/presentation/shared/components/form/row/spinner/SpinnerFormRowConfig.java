package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.spinner;

import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.labeled.LabelFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SpinnerFormRowConfig<T, B> extends LabelFormRowConfig<B> {

    private List<T> spinnerItems;

}
