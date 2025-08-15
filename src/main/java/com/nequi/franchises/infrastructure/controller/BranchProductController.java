package com.nequi.franchises.infrastructure.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nequi.franchises.application.dto.BranchProductDto;
import com.nequi.franchises.application.dto.MaxStockProductDto;
import com.nequi.franchises.application.service.BranchProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/branch-product")
@RequiredArgsConstructor
public class BranchProductController {

    private final BranchProductService branchProductService;

    @PostMapping
    public ResponseEntity<BranchProductDto> createBranchProduct(@RequestBody BranchProductDto request) {
        return ResponseEntity.ok(branchProductService.createBranchProduct(request));
    }

    @GetMapping()
    public ResponseEntity<List<BranchProductDto>> getAllBranchProducts() {
        return ResponseEntity.ok(branchProductService.getAllBranchProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchProductDto> getBranchProductById(@PathVariable("id") String id) {
        return ResponseEntity.ok(branchProductService.getBranchProductById(Long.valueOf(id)));
    }

    @GetMapping("/max-stock/{franchiseId}")
    public ResponseEntity<List<MaxStockProductDto>> findMaxStockProductsByFranchise(@PathVariable("franchiseId") Long franchiseId) {
        return ResponseEntity.ok(branchProductService.findMaxStockProductsByFranchise(franchiseId));
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranchProduct(@PathVariable("id") String id) {
        branchProductService.deleteBranchProduct(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/{stock}")
    public ResponseEntity<BranchProductDto> updateBranchProduct(@PathVariable("id") String id, @PathVariable("stock") Long stock) {
        return ResponseEntity.ok(branchProductService.updateBranchProduct(Long.valueOf(id), stock));
    }

}
