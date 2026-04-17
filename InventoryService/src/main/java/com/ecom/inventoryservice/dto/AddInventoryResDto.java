package com.ecom.inventoryservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddInventoryResDto extends BaseResponseDto{

  String prodName;
  Integer quantity;
}
