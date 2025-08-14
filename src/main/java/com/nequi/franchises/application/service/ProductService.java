package com.nequi.franchises.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nequi.franchises.application.dto.ProductDto;
import com.nequi.franchises.domain.service.ProductDomainService;

@Service
public class ProductService {

    private final ProductDomainService productDomainService;

    public ProductService(ProductDomainService productDomainService) {
        this.productDomainService = productDomainService;
    }

    public ProductDto createProduct(ProductDto product) {
        return productDomainService.createProduct(product);
    } 

    public ProductDto getProductById(String id) {
        return productDomainService.getProductById(id);
    }

    public List<ProductDto> getAllProducts() {
        return productDomainService.getAllProducts();        
    }

    public void deleteProductById(String id) {
        productDomainService.deleteProductById(id);
    }

}
