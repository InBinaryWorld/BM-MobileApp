package dev.szafraniak.bm_mobileapp.business.models.entity.payment;

import lombok.Data;

@Data
public class PaymentMethodTransfer implements PaymentMethod {

    private String bankAccount;
}
