package dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview;

import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.BaseDetailsRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SimpleTextViewDetailsRowConfig<E> extends BaseDetailsRowConfig<E, String> {
    String label;
}
