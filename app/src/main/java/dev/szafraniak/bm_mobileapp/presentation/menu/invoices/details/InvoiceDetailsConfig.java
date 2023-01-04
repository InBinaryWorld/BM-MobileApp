package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details.state.InvoiceStatusFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.BaseDetailsConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InvoiceDetailsConfig extends BaseDetailsConfig<Invoice> {

    private SimpleDetailsConfig<String> buyerNameConfig;
    private SimpleDetailsConfig<String> invoiceNumberConfig;
    private SimpleDetailsConfig<LocalDate> dueDateConfig;
    private SimpleDetailsConfig<LocalDate> issueDateConfig;
    private SimpleDetailsConfig<OffsetDateTime> creationDateConfig;
    private SimpleDetailsConfig<OffsetDateTime> dateOfPaymentConfig;
    private SimpleDetailsConfig<BigDecimal> grossConfig;
    private InvoiceStatusFormConfig statusConfig;

}

