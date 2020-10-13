package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item;

import lombok.Data;

@Data
public class ItemCommand {
    public static final String MODIFY = "MODIFY";
    public static final String CREATE = "CREATE";

    private String type;
    private Long itemId;

}
