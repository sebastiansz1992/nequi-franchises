package com.nequi.franchises.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nequi.franchises.application.dto.ProductDto;
import com.nequi.franchises.domain.model.ProductModel;
import com.nequi.franchises.infrastructure.persistence.jpa.implementation.ProductRepositoryImpl;

@Service
public class ProductDomainService {
    
    private final ProductRepositoryImpl productRepositoryImpl;

    public ProductDomainService(ProductRepositoryImpl productRepository) {
        this.productRepositoryImpl = productRepository;
    }

    public ProductDto createProduct(ProductDto product) {
        ProductModel productModel = new ProductModel();
        productModel.setName(product.getName());
        productModel.setDescription(product.getDescription());
        productModel = productRepositoryImpl.save(productModel);
        product.setId(productModel.getId());
        return product;
    }

    public ProductDto getProductById(String id) {
        ProductModel productModel = productRepositoryImpl.findById(id);
        if (productModel != null) {
            ProductDto productDto = new ProductDto();
            productDto.setId(productModel.getId());
            productDto.setName(productModel.getName());
            productDto.setDescription(productModel.getDescription());
            return productDto;
        }
        return null;
    }

    public List<ProductDto> getAllProducts() {
        List<ProductModel> productModels = productRepositoryImpl.findAll();
        return productModels.stream().map(productModel -> {
            ProductDto productDto = new ProductDto();
            productDto.setId(productModel.getId());
            productDto.setName(productModel.getName());
            productDto.setDescription(productModel.getDescription());
            return productDto;
        }).toList();
    }

    public void deleteProductById(String id) {
        productRepositoryImpl.deleteById(id);
    }
    
}
