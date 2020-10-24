package dev.szafraniak.bm_mobileapp.business.models;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AmountModel {
    public AmountModel(BigDecimal net, BigDecimal tax, BigDecimal gross) {
        this.net = net;
        this.tax = tax;
        this.gross = gross;
    }

    private BigDecimal net;
    private BigDecimal tax;
    private BigDecimal gross;
}
