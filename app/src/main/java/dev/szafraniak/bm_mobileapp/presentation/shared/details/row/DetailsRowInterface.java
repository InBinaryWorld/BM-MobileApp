package dev.szafraniak.bm_mobileapp.presentation.shared.details.row;

import android.view.View;

public interface DetailsRowInterface<T> {

    View getView();

    void setData(T item);
}
