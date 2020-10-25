package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.details;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment.BaseDetailsView;

public interface ProductModelDetailsView extends BaseDetailsView<ProductModel> {

    void setData(ProductModel productModel);
}
