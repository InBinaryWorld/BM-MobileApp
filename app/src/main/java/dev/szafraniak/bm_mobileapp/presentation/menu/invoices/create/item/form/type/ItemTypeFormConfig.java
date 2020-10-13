package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.type;

import java.util.HashMap;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.SpinnerFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ItemTypeFormConfig extends SpinnerFormRowConfig<ItemType> {

    private HashMap<ItemType, String> displayValues;

}
