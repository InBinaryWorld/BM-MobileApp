package dev.szafraniak.bm_mobileapp.presentation.shared.form;

import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.progress.BaseProgressRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.submit.BaseSubmitRow;

public abstract class FormConfig<T> {
    protected BaseSubmitRow baseSubmitRow;
    protected BaseProgressRow progressRow;
    protected List<FormRowInterface<T>> rowsConfiguration;

    public BaseProgressRow getProgressRow() {
        if (progressRow == null) {
            progressRow = createProgressRow();
        }
        return progressRow;
    }

    public BaseSubmitRow getBaseSubmitRow() {
        if (baseSubmitRow == null) {
            baseSubmitRow = createSubmitRow();
        }
        return baseSubmitRow;
    }

    public List<FormRowInterface<T>> getRowsConfiguration() {
        if (rowsConfiguration == null) {
            rowsConfiguration = createRowsConfiguration();
        }
        return rowsConfiguration;
    }

    abstract protected BaseSubmitRow createSubmitRow();

    abstract protected BaseProgressRow createProgressRow();

    abstract protected List<FormRowInterface<T>> createRowsConfiguration();
}
