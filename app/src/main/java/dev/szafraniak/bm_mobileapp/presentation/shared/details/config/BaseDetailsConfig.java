package dev.szafraniak.bm_mobileapp.presentation.shared.details.config;

import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class BaseDetailsConfig<T> extends DetailsConfig<T> {

    protected final LayoutInflater inflater;
    protected final ViewGroup viewGroup;

    public BaseDetailsConfig(LayoutInflater inflater, ViewGroup viewGroup) {
        this.inflater = inflater;
        this.viewGroup = viewGroup;
    }
}
