package com.ecom.inventoryservice.dto;

import com.ecom.inventoryservice.model.Product;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class AddInventoryReqDto {

    private long productId;
    private int quantity;

}
