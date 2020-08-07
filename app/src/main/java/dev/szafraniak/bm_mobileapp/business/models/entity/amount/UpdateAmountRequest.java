package dev.szafraniak.bm_mobileapp.business.models.entity.amount;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class UpdateAmountRequest {

    private BigDecimal net;

    private BigDecimal tax;

    private BigDecimal gross;

}
