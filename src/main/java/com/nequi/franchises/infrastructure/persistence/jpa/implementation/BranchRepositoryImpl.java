package com.nequi.franchises.infrastructure.persistence.jpa.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.nequi.franchises.domain.model.BranchModel;

import com.nequi.franchises.domain.repository.BranchRepository;
import com.nequi.franchises.infrastructure.persistence.entity.BranchEntity;
import com.nequi.franchises.infrastructure.persistence.jpa.JpaBranchRepository;

@Repository
public class BranchRepositoryImpl implements BranchRepository {

    private final JpaBranchRepository jpaBranchRepository;

    public BranchRepositoryImpl(JpaBranchRepository jpaBranchRepository) {
        this.jpaBranchRepository = jpaBranchRepository;
    }

    @Override
    public BranchModel findById(String id) {
        return jpaBranchRepository.findById(Long.valueOf(id))
            .map(branchModel -> {
                BranchModel branch = new BranchModel();
                branch.setId(branchModel.getId());
                branch.setName(branchModel.getName());
                branch.setLocation(branchModel.getLocation());
                return branch;
            })
            .orElse(null);
    }

    @Override
    public List<BranchModel> findAll() {
        return jpaBranchRepository.findAll()
            .stream()
            .map(branchModel -> {
                BranchModel branch = new BranchModel();
                branch.setId(branchModel.getId());
                branch.setFranchiseId(branchModel.getFranchiseId());
                branch.setName(branchModel.getName());
                branch.setLocation(branchModel.getLocation());
                return branch;
            })
            .toList();
    }

    @Override
    public BranchModel save(BranchModel branch) {
        BranchEntity entity = toEntity(branch);
        entity = jpaBranchRepository.save(entity);
        branch.setId(entity.getId());
        return branch;
    }

    @Override
    public void deleteById(String id) {
        jpaBranchRepository.deleteById(Long.valueOf(id));
    }

    private BranchEntity toEntity(BranchModel model) {
        BranchEntity entity = new BranchEntity();
        entity.setName(model.getName());
        entity.setFranchiseId(model.getFranchiseId());
        entity.setLocation(model.getLocation());
        return entity;
    }
}