package com.nequi.franchises.infrastructure.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nequi.franchises.application.dto.BranchProductDto;
import com.nequi.franchises.application.service.BranchProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/branch-product")
@RequiredArgsConstructor
public class BranchProductController {

    private final BranchProductService branchProductService;

    @PostMapping
    public ResponseEntity<BranchProductDto> createBranchProduct(@RequestBody BranchProductDto request) {
        return ResponseEntity.ok(branchProductService.createBranchProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<BranchProductDto>> getAllBranchProducts() {
        return ResponseEntity.ok(branchProductService.getAllBranchProducts());
    }
    
}
