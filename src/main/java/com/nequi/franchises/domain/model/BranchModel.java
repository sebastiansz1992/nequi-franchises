package com.nequi.franchises.domain.model;

@lombok.Data
public class BranchModel {
    private Long id;
    private String name;
    private Long franchiseId;
    private String location;
}
