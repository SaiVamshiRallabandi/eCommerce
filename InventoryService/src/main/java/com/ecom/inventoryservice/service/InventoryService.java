package com.ecom.inventoryservice.service;

import com.ecom.inventoryservice.Exception.InventoryNotAvailableException;
import com.ecom.inventoryservice.dto.AddInventoryReqDto;
import com.ecom.inventoryservice.dto.AddInventoryResDto;
import com.ecom.inventoryservice.dto.GetInventoryResponseDto;
import com.ecom.inventoryservice.model.Inventory;
import com.ecom.inventoryservice.model.Product;
import com.ecom.inventoryservice.repository.InventoryRepository;
import com.ecom.inventoryservice.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    InventoryRepository repo;
    ProductRepository prodRepo;

    public InventoryService(InventoryRepository repo,ProductRepository prodRepo){
        this.repo=repo;
        this.prodRepo=prodRepo;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public GetInventoryResponseDto getInventoryByProductId(Long prodId) throws InventoryNotAvailableException {
       List<Inventory> inventory= repo.findByProduct_Id(prodId);
       if(!inventory.isEmpty())
           return toGetInventoryResponse(inventory.get(0));
       else {
           throw new InventoryNotAvailableException("Inventory Not Available");
       }
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public AddInventoryResDto addInventory(AddInventoryReqDto reqDto){
        Inventory i=new Inventory();

        List<Inventory> inventory=repo.findByProduct_Id(reqDto.getProductId());
    if(!inventory.isEmpty()){
        i.setProduct(inventory.get(0).getProduct());
        i.setQuantity(inventory.get(0).getQuantity()+reqDto.getQuantity());
    }else{
       Product prod=prodRepo.getProductsById(reqDto.getProductId());
       i.setProduct(prod);
       i.setQuantity(reqDto.getQuantity());
    }
    i=repo.save(i);
    return toAddInventoryResponse(i);
    }

    public GetInventoryResponseDto toGetInventoryResponse (Inventory inventory){
        GetInventoryResponseDto resDto=new GetInventoryResponseDto();
        resDto.setProductId(inventory.getId());
        resDto.setQuantity(inventory.getQuantity());
        return resDto;
    }

    public AddInventoryResDto toAddInventoryResponse (Inventory inventory){
        AddInventoryResDto resDto=new AddInventoryResDto();
        resDto.setProdName(inventory.getProduct().getTitle());
        resDto.setQuantity(inventory.getQuantity());
        return resDto;
    }
}
