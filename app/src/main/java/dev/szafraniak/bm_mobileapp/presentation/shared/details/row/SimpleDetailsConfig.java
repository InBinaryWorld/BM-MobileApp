package dev.szafraniak.bm_mobileapp.presentation.shared.details.row;

import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetailsConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SimpleDetailsConfig<T> extends BaseDetailsConfig<T> {

    private T initValue;
    private String label;
}
