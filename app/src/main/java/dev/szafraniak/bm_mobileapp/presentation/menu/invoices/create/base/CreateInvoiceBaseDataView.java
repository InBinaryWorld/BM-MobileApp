package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base;

import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormView;

public interface CreateInvoiceBaseDataView extends BaseFormView {

    void setData(CreateInvoiceBaseDataModel model, Company company);

}
