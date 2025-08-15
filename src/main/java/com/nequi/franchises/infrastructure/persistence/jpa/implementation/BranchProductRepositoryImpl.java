package com.nequi.franchises.infrastructure.persistence.jpa.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nequi.franchises.domain.model.BranchProductModel;
import com.nequi.franchises.domain.repository.BranchProductRepository;
import com.nequi.franchises.infrastructure.persistence.entity.BranchProductEntity;
import com.nequi.franchises.infrastructure.persistence.jpa.JpaBranchProductRepository;

@Repository
public class BranchProductRepositoryImpl implements BranchProductRepository {

    private final JpaBranchProductRepository jpaBranchProductRepository;

    public BranchProductRepositoryImpl(JpaBranchProductRepository jpaBranchProductRepository) {
        this.jpaBranchProductRepository = jpaBranchProductRepository;
    }

    @Override
    public BranchProductModel findById(Long id) {
        return jpaBranchProductRepository.findById(id)
                .map(this::mapToModel)
                .orElse(null);
    }

    @Override
    public List<BranchProductModel> findAll() {
        return jpaBranchProductRepository.findAll()
                .stream()
                .map(this::mapToModel)
                .toList();
    }

    @Override
    public void save(BranchProductModel branchProduct) {
        BranchProductEntity entity = mapToEntity(branchProduct);
        jpaBranchProductRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        jpaBranchProductRepository.deleteById(id);
    }

    private BranchProductModel mapToModel(BranchProductEntity entity) {
        BranchProductModel model = new BranchProductModel();
        model.setId(entity.getId());
        model.setBranchId(entity.getBranchId());
        model.setProductId(entity.getProductId());
        model.setStock(entity.getStock());
        model.setPrice(entity.getPrice());
        return model;
    }

    private BranchProductEntity mapToEntity(BranchProductModel model) {
        BranchProductEntity entity = new BranchProductEntity();
        entity.setId(model.getId());
        entity.setBranchId(model.getBranchId());
        entity.setProductId(model.getProductId());
        entity.setStock(model.getStock());
        entity.setPrice(model.getPrice());
        return entity;
    }

}
