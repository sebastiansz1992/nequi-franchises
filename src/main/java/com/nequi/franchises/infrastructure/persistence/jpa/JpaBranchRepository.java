package com.nequi.franchises.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nequi.franchises.infrastructure.persistence.entity.BranchEntity;

@Repository
public interface JpaBranchRepository extends JpaRepository<BranchEntity, String> {
    
}
