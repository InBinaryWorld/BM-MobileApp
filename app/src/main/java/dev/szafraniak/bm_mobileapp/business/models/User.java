package dev.szafraniak.bm_mobileapp.business.models;

import java.util.List;

import lombok.Data;

@Data
public class User {

    private Long id;

    private List<IdNameEntity> companies;
}
