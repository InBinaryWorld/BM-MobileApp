package dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment;

import dev.szafraniak.bm_mobileapp.presentation.BaseView;

public interface BaseDetailsView<T> extends BaseView {

    void setError(Throwable e);

    void setData(T item);
}
