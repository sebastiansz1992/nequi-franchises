package com.nequi.franchises.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nequi.franchises.application.dto.BranchDto;
import com.nequi.franchises.domain.model.BranchModel;
import com.nequi.franchises.domain.repository.implementation.BranchRepositoryImpl;

@Service
public class BranchService {

    private final BranchRepositoryImpl branchRepository;

    public BranchService(BranchRepositoryImpl branchRepository) {
        this.branchRepository = branchRepository;
    }

    public BranchDto createBranch(BranchDto branch) {
        BranchModel branchModel = new BranchModel();
        branchModel.setName(branch.getName());
        branchModel.setAddress(branch.getAddress());
        branchModel.setAddress(branch.getAddress());       

        branchRepository.save(branchModel);
        
        return branch;
    }

    public BranchDto getBranch(String id) {
        BranchModel branchModel = branchRepository.findById(id);
        if (branchModel != null) {
            BranchDto branchDto = new BranchDto();
            branchDto.setId(branchModel.getId());
            branchDto.setName(branchModel.getName());
            branchDto.setAddress(branchModel.getAddress());
            return branchDto;
        }
        return null;
    }

    public List<BranchDto> getAllBranches() {

        return branchRepository.findAll()
            .stream()
            .map(branchModel -> {
                BranchDto branchDto = new BranchDto();
                branchDto.setId(branchModel.getId());
                branchDto.setName(branchModel.getName());
                branchDto.setAddress(branchModel.getAddress());
                return branchDto;
            })
            .toList();
    }

    public void updateBranch(String id, BranchDto branch) {
        BranchModel branchModel = branchRepository.findById(id);
        if (branchModel != null) {
            branchModel.setName(branch.getName());
            branchModel.setAddress(branch.getAddress());
            branchRepository.save(branchModel);
        }
    }

    public void deleteBranch(String id) {
        branchRepository.deleteById(id);
    }
}
