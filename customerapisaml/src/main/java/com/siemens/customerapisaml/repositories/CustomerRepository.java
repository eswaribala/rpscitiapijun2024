package com.siemens.customerapisaml.repositories;

import com.siemens.customerapisaml.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
