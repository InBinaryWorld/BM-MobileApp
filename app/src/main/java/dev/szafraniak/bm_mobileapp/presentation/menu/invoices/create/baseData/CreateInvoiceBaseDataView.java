package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData;

import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceBaseFormModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormView;

public interface CreateInvoiceBaseDataView extends BaseFormView {

    void setData(CreateInvoiceBaseFormModel model, Company company);

}
