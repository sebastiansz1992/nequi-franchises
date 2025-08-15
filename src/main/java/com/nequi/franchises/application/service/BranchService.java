package com.nequi.franchises.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nequi.franchises.application.dto.BranchDto;
import com.nequi.franchises.domain.service.BranchDomainService;

@Service
public class BranchService {

    private final BranchDomainService branchDomainService;

    public BranchService(BranchDomainService branchDomainService) {
        this.branchDomainService = branchDomainService;
    }

    public BranchDto createBranch(BranchDto branch) {
        return branchDomainService.createBranch(branch);
    }

    public BranchDto getBranch(String id) {
        return branchDomainService.getBranch(id);
    }

    public List<BranchDto> getAllBranches() {
        return branchDomainService.getAllBranches();
    }

    public void updateBranch(String id, BranchDto branch) {
        branchDomainService.updateBranch(id, branch);
    }

    public void deleteBranch(String id) {
        branchDomainService.deleteBranch(id);
    }

    
    
}
