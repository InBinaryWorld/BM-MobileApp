package dev.szafraniak.bm_mobileapp.presentation.shared.details.row;

import android.view.View;

public interface DetailsInterface<T> {

    View getView();

    void setValue(T item);
}
