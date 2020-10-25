package dev.szafraniak.bm_mobileapp.presentation.menu.product.create;

import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormView;

public interface ProductCreateView extends BaseFormView {

    void setData(List<ProductModel> items);

    void onError(Throwable throwable);
}
