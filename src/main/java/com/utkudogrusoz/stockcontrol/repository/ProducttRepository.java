package com.utkudogrusoz.stockcontrol.repository;

import com.utkudogrusoz.stockcontrol.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProducttRepository extends JpaRepository<Product, String> {
    List<Product> getAllByDeletedFalse();

}
