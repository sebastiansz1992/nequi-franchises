package com.nequi.franchises.application.dto;

public class MaxStockProductDto {
    private String branchName;
    private String productName;
    private Long stock;

    public MaxStockProductDto(String branchName, String productName, Long stock) {
        this.branchName = branchName;
        this.productName = productName;
        this.stock = stock;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getProductName() {
        return productName;
    }

    public Long getStock() {
        return stock;
    }
}
