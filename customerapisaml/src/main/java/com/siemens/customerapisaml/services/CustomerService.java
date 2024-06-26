package com.siemens.customerapisaml.services;

import com.siemens.customerapisaml.dtos.CustomerUpdateDTO;
import com.siemens.customerapisaml.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    List<Customer> fetchAllCustomers();
    Customer fetchCustomerByAccountNo(long accountNo);
    List<Customer> fetchCustomerByContactNo(long contactNo);
    Customer updateCustomer(CustomerUpdateDTO customerUpdateDTO);
    boolean deleteCustomerByAccountNo(long accountNo);


}
