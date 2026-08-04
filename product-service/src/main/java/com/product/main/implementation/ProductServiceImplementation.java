package com.product.main.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.main.dto.ProductRequest;
import com.product.main.dto.ProductResponse;
import com.product.main.entity.Product;
import com.product.main.repository.ProductRepository;
import com.product.main.service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService {

	 private static final Logger logger =
	            LoggerFactory.getLogger(ProductServiceImplementation.class);

	 	@Autowired	
	    private final ProductRepository productRepository;

	    public ProductServiceImplementation(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }

	
	@Override
	public ProductResponse getProductbyId(Long productId) {
		
		logger.info("In Product Id");
		Optional<Product> product=productRepository.findByProductId(productId);
		return mapToResponse(product);
	}

	private ProductResponse mapToResponse(Optional<Product> product) {
		logger.info("In Product"+product);
		
		ProductResponse response = new ProductResponse();
        response.setProductId(product.get().getProductId());
        response.setProductCode(product.get().getProductCode());
        response.setProductName(product.get().getProductName());
        response.setCategory(product.get().getCategory());
        response.setPrice(product.get().getPrice());
        response.setValidity(product.get().getValidity());
        response.setDescription(product.get().getDescription());
        response.setActive(product.get().getActive());
        response.setCreatedDate(product.get().getCreatedDate());

        return response;
	}


	@Override
	public ProductResponse findByProductCode(String productCode) {
		logger.info("In productCode ");
		Optional<Product> product=productRepository.findByProductCode(productCode);
		return mapToResponse(product);
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productList=productRepository.findAll();
		return productList;
	}
	
	@Override
	public ProductResponse createProduct(ProductRequest request) {

	    logger.info("Creating Product : {}", request.getProductCode());

	    Product product = new Product();

	    product.setProductCode(request.getProductCode());
	    product.setProductName(request.getProductName());
	    product.setCategory(request.getCategory());
	    product.setPrice(request.getPrice());
	    product.setValidity(request.getValidity());
	    product.setDescription(request.getDescription());
	    product.setActive(request.getActive());
	    product.setCreatedDate(LocalDate.now());

	    Optional<Product> savedProduct =Optional.of(productRepository.save(product));

	    return mapToResponse(savedProduct);
	}



	

}
