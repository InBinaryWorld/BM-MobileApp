package dev.szafraniak.bm_mobileapp.presentation.shared.list;

import lombok.Data;

@Data
public class CurrencyWrapper<T> {
    public CurrencyWrapper(String currency, T item) {
        this.currency = currency;
        this.item = item;
    }

    private String currency;
    private T item;
}
