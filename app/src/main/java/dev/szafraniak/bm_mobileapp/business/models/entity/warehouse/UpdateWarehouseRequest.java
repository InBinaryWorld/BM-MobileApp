package dev.szafraniak.bm_mobileapp.business.models.entity.warehouse;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.UpdateAddressRequest;
import lombok.Data;

@Data
public class UpdateWarehouseRequest {

    private String name;

    private UpdateAddressRequest address;

}
