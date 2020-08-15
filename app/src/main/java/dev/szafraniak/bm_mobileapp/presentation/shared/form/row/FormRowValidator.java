package dev.szafraniak.bm_mobileapp.presentation.shared.form.row;

public interface FormRowValidator<R> {
    boolean validate(R value);
}
