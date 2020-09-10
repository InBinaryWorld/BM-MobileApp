package dev.szafraniak.bm_mobileapp.presentation.shared.details;

import lombok.Setter;

public abstract class BaseDetailsPresenter<T extends BaseDetailsView<S>, S> {

    @Setter
    protected T view;

    protected void onError(Throwable throwable) {
        view.setError(throwable);
    }

    protected void onSuccess(S object) {
        view.setData(object);
    }
}
