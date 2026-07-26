package com.telecom.customerservice.impl.CustomerServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.telecom.customerservice.dto.CustomerRequest;
import com.telecom.customerservice.dto.CustomerResponse;
import com.telecom.customerservice.entity.Customer;
import com.telecom.customerservice.exception.ResourceNotFoundException;
import com.telecom.customerservice.mapper.CustomerMapper;
import com.telecom.customerservice.repository.CustomerRepository;
import com.telecom.customerservice.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger =  LoggerFactory.getLogger(CustomerServiceImpl.class);

	
	private final CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public CustomerResponse saveCustomer(CustomerRequest request) {
		Customer customer =CustomerMapper.toEntity(request);
		Customer customersave=customerRepository.save(customer);
		
		return CustomerMapper.toResponse(customersave);
	}

	@Override
	public CustomerResponse getCustomerById(Long customerId) {
		Customer customer=customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("No Customer found with id:"+customerId));
		return CustomerMapper.toResponse(customer);
	}

	@Override
	public CustomerResponse getCustomerByMsisdn(String msisdn) {
		logger.info("Customer created successfully : {}", msisdn);
		Customer customer=customerRepository.findByMsisdn(msisdn).orElseThrow(()-> new ResourceNotFoundException("No Customer found with msisdn:"+msisdn));
		return CustomerMapper.toResponse(customer);
	}

	@Override
	public List<CustomerResponse> getAllCustomers() {
		List<CustomerResponse> customerList=customerRepository.findAll().stream().map(CustomerMapper::toResponse).toList();
		
		return customerList;
	}

	@Override
	public CustomerResponse updateCustomer(Long customerId, CustomerRequest request) {
		return null;
	}

	@Override
	public void deleteCustomer(Long customerId) {

		 Customer customer = customerRepository.findById(customerId)
		            .orElseThrow(() ->
		                    new ResourceNotFoundException(
		                            "Customer not found with id : " + customerId));

		    customerRepository.delete(customer);
	}

}
