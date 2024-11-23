package com.trendify.trendifyBackend.mapper;

import com.trendify.trendifyBackend.dto.ProductDto;
import com.trendify.trendifyBackend.model.Category;
import com.trendify.trendifyBackend.model.CategoryType;
import com.trendify.trendifyBackend.model.Product;
import com.trendify.trendifyBackend.model.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProductMapper {

//    @Autowired
//    private CategoryService categoryService;

    public Product mapToProductEntity(ProductDto productDto){
        Product product = new Product();
        if(null != productDto.getId()){
            product.setId(productDto.getId());
        }
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setBrand(productDto.getBrand());
        product.setNewArrival(productDto.isNewArrival());
        product.setPrice(productDto.getPrice());
        product.setRating(productDto.getRating());
        product.setSlug(productDto.getSlug());

//        Category category = categoryService.getCategory(productDto.getCategoryId());
//        if(null != category){
//            product.setCategory(category);
//            UUID categoryTypeId = productDto.getCategoryTypeId();
//
//            CategoryType categoryType = category.getCategoryTypes().stream().filter(categoryType1 -> categoryType1.getId().equals(categoryTypeId)).findFirst().orElse(null);
//            product.setCategoryType(categoryType);
//        }

//        if(null != productDto.getVariants()){
//            product.setProductVariants(mapToProductVariant(productDto.getVariants(),product));
//        }
//
//        if(null != productDto.getProductResources()){
//            product.setResources(mapToProductResources(productDto.getProductResources(),product));
//        }



        return product;
    }





    public List<ProductDto> getProductDtos(List<Product> products) {
        return products.stream().map(this::mapProductToDto).toList();
    }

    public ProductDto mapProductToDto(Product product) {

        return ProductDto.builder()
                .id(product.getId())
                .brand(product.getBrand())
                .name(product.getName())
                .price(product.getPrice())
                .isNewArrival(product.isNewArrival())
                .rating(product.getRating())
                .description(product.getDescription())
                .slug(product.getSlug()).build();
               // .thumbnail(getProductThumbnail(product.getResources())).build();
    }

    private String getProductThumbnail(List<Resources> resources) {
        return resources.stream().filter(Resources::getIsPrimary).findFirst().orElse(null).getUrl();
    }






}
