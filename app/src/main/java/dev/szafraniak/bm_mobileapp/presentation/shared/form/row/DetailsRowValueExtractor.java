package dev.szafraniak.bm_mobileapp.presentation.shared.form.row;

public interface DetailsRowValueExtractor<T, R> {
    R extract(T item);
}
