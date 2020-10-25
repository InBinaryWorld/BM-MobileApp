package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.list;

import android.view.View;
import android.widget.ListView;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ListFormViewHolder extends BaseViewHolder {
    public ListView listView;
    public View emptyView;
}