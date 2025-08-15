package com.nequi.franchises.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nequi.franchises.application.dto.BranchProductDto;
import com.nequi.franchises.application.dto.MaxStockProductDto;
import com.nequi.franchises.domain.model.BranchProductModel;
import com.nequi.franchises.infrastructure.persistence.jpa.implementation.BranchProductRepositoryImpl;

@Service
public class BranchProductDomainService {

    private BranchProductRepositoryImpl branchProductRepository;

    public BranchProductDomainService(BranchProductRepositoryImpl branchProductRepository) {
        this.branchProductRepository = branchProductRepository;
    }

    public BranchProductDto createBranchProduct(BranchProductDto branch) {
        BranchProductModel branchProductModel = new BranchProductModel();
        branchProductModel.setBranchId(branch.getBranchId());
        branchProductModel.setProductId(branch.getProductId());
        branchProductModel.setStock(branch.getStock());
        branchProductModel.setPrice(branch.getPrice());

        branchProductRepository.save(branchProductModel);

        return branch;
    }

    public BranchProductDto getBranchProduct(Long id) {
        BranchProductModel branchModel = branchProductRepository.findById(id);
        if (branchModel != null) {
            BranchProductDto branchDto = new BranchProductDto();
            branchDto.setId(branchModel.getId());
            branchDto.setBranchId(branchModel.getBranchId());
            branchDto.setProductId(branchModel.getProductId());
            branchDto.setStock(branchModel.getStock());
            branchDto.setPrice(branchModel.getPrice());
            return branchDto;
        }
        return null;
    }

    public List<BranchProductDto> getAllBranchProducts() {

        return branchProductRepository.findAll()
            .stream()
            .map(branchModel -> {
                BranchProductDto branchDto = new BranchProductDto();
                branchDto.setId(branchModel.getId());
                branchDto.setBranchId(branchModel.getBranchId());
                branchDto.setProductId(branchModel.getProductId());
                branchDto.setStock(branchModel.getStock());
                branchDto.setPrice(branchModel.getPrice());
                return branchDto;
            })
            .toList();
    }

    public BranchProductDto updateBranchProduct(Long id, Long stock) {
        BranchProductModel branchModel = branchProductRepository.findById(id);
        if (branchModel != null) {
            branchModel.setStock(stock);
            branchProductRepository.save(branchModel);
        }
        return convertToDto(branchModel);
    }

    public void deleteBranchProduct(Long id) {
        branchProductRepository.deleteById(id);
    }

    public List<MaxStockProductDto> findMaxStockProductsByFranchise(Long franchiseId) {
        return branchProductRepository.findMaxStockProductsByFranchise(franchiseId);
    }

    private BranchProductDto convertToDto(BranchProductModel branchModel) {
        BranchProductDto branchDto = new BranchProductDto();
        branchDto.setId(branchModel.getId());
        branchDto.setBranchId(branchModel.getBranchId());
        branchDto.setProductId(branchModel.getProductId());
        branchDto.setStock(branchModel.getStock());
        branchDto.setPrice(branchModel.getPrice());
        return branchDto;
    }

}
