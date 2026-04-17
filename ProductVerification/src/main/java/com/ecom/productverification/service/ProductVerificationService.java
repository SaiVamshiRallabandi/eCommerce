package com.ecom.productverification.service;

import com.ecom.productverification.model.Product;
import com.ecom.productverification.repository.ProductVerificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductVerificationService {
    private ProductVerificationRepository verificationRepository;
    public ProductVerificationService(ProductVerificationRepository verificationRepository){
        this.verificationRepository=verificationRepository;
    }


    @Transactional(isolation= Isolation.SERIALIZABLE)
    public void verifyProduct(Product product){
        if(product.getId()!=null){
            verificationRepository.updateIsVerified(product.getId(), true);
        }else{
            verificationRepository.updateIsVerified(product.getTitle(), true);
        }
    }
}
