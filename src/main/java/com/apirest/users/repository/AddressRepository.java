package com.apirest.users.repository;

import com.apirest.users.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findById(long id);
    Address findTopByNumberAndZipCode(int number, String zipCode);
}
