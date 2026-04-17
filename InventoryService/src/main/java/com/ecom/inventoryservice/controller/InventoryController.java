package com.ecom.inventoryservice.controller;

import com.ecom.inventoryservice.Exception.InventoryNotAvailableException;
import com.ecom.inventoryservice.dto.*;
import com.ecom.inventoryservice.dto.ResponseStatus;
import com.ecom.inventoryservice.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Inventory")
public class InventoryController {
    InventoryService service;

    public InventoryController(InventoryService service){
        this.service=service;
    }

    @GetMapping("/getInventory")
    public ResponseEntity<GetInventoryResponseDto> getInventory(@RequestParam Long prodId) throws InventoryNotAvailableException {
        GetInventoryResponseDto responseDto=service.getInventoryByProductId(prodId);
        if(responseDto.getProductId()!=null){
            responseDto.setStatus(ResponseStatus.SUCCESS);
        }
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/addInventory")
    public ResponseEntity<AddInventoryResDto> addInventory(@RequestBody AddInventoryReqDto reqDto){
       AddInventoryResDto resDto= service.addInventory(reqDto);
    return ResponseEntity.ok().body(resDto);
    }
}
