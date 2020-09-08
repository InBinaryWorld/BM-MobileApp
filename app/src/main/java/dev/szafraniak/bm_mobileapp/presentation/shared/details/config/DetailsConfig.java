package dev.szafraniak.bm_mobileapp.presentation.shared.details.config;


import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.DetailsRowInterface;
import lombok.Data;

@Data
public abstract class DetailsConfig<T> {

    protected List<DetailsRowInterface<T>> rowsConfiguration;


    public List<DetailsRowInterface<T>> getRowsConfiguration() {
        if (rowsConfiguration == null) {
            rowsConfiguration = createRowsConfiguration();
        }
        return rowsConfiguration;
    }

    abstract protected List<DetailsRowInterface<T>> createRowsConfiguration();
}
