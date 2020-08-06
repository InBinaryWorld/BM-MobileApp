package dev.szafraniak.bm_mobileapp.presentation;

import java.util.List;

public interface BaseListView<T> extends BaseView {

    void setData(List<T> items);

    void setError(Throwable e);
}
