package dev.szafraniak.bm_mobileapp.business.models.entity.warehouse;

import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import lombok.Data;

@Data
public class Warehouse {

    private Long id;

    private String name;

    private Address address;

    private List<Product> products;

}
