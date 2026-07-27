package com.telecom.customerservice.service;


import java.util.List;

import com.telecom.customerservice.dto.CustomerRequest;
import com.telecom.customerservice.dto.CustomerResponse;


public interface CustomerService {

    CustomerResponse saveCustomer(CustomerRequest request);

    CustomerResponse getCustomerById(Long customerId);

    CustomerResponse getCustomerByMsisdn(String msisdn);

    List<CustomerResponse> getAllCustomers();

    CustomerResponse updateCustomer(Long customerId, CustomerRequest request);

    void deleteCustomer(Long customerId);
}