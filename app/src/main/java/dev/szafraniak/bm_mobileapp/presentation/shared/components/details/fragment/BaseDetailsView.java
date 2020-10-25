package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment;

import dev.szafraniak.bm_mobileapp.presentation.shared.base.BaseView;

public interface BaseDetailsView<T> extends BaseView {

    void setError(Throwable e);

}
