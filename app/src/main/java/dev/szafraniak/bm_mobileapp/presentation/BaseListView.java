package dev.szafraniak.bm_mobileapp.presentation;

import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.BMCollection;

public interface BaseListView<T> extends BaseView {

    void setData(BMCollection<T> collection);

    void setData(List<T> items);

    void setError(Throwable e);
}
