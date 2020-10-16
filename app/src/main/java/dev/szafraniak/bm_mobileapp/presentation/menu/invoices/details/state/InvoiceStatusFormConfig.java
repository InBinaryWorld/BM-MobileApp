package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details.state;

import java.util.HashMap;

import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetailsConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InvoiceStatusFormConfig extends BaseDetailsConfig<Boolean> {

    private HashMap<Boolean, String> displayValues;
    private String label;

}
