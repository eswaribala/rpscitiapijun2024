package com.siemens.customerapisaml.repositories;

import com.siemens.customerapisaml.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
