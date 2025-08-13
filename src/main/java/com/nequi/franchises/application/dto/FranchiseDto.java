package com.nequi.franchises.application.dto;

import java.util.List;

@lombok.Data
public class FranchiseDto {
    private Long id;
    private String name;
    private List<BranchDto> branches;
}
