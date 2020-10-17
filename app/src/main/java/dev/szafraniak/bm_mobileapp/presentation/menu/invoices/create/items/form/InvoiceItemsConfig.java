package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form;

import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form.summary.InvoiceItemsSummaryConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.list.ListFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InvoiceItemsConfig extends BaseFormConfig<List<InvoiceItemFormModel>> {
    private InvoiceItemsSummaryConfig summaryConfig;
    private ListFormRowConfig<InvoiceItemFormModel> itemsConfig;

}
