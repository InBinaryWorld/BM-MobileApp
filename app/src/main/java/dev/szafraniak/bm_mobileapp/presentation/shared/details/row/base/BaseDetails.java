package dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsInterface;
import lombok.AccessLevel;
import lombok.Getter;

public abstract class BaseDetails<T, H extends BaseViewHolder,
    C extends BaseDetailsConfig<T>> implements DetailsInterface<T> {

    @Getter(AccessLevel.PROTECTED)
    private final C config;

    @Getter(AccessLevel.PROTECTED)
    private final H viewHolder;

    public BaseDetails(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        this.config = config;
        this.viewHolder = createViewHolder(inflater, viewGroup, config);
        this.setupAndShowDefault(inflater, config);
    }

    private void setupAndShowDefault(LayoutInflater inflater, C config) {
        this.setupView(inflater, config);
        if (config.getDefaultValue() != null) {
            showValueOnView(config.getDefaultValue());
        }
    }

    protected abstract void showValueOnView(T value);

    protected abstract H createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, C config);

    protected abstract void setupView(LayoutInflater inflater, C config);

    protected boolean shouldShowDefaultValue(T value) {
        return value == null;
    }

    @Override
    public View getView() {
        return viewHolder.getView();
    }

    @Override
    public void setValue(T input) {
        if (!config.isVisibleOnSetValueNull() && input == null) {
            getView().setVisibility(View.GONE);
            return;
        }
        getView().setVisibility(View.VISIBLE);
        T value = shouldShowDefaultValue(input) ? config.getDefaultValue() : input;
        showValueOnView(value);
    }

}
