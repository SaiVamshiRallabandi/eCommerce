package com.ecom.productverification.dto;

import com.ecom.productverification.model.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class SearchProductsResponseDto extends BaseResponseDto{
    private Page<Product> productsList;

}
