package dev.szafraniak.bm_mobileapp.business.models;

import java.util.List;

import lombok.Data;

@Data
public class BMCollection<T> {

    private long total;
    
    private List<T> items;
}
