package com.nequi.franchises.infrastructure.persistence.jpa.implementation;

import java.util.List;

import com.nequi.franchises.domain.model.ProductModel;
import com.nequi.franchises.domain.repository.ProductRepository;

import com.nequi.franchises.infrastructure.persistence.entity.ProductEntity;
import com.nequi.franchises.infrastructure.persistence.jpa.JpaProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    public ProductRepositoryImpl(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public ProductModel save(ProductModel product) {
        ProductEntity productEntity = toEntity(product);
        jpaProductRepository.save(productEntity);
        return product;
    }

    @Override
    public ProductModel findById(String id) {
        return jpaProductRepository.findById(Long.valueOf(id))
                .map(this::toModel)
                .orElse(null);
    }

    @Override
    public List<ProductModel> findAll() {
        return jpaProductRepository.findAll().stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public void deleteById(String id) {
        jpaProductRepository.deleteById(Long.valueOf(id));
    }   

    private ProductModel toModel(ProductEntity entity) {
        ProductModel model = new ProductModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setPrice(entity.getPrice());
        return model;
    }

    private ProductEntity toEntity(ProductModel model) {
        ProductEntity entity = new ProductEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setPrice(model.getPrice());
        return entity;
    }

}
