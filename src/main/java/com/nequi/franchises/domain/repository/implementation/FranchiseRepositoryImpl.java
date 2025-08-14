package com.nequi.franchises.domain.repository.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nequi.franchises.domain.model.FranchiseModel;
import com.nequi.franchises.domain.repository.FranchiseRepository;
import com.nequi.franchises.infrastructure.persistence.entity.FranchiseEntity;
import com.nequi.franchises.infrastructure.persistence.jpa.JpaFranchiseRepository;

@Repository
public class FranchiseRepositoryImpl implements FranchiseRepository {

    private final JpaFranchiseRepository jpaFranchiseRepository;

    public FranchiseRepositoryImpl(JpaFranchiseRepository jpaFranchiseRepository) {
        this.jpaFranchiseRepository = jpaFranchiseRepository;
    }

    @Override
    public FranchiseModel findById(String id) {
        return jpaFranchiseRepository.findById(Long.valueOf(id))
            .map(entity -> {
                FranchiseModel franchise = new FranchiseModel();
                franchise.setId(entity.getId());
                franchise.setName(entity.getName());
                return franchise;
            })
            .orElse(null); 
    }

    @Override
    public List<FranchiseModel> findAll() {
        return jpaFranchiseRepository.findAll()
            .stream()
            .map(entity -> {
                FranchiseModel franchise = new FranchiseModel();
                franchise.setId(entity.getId());
                franchise.setName(entity.getName());
                return franchise;
            })
            .toList();
    }

    @Override
    public FranchiseModel save(FranchiseModel franchise) {
        FranchiseEntity entity = toEntity(franchise);
        entity = jpaFranchiseRepository.save(entity);
        franchise.setId(entity.getId());
        return franchise;
    }

    @Override
    public void deleteById(String id) {
        jpaFranchiseRepository.deleteById(Long.valueOf(id));
    }

    private FranchiseEntity toEntity(FranchiseModel model) {
        FranchiseEntity entity = new FranchiseEntity();
        entity.setName(model.getName());
        return entity;
    }

}
