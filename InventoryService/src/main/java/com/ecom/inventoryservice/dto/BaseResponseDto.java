package com.ecom.inventoryservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class BaseResponseDto {
    private ResponseStatus status;
    private List<ExceptionDto> exceptions;
}
