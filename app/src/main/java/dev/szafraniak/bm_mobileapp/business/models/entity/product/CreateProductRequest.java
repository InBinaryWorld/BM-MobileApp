package dev.szafraniak.bm_mobileapp.business.models.entity.product;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CreateProductRequest {

    private BigDecimal quantity;

    private Long productModelId;

    private Long warehouseId;

}
