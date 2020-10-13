package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.type.ItemType;
import lombok.Data;

@Data
public class InvoiceItemFormModel {

    private Long id;

    private ItemType type;

    private String name;

    private String quantityUnit;

    private BigDecimal quantity;

    private Price price;
}
