package com.product.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.main.dto.ProductRequest;
import com.product.main.dto.ProductResponse;
import com.product.main.entity.Product;
import com.product.main.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Product Service", description = "Operations related to telecom products")
@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	private final ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
		logger.info("Calling Product by Id");
		ProductResponse response = productService.getProductbyId(id);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/code/{productCode}")
	public ResponseEntity<ProductResponse> findByProductCode(@PathVariable String productCode) {
		logger.info("Calling Product by Code");
		ProductResponse response = productService.findByProductCode(productCode);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		logger.info("Getting All Products");
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	@Operation(summary = "Create Product", description = "Creates a new telecom product")
	@PostMapping("/add")
	public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request) {
		logger.info("Request Body : {}", request);
		logger.info("Creating Product : {}", request.getProductCode());
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(request));
	}
}
