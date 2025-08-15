package com.nequi.franchises.infrastructure.persistence.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nequi.franchises.application.dto.MaxStockProductDto;
import com.nequi.franchises.infrastructure.persistence.entity.BranchProductEntity;

@Repository
public interface JpaBranchProductRepository extends JpaRepository<BranchProductEntity, Long> {
    
    @Query("""
        SELECT new com.nequi.franchises.application.dto.MaxStockProductDto(
            b.name,
            p.name,
            bp.stock
        )
        FROM BranchProductEntity bp
        INNER JOIN BranchEntity b ON bp.branchId = b.id
        INNER JOIN ProductEntity p ON bp.productId = p.id
        WHERE b.franchiseId = :franchiseId
        AND bp.stock = (
            SELECT MAX(bp2.stock)
            FROM BranchProductEntity bp2
            WHERE bp2.branchId = bp.branchId
        )
    """)
    List<MaxStockProductDto> findMaxStockProductsByFranchise(@Param("franchiseId") Long franchiseId);
}
