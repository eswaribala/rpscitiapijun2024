package com.siemens.customerapisaml.services;

import com.siemens.customerapisaml.dtos.AddressUpdateDTO;
import com.siemens.customerapisaml.models.Address;

import java.util.List;

public interface AddressService {
    Address addAddress(Address address, long accountNo);
    List<Address> fetchAllAddresses();
    List<Address> fetchAddressByAccountNo(long accountNo);

    Address updateAddress(AddressUpdateDTO addressUpdateDTO);
    boolean deleteAddressByAccountNo(long addressId);
}
