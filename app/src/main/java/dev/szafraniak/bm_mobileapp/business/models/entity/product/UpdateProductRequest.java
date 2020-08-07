package dev.szafraniak.bm_mobileapp.business.models.entity.product;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class UpdateProductRequest {

    private BigDecimal quantity;

}
