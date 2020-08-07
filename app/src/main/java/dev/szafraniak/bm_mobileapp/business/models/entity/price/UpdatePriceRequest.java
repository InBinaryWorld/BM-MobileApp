package dev.szafraniak.bm_mobileapp.business.models.entity.price;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class UpdatePriceRequest {

    private BigDecimal net;

    private BigDecimal taxRate;

    private BigDecimal gross;
}
