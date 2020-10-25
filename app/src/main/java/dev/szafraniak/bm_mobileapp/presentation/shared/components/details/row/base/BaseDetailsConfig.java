package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base;

import lombok.Data;

@Data
public class BaseDetailsConfig<T> {

    private T defaultValue;
    private boolean visibleOnSetValueNull;

}
