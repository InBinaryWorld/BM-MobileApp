package dev.szafraniak.bm_mobileapp.business.models.entity.payment;

import lombok.Data;

@Data
public class PaymentTransfer implements PaymentMethod {

    private String accountName;

    private String accountNumber;
}
