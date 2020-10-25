package dev.szafraniak.bm_mobileapp.presentation.menu.invoices;

import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.stats.FinancesStatsModel;
import lombok.Data;

@Data
public class InvoicesDataModel {
    BMCollection<Invoice> invoiceCollection;
    FinancesStatsModel financesStats;
}
