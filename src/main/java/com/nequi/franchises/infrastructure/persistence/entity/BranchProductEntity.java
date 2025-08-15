package com.nequi.franchises.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@lombok.Data
@Entity
@Table(name = "branchproduct")
public class BranchProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long branchId;

    private Long productId;

    private Long stock;

    private Double price;
    
}
