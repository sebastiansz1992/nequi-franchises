package com.nequi.franchises.application.dto;

import java.util.List;

@lombok.Data
public class BranchDto {
    private Long id;
    private String name;
    private String address;
    private List<ProductDto> products;
}
