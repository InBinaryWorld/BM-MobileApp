package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateInvoiceBaseDataFormConfig extends BaseFormConfig<CreateInvoiceBaseDataModel> {

    public TextEditTextFormRowConfig invoiceNumberConfig;

}

