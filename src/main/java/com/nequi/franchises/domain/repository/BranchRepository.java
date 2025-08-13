package com.nequi.franchises.domain.repository;

import java.util.List;

import com.nequi.franchises.domain.model.BranchModel;

public interface BranchRepository {
    BranchModel findById(String id);
    List<BranchModel> findAll();
    BranchModel save(BranchModel branch);
    void deleteById(String id);
}
