package com.ecom.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ExceptionDto {
    private String errorCode;
    private String errorDescription;
}
