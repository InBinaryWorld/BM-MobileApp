package dev.szafraniak.bm_mobileapp.presentation.shared.details.row;

import lombok.Data;

@Data
public class BaseDetailsRowConfig<T, R> {

    private R defaultValue;
    private boolean visibleOnNull;
    private DetailsRowValueExtractor<T, R> valueExtractor;

}
