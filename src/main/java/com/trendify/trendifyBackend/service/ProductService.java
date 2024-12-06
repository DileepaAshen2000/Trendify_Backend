package com.trendify.trendifyBackend.service;

import com.trendify.trendifyBackend.dto.ProductDto;
import com.trendify.trendifyBackend.model.Product;

import java.util.List;
import java.util.UUID;


public interface ProductService {

     public Product addProduct(ProductDto product);
     public List<ProductDto> getAllProducts(UUID categoryId, UUID typeId,String typeName);




     ProductDto getProductBySlug(String slug);

     ProductDto getProductById(UUID id);

     Product updateProduct(ProductDto productDto, UUID id);

     Product fetchProductById(UUID uuid) throws Exception;

     public List<ProductDto> searchProducts(String keyword);
     public List<ProductDto> newlyArrived();
}