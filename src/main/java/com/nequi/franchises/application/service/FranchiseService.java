package com.nequi.franchises.application.service;

import org.springframework.stereotype.Service;

import com.nequi.franchises.application.dto.FranchiseDto;
import com.nequi.franchises.domain.model.FranchiseModel;
import com.nequi.franchises.domain.repository.implementation.FranchiseRepositoryImpl;

@Service
public class FranchiseService {

    private final FranchiseRepositoryImpl franchiseRepository;

    public FranchiseService(FranchiseRepositoryImpl franchiseRepository) {
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
