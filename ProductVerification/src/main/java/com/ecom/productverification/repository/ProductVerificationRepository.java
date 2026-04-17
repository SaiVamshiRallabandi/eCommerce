package com.ecom.productverification.repository;

import com.ecom.productverification.model.Product;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface ProductVerificationRepository extends JpaRepository<Product,Long> {

    @Modifying
   // @Transactional(isolation=Isolation.SERIALIZABLE)
    @Query("UPDATE Product p SET p.isVerified = :isVerified WHERE p.id = :id")
    int updateIsVerified(@Param("id") Long id,
                    @Param("isVerified") Boolean isVerified);

    @Modifying
    //@Transactional
    @Query("UPDATE Product p SET p.isVerified = :isVerified WHERE p.title = :title")
    int updateIsVerified(@Param("title") String title,
                    @Param("isVerified") Boolean isVerified);
}
