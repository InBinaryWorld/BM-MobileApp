package dev.szafraniak.bm_mobileapp.presentation.shared.details;

import lombok.Setter;

public abstract class BaseDetailsPresenter<T extends BaseDetailsView<S>, S> {


    @Setter
    protected T view;

    public abstract void loadData(S object);


    protected void onError(Throwable throwable) {
        view.setError(throwable);
    }

    protected void onSuccess(S object) {
        view.setData(object);
    }
}
