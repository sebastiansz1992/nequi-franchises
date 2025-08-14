package com.nequi.franchises.infrastructure.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nequi.franchises.application.dto.FranchiseDto;
import com.nequi.franchises.application.service.FranchiseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/franchise")
@RequiredArgsConstructor
public class FranchiseController {

    private final FranchiseService franchiseService;

    @PostMapping
    public ResponseEntity<FranchiseDto> createFranchise(@RequestBody FranchiseDto request) {
        return ResponseEntity.ok(franchiseService.createFranchise(request));
    }

    @GetMapping
    public ResponseEntity<List<FranchiseDto>> getAllFranchises() {
        return ResponseEntity.ok(franchiseService.getAllFranchises());
    }
    
}
