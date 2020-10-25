package dev.szafraniak.bm_mobileapp.business.models.entity.user;

import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.mics.IdNameEntity;
import lombok.Data;

@Data
public class User {

    private Long id;

    private List<IdNameEntity> companies;
}
