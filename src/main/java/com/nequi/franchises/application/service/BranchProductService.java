package com.nequi.franchises.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nequi.franchises.application.dto.BranchProductDto;
import com.nequi.franchises.domain.service.BranchProductDomainService;

@Service
public class BranchProductService {

    private final BranchProductDomainService branchProductDomainService;

    public BranchProductService(BranchProductDomainService branchProductDomainService) {
        this.branchProductDomainService = branchProductDomainService;
    }

    public BranchProductDto createBranchProduct(BranchProductDto request) {
        return branchProductDomainService.createBranchProduct(request);
    }

    public List<BranchProductDto> getAllBranchProducts() {
        return branchProductDomainService.getAllBranchProducts();
    }

    
}
