package com.trendify.trendifyBackend.service.implementation;


import com.trendify.trendifyBackend.exceptions.ResourceNotFoundEx;
import com.trendify.trendifyBackend.dto.ProductDto;
import com.trendify.trendifyBackend.mapper.ProductMapper;
import com.trendify.trendifyBackend.model.Product;
import com.trendify.trendifyBackend.repository.ProductRepository;
import com.trendify.trendifyBackend.service.ProductService;
import com.trendify.trendifyBackend.specification.ProductSpecification;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product addProduct(ProductDto productDto) {
        Product product = productMapper.mapToProductEntity(productDto);
        return productRepository.save(product);
    }

    @Override
//<<<<<<< HEAD
    public List<ProductDto> getAllProducts(UUID categoryId, UUID typeId,String typeName) {
//=======
//    public List<ProductDto> getAllProducts(UUID categoryId, UUID categoryTypeId) {
//>>>>>>> main

        Specification<Product> productSpecification = Specification.where(null);

        if (null != categoryId) {
            productSpecification = productSpecification.and(ProductSpecification.hasCategoryId(categoryId));
        }
        //todo : change categoryTypeId to typeId for resolve conflict
//        if (null != categoryTypeId) {
//            productSpecification = productSpecification.and(ProductSpecification.hasCategoryTypeId(categoryTypeId));
//        }
        if (null != typeId) {
            productSpecification = productSpecification.and(ProductSpecification.hasCategoryTypeId(typeId));
        }
        if (null != typeName) {
            productSpecification = productSpecification.and(ProductSpecification.hasCategoryTypeName(typeName));
        }

        List<Product> products = productRepository.findAll(productSpecification);
        return productMapper.getProductDtos(products);
    }




    @Override
    public ProductDto getProductBySlug(String slug) {
        Product product = productRepository.findBySlug(slug);
        if (null == product) {
            throw new ResourceNotFoundEx("Product Not Found!");
        }
        ProductDto productDto = productMapper.mapProductToDto(product);
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setCategoryTypeId(product.getCategoryType().getId());
        productDto.setVariants(productMapper.mapProductVariantListToDto(product.getProductVariants()));

        productDto.setProductResources(productMapper.mapProductResourcesListDto(product.getResources()));

        return productMapper.mapProductToDto(product);
    }

    @Override
    public ProductDto getProductById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundEx("Product Not Found!"));
        ProductDto productDto = productMapper.mapProductToDto(product);
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setCategoryTypeId(product.getCategoryType().getId());
        productDto.setVariants(productMapper.mapProductVariantListToDto(product.getProductVariants()));
        System.out.println("product - " + product.getCategoryType().getId());
        System.out.println(("Product dto - " + productDto.getCategoryTypeId()));
        //productDto.setProductResources(productMapper.mapProductResourcesListDto(product.getResources()));
        return productMapper.mapProductToDto(product);
    }

    @Override
    public Product updateProduct(ProductDto productDto, UUID id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundEx("Product Not Found!"));
        productDto.setId(product.getId());
        return productRepository.save(productMapper.mapToProductEntity(productDto));
    }

    @Override
    public Product fetchProductById(UUID id) throws Exception {
        return productRepository.findById(id).orElseThrow(BadRequestException::new);
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return productRepository.searchProducts(keyword);
    }

    @Override
    public List<ProductDto> newlyArrived() {
         List<Product> products=productRepository.newArrivals();
        return productMapper.getProductDtos(products);
    }

}
