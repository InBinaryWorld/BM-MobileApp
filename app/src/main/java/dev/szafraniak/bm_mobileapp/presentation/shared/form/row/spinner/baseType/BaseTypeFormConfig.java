package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.baseType;

import java.util.HashMap;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.SpinnerFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseTypeFormConfig<T> extends SpinnerFormRowConfig<T, T> {

    private HashMap<T, String> displayValues;

}
