package com.nequi.franchises.domain.repository;

import java.util.List;

import com.nequi.franchises.domain.model.ProductModel;

public interface ProductRepository {
    ProductModel findById(String id);
    List<ProductModel> findAll();
    ProductModel save(ProductModel product);
    void deleteById(String id);
}
