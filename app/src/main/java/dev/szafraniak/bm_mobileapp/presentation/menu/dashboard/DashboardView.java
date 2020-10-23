package dev.szafraniak.bm_mobileapp.presentation.menu.dashboard;

import dev.szafraniak.bm_mobileapp.presentation.BaseView;

public interface DashboardView extends BaseView {

    void setError(Throwable throwable);

    void setData(DashboardDataModel data);
}
