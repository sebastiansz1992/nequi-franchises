package com.nequi.franchises.application.dto;

@lombok.Data
public class BranchDto {
    private Long id;
    private String name;
    private Long franchiseId;
    private String location;
}
