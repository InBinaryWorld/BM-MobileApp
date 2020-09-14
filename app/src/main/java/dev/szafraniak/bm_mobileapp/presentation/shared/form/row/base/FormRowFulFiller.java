package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base;

public interface FormRowFulFiller<S, R> {
    void fulfill(S object, R value);
}
