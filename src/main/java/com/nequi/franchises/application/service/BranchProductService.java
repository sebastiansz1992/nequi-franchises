package com.nequi.franchises.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nequi.franchises.application.dto.BranchProductDto;
import com.nequi.franchises.application.dto.MaxStockProductDto;
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

    public BranchProductDto getBranchProductById(Long id) {
        return branchProductDomainService.getBranchProduct(id);
    }

    public void deleteBranchProduct(Long id) {
        branchProductDomainService.deleteBranchProduct(id);
    }

    public BranchProductDto updateBranchProduct(Long id, Long stock) {
        return branchProductDomainService.updateBranchProduct(id, stock);
    }

    public List<MaxStockProductDto> findMaxStockProductsByFranchise(Long franchiseId) {
        return branchProductDomainService.findMaxStockProductsByFranchise(franchiseId);
    }

}
