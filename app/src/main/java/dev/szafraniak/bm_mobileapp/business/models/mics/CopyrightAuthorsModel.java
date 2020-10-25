package dev.szafraniak.bm_mobileapp.business.models.mics;

import lombok.Data;

@Data
public class CopyrightAuthorsModel {
    public CopyrightAuthorsModel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    private String name;
    private String url;
}
