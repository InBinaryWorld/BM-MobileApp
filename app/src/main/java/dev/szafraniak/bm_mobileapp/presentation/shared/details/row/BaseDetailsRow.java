package dev.szafraniak.bm_mobileapp.presentation.shared.details.row;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.DetailsRowValueExtractor;
import lombok.Getter;

public abstract class BaseDetailsRow<T, R, H extends BaseViewHolder,
        C extends BaseDetailsRowConfig<T, R>> implements DetailsRowInterface<T> {

    @Getter
    private final C config;

    @Getter
    private final H viewHolder;

    private final DetailsRowValueExtractor<T, R> valueExtractor;

    public BaseDetailsRow(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        this.config = config;
        this.valueExtractor = config.getValueExtractor();
        this.viewHolder = createViewHolder(inflater, viewGroup, config);
    }

    protected abstract void setValue(R value);

    protected abstract H createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, C config);

    @Override
    public View getView() {
        H holder = getViewHolder();
        return holder.getView();
    }

    @Override
    public void setData(T item) {
        R extracted = valueExtractor.extract(item);
        if (!config.isVisibleOnNull() && extracted == null) {
            getView().setVisibility(View.GONE);
        } else {
            getView().setVisibility(View.VISIBLE);
            R value = extracted != null ? extracted : config.getDefaultValue();
            setValue(value);
        }
    }
}
