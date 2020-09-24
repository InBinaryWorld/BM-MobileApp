package dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview;

import android.widget.TextView;

import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TextViewHolder extends BaseViewHolder {
    public TextView label;
    public TextView value;
}