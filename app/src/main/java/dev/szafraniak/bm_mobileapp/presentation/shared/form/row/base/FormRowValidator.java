package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base;

public interface FormRowValidator<R> {
    boolean validate(R value);
}
