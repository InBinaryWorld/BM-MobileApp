package dev.szafraniak.bm_mobileapp.business.models.entity.productGroup;

import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import lombok.Data;

@Data
public class ProductGroup {

    private Long id;

    private String name;

    private List<ProductModel> productModels;

}
