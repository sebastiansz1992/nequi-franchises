package com.nequi.franchises.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nequi.franchises.application.dto.FranchiseDto;
import com.nequi.franchises.domain.model.FranchiseModel;
import com.nequi.franchises.infrastructure.persistence.jpa.implementation.FranchiseRepositoryImpl;

@Service
public class FranchiseDomainService {

    private final FranchiseRepositoryImpl franchiseRepository;

    public FranchiseDomainService(FranchiseRepositoryImpl franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    public FranchiseDto createFranchise(FranchiseDto franchise) {
        FranchiseModel franchiseModel = new FranchiseModel();
        franchiseModel.setName(franchise.getName());

        franchiseRepository.save(franchiseModel);
        
        return franchise;
    }

    public FranchiseDto getFranchiseById(String id) {
        FranchiseModel franchiseModel = franchiseRepository.findById(id);
        if (franchiseModel != null) {
            FranchiseDto franchiseDto = new FranchiseDto();
            franchiseDto.setId(franchiseModel.getId());
            franchiseDto.setName(franchiseModel.getName());
            return franchiseDto;
        }
        return null;
    }

    public List<FranchiseDto> getAllFranchises() {
        List<FranchiseModel> franchiseModels = franchiseRepository.findAll();
        return franchiseModels.stream().map(franchiseModel -> {
            FranchiseDto franchiseDto = new FranchiseDto();
            franchiseDto.setId(franchiseModel.getId());
            franchiseDto.setName(franchiseModel.getName());
            return franchiseDto;
        }).toList();
    }

    public FranchiseDto updateFranchise(String id, FranchiseDto franchise) {
        FranchiseModel franchiseModel = franchiseRepository.findById(id);
        if (franchiseModel != null) {
            franchiseModel.setName(franchise.getName());
            franchiseRepository.save(franchiseModel);
            return franchise;
        }
        return null;
    }

    public void deleteFranchise(String id) {
        franchiseRepository.deleteById(id);
    }
    
}
