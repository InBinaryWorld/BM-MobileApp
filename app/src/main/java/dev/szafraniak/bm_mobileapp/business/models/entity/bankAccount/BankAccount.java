package dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount;

import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import lombok.Data;

@Data
public class BankAccount implements PaymentMethod {

    private Long id;

    private String name;

    private String number;
}
