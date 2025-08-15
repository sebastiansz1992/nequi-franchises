package com.nequi.franchises.domain.repository;

import java.util.List;

import com.nequi.franchises.domain.model.BranchProductModel;

public interface BranchProductRepository {
    BranchProductModel findById(Long id);
    List<BranchProductModel> findAll();
    void save(BranchProductModel branchProduct);
    void deleteById(Long id);
}
