package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetailsConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InvoiceDetailsConfig extends BaseDetailsConfig<Invoice> {

    private SimpleDetailsConfig<String> buyerNameConfig;
    private SimpleDetailsConfig<String> invoiceNumberConfig;
    private SimpleDetailsConfig<LocalDate> dueDateConfig;
    private SimpleDetailsConfig<OffsetDateTime> creationDateConfig;
    private SimpleDetailsConfig<BigDecimal> grossConfig;
}

