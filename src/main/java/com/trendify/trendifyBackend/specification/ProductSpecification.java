package com.trendify.trendifyBackend.specification;

import com.trendify.trendifyBackend.model.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class ProductSpecification {

    public static Specification<Product> hasCategoryId(UUID categorId){
        return  (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("category").get("id"),categorId);
    }

    public static Specification<Product> hasCategoryTypeId(UUID categoryTypeId){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("categoryType").get("id"),categoryTypeId);
    }
}