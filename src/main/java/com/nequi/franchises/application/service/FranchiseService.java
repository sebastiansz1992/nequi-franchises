package com.nequi.franchises.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nequi.franchises.application.dto.FranchiseDto;
import com.nequi.franchises.domain.service.FranchiseDomainService;

@Service
public class FranchiseService {

    private final FranchiseDomainService franchiseDomainService;

    public FranchiseService(FranchiseDomainService franchiseDomainService) {
        this.franchiseDomainService = franchiseDomainService;
    }

    public FranchiseDto createFranchise(FranchiseDto franchise) {
        return franchiseDomainService.createFranchise(franchise);
    }

    public FranchiseDto getFranchiseById(String id) {
        return franchiseDomainService.getFranchiseById(id);
    }

    public List<FranchiseDto> getAllFranchises() {
        return franchiseDomainService.getAllFranchises();
    }

    public FranchiseDto updateFranchise(String id, FranchiseDto franchise) {
        return franchiseDomainService.updateFranchise(id, franchise);
    }

    public void deleteFranchise(String id) {
        franchiseDomainService.deleteFranchise(id);
    }

}
