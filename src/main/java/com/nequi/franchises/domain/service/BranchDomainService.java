package com.nequi.franchises.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nequi.franchises.application.dto.BranchDto;
import com.nequi.franchises.domain.model.BranchModel;
import com.nequi.franchises.infrastructure.persistence.jpa.implementation.BranchRepositoryImpl;

@Service
public class BranchDomainService {

    private final BranchRepositoryImpl branchRepository;

    public BranchDomainService(BranchRepositoryImpl branchRepository) {
        this.branchRepository = branchRepository;
    }

    public BranchDto createBranch(BranchDto branch) {
        BranchModel branchModel = new BranchModel();
        branchModel.setName(branch.getName());
        branchModel.setLocation(branch.getLocation());
        branchModel.setFranchiseId(branch.getFranchiseId());

        branchModel = branchRepository.save(branchModel);

        branch.setId(branchModel.getId());

        return branch;
    }

    public BranchDto getBranch(String id) {
        BranchModel branchModel = branchRepository.findById(id);
        if (branchModel != null) {
            BranchDto branchDto = new BranchDto();
            branchDto.setId(branchModel.getId());
            branchDto.setFranchiseId(branchModel.getFranchiseId());
            branchDto.setName(branchModel.getName());
            branchDto.setLocation(branchModel.getLocation());
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
                branchDto.setFranchiseId(branchModel.getFranchiseId());
                branchDto.setName(branchModel.getName());
                branchDto.setLocation(branchModel.getLocation());
                return branchDto;
            })
            .toList();
    }

    public BranchDto updateBranch(String id, String name) {
        BranchModel branchModel = branchRepository.findById(id);
        if (branchModel != null) {
            branchModel.setName(name);
            branchRepository.save(branchModel);
            return toDto(branchModel);
        }
        return null;
    }

    public void deleteBranch(String id) {
        branchRepository.deleteById(id);
    }

    private BranchDto toDto(BranchModel branchModel) {
        if (branchModel == null) {
            return null;
        }
        BranchDto branchDto = new BranchDto();
        branchDto.setId(branchModel.getId());
        branchDto.setFranchiseId(branchModel.getFranchiseId());
        branchDto.setName(branchModel.getName());
        branchDto.setLocation(branchModel.getLocation());
        return branchDto;
    }

}
