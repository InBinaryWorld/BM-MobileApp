package dev.szafraniak.bm_mobileapp.presentation.shared.list;

import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
import dev.szafraniak.bm_mobileapp.presentation.shared.base.BaseView;

public interface BaseListView<T> extends BaseView {

    void setData(BMCollection<T> collection);

    void setData(List<T> items);

    void setError(Throwable e);
}
