package dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment;

import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetailsConfig;
import lombok.Setter;

public abstract class BaseDetailsPresenter<T, F extends BaseDetailsView<T>, C extends BaseDetailsConfig<T>> {

    @Setter
    protected F view;

    public abstract C createConfig();

}
