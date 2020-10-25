package dev.szafraniak.bm_mobileapp.presentation.menu.product.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormView;

public interface ProductModifyView extends BaseFormView {

    void setModifyModel(Product product);
}
