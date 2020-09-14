package dev.szafraniak.bm_mobileapp.business.models.entity.warehouse;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import lombok.Data;

@Data
public class UpdateWarehouseRequest {

    private String name;

    private Address address;

}
