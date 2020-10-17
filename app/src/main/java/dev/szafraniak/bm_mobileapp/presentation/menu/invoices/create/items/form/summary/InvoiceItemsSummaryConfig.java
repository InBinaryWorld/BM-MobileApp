package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form.summary;

import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InvoiceItemsSummaryConfig extends BaseFormConfig<List<InvoiceItemFormModel>> {
}
