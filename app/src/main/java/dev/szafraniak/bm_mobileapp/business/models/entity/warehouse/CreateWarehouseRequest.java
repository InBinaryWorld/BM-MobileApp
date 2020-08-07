package dev.szafraniak.bm_mobileapp.business.models.entity.warehouse;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.CreateAddressRequest;
import lombok.Data;

@Data
public class CreateWarehouseRequest {

    private String name;

    private CreateAddressRequest address;

}
