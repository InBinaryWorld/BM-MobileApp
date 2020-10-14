package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.list;

import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ListFormRowConfig<T> extends BaseFormRowConfig<List<T>> {

}
