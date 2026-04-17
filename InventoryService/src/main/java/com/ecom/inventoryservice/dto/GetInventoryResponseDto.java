package com.ecom.inventoryservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class GetInventoryResponseDto extends BaseResponseDto{
    Long productId;
    Integer quantity;
}
