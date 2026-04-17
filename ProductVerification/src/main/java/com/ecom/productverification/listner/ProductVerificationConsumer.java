package com.ecom.productverification.listner;

import com.ecom.productverification.model.Product;
import com.ecom.productverification.service.ProductVerificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.json.JsonParseException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class ProductVerificationConsumer {

    ObjectMapper objectMapper;
    ProductVerificationService service;

    public ProductVerificationConsumer(ObjectMapper objectMapper,ProductVerificationService service){
        this.objectMapper=objectMapper;
        this.service=service;
    }
    @KafkaListener(
            topics = "PC_PRODUCTVERIFICATION",
            groupId = "PC_PV_GROUP",
            concurrency = "2"
    )
    public void verifyProduct(String message){
        try {
            Product product = objectMapper.readValue(message, Product.class);
            service.verifyProduct(product);
        }catch(JsonProcessingException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
