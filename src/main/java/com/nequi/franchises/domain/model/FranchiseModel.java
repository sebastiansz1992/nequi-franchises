package com.nequi.franchises.domain.model;

import java.util.List;

import com.nequi.franchises.application.dto.BranchDto;

@lombok.Data
public class FranchiseModel {
    private Long id;
    private String name;
    private List<BranchDto> branches;
}
