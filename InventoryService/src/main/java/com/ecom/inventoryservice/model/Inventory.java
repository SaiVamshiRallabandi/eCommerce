package com.ecom.inventoryservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Inventory extends BaseModel{
    @OneToOne
    Product product ;
    Integer quantity;
}
