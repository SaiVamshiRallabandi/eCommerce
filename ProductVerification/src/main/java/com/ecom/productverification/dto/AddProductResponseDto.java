package com.ecom.productverification.dto;

import com.ecom.productverification.dto.BaseResponseDto;
import com.ecom.productverification.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductResponseDto extends BaseResponseDto {
    Product product;
}
