package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment;

public interface BaseDetailsWithBtnView<T> extends BaseDetailsView<T> {

    void setActionFailed(Throwable e);

    void setActionSucceed();

}
