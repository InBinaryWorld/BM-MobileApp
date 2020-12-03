package dev.szafraniak.bm_mobileapp.presentation.shared.components.details;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.BaseDetailsConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SimpleDetailsConfig<T> extends BaseDetailsConfig<T> {

    private String label;
}