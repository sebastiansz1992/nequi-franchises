package com.nequi.franchises.domain.model;

@lombok.Data
public class BranchProductModel {
    private Long id;
    private Long branchId;
    private Long productId;
    private Long stock;
    private Double price;    
}
