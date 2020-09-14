package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base;

public interface FormRowParser<R, S> {
    S parse(R value);
}
