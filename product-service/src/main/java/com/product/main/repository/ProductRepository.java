package com.product.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.main.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
	
	Optional<Product> findByProductId(Long id);
	Optional<Product> findByProductCode(String productCode);

}
