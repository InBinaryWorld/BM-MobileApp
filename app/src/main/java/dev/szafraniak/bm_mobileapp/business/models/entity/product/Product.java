package dev.szafraniak.bm_mobileapp.business.models.entity.product;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.mics.IdNameEntity;
import lombok.Data;

@Data
public class Product {

    private Long id;

    private BigDecimal quantity;

    private ProductModel productModel;

    private IdNameEntity warehouse;

}
