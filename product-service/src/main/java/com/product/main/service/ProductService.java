package com.product.main.service;

import java.util.List;

import com.product.main.dto.ProductRequest;
import com.product.main.dto.ProductResponse;
import com.product.main.entity.Product;

public interface ProductService {

	
	 ProductResponse getProductbyId(Long productId);
	 List<Product> getAllProducts();
	 ProductResponse findByProductCode(String productCode);
	 ProductResponse createProduct(ProductRequest request);
	
}
