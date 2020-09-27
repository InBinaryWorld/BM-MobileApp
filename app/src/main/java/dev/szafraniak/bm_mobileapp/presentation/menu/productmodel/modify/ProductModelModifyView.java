package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormView;

public interface ProductModelModifyView extends BaseFormView {

    void setModifyModel(ProductModel productModel);
}
