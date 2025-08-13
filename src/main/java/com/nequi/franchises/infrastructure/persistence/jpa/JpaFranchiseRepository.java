package com.nequi.franchises.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nequi.franchises.infrastructure.persistence.entity.FranchiseEntity;

@Repository
public interface JpaFranchiseRepository extends JpaRepository<FranchiseEntity, String> {

}
