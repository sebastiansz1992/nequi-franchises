package com.nequi.franchises.domain.repository;

import java.util.List;

import com.nequi.franchises.domain.model.FranchiseModel;

public interface FranchiseRepository {
    FranchiseModel findById(String id);
    List<FranchiseModel> findAll();
    FranchiseModel save(FranchiseModel franchise);
    void deleteById(String id);
} 
