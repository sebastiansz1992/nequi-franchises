package com.nequi.franchises.domain.model;

import java.util.List;

import com.nequi.franchises.application.dto.ProductDto;

@lombok.Data
public class BranchModel {
    private Long id;
    private String name;
    private String address;
    private List<ProductDto> products;
}
