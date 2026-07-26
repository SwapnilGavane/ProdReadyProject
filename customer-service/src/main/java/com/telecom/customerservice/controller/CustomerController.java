package com.telecom.customerservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.customerservice.dto.CustomerRequest;
import com.telecom.customerservice.dto.CustomerResponse;
import com.telecom.customerservice.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	private static final Logger logger =  LoggerFactory.getLogger(CustomerController.class);

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping
	public ResponseEntity<CustomerResponse> saveCustomer(@Validated @RequestBody CustomerRequest customerRequest) {
		logger.info("saveCustomer");
		return new ResponseEntity<>(customerService.saveCustomer(customerRequest), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
		logger.info("deleteCustomer");
		customerService.deleteCustomer(id);

		return ResponseEntity.ok("Customer deleted Successfully");
	}

	@GetMapping
	public ResponseEntity<List<CustomerResponse>> getCustomerService() {
		logger.info("getting all Customer");
		return ResponseEntity.ok(customerService.getAllCustomers());
	}

	@GetMapping("/msisdn/{msisdn}")
	public ResponseEntity<CustomerResponse> getCustomerByMsisdn(@PathVariable String msisdn) {
		logger.info("In getCustomerByMsisdn");
		return ResponseEntity.ok(customerService.getCustomerByMsisdn(msisdn));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) {
		logger.info("In getCustomerById:"+id);
		logger.info("In getCustomerById:"+customerService.getCustomerById(id));
		return ResponseEntity.ok(customerService.getCustomerById(id));
	}
}
