package com.telecom.customerservice.mapper;

import java.time.LocalDate;

import com.telecom.customerservice.dto.CustomerRequest;
import com.telecom.customerservice.dto.CustomerResponse;
import com.telecom.customerservice.entity.Customer;


public class CustomerMapper {

    private CustomerMapper() {

    }

    public static Customer toEntity(CustomerRequest request) {

        Customer customer = new Customer();
        customer.setMsisdn(request.getMsisdn());
        customer.setCustomerName(request.getCustomerName());
        customer.setCustomerType(request.getCustomerType());
        customer.setCircle(request.getCircle());
        customer.setEmail(request.getEmail());
        customer.setStatus(request.getStatus());
        customer.setKycStatus(request.getKycStatus());
        customer.setActivationDate(LocalDate.now());

        return customer;
    }

    public static CustomerResponse toResponse(Customer customer) {

        CustomerResponse response = new CustomerResponse();
        response.setCustomerId(customer.getCustomerId());
        response.setMsisdn(customer.getMsisdn());
        response.setCustomerName(customer.getCustomerName());
        response.setCustomerType(customer.getCustomerType());
        response.setCircle(customer.getCircle());
        response.setEmail(customer.getEmail());
        response.setStatus(customer.getStatus());
        response.setKycStatus(customer.getKycStatus());
        response.setActivationDate(customer.getActivationDate());

        return response;
    }

}