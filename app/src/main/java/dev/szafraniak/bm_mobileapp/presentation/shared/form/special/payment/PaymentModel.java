package dev.szafraniak.bm_mobileapp.presentation.shared.form.special.payment;

import java.time.LocalDate;

import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import lombok.Data;

@Data
public class PaymentModel {

    private PaymentMethod paymentMethod;
    private LocalDate dueDate;
}
