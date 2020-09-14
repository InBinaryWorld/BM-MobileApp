package dev.szafraniak.bm_mobileapp.presentation.shared.details.row;

public interface DetailsRowValueExtractor<T, R> {
    R extract(T item);
}
