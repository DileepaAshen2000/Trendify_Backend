package com.trendify.trendifyBackend.controller;

import com.trendify.trendifyBackend.dto.ProductDto;
import com.trendify.trendifyBackend.mapper.ProductMapper;
import com.trendify.trendifyBackend.model.Product;
import com.trendify.trendifyBackend.service.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(exposedHeaders = "Content-Range")
public class ProductController {

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping
//<<<<<<< HEAD
    public ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam(required = false,name = "categoryId",value = "categoryId") UUID categoryId,
                                                           @RequestParam(required = false,name = "typeId",value = "typeId") UUID typeId,
                                                           @RequestParam(required = false,name = "typeName",value = "typeName") String typeName,
                                                           @RequestParam(required = false) String slug, HttpServletResponse response){
//=======
//    public ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam(required = false, name = "categoryId",value = "categoryId") UUID categoryId, @RequestParam(required = false,name = "categoryTypeId",value = "categoryTypeId") UUID categoryTypeId, @RequestParam(required = false) String slug, HttpServletResponse response){
//>>>>>>> main
        List<ProductDto> productList = new ArrayList<>();
        if(StringUtils.isNotBlank(slug)){
            ProductDto productDto = productService.getProductBySlug(slug);
            productList.add(productDto);
        }
        else {
//<<<<<<< HEAD
            productList = productService.getAllProducts(categoryId, typeId,typeName);
//=======
//            productList = productService.getAllProducts(categoryId, categoryTypeId);
//>>>>>>> main
        }
        response.setHeader("Content-Range",String.valueOf(productList.size()));
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable UUID id){
        ProductDto productDto = productService.getProductById(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }



    //   create Product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
        Product product = productService.addProduct(productDto);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDto productDto,@PathVariable UUID id){
        Product product = productService.updateProduct(productDto,id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        List<Product> products = productService.searchProducts(keyword);
        return ResponseEntity.ok(products);
    }
    @GetMapping("/newlyArrived")
    public ResponseEntity<List<ProductDto>> newlyArrivedProducts() {
        List<ProductDto> products = productService.newlyArrived();
        return ResponseEntity.ok(products);
    }


}
