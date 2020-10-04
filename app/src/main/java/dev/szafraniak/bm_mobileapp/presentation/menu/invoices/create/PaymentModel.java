package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create;

import java.time.LocalDate;

import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import lombok.Data;

@Data
public class PaymentModel {

    private PaymentMethod paymentMethod;
    private LocalDate dueDate;
}
