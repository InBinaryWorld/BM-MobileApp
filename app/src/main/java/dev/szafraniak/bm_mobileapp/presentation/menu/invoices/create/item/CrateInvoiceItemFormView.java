package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item;

import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormView;

public interface CrateInvoiceItemFormView extends BaseFormView {

    void setData(InvoiceItemFormModel item, List<ProductModel> productModels, List<ServiceModel> serviceModels);

}
