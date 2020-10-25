package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base;

import android.view.View;

public interface DetailsInterface<T> {

    View getView();

    void setValue(T item);
}
