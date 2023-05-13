package com.utkudogrusoz.stockcontrol.repository;

import com.utkudogrusoz.stockcontrol.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,String> {
    ProductEntity getByIdAndDeletedFalse(Long id);

    List<ProductEntity> getAllByDeletedFalse();
}
