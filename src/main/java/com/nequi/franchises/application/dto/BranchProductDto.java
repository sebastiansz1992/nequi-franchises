package com.nequi.franchises.application.dto;

@lombok.Data
public class BranchProductDto {
    private Long id;
    private Long branchId;
    private Long productId;
    private Long stock;
    private Double price;
}
