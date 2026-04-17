package com.ecom.inventoryservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date createdOn;
    private String maker;
    private String checker;
    @Enumerated(EnumType.STRING)
    private RecordState state;

}
