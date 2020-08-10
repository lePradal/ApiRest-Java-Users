package com.apirest.users.controller;

import com.apirest.users.models.Address;
import com.apirest.users.repository.AddressRepository;
import org.assertj.core.util.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.NoResultException;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AddressController {
    Logger LOGGER = LoggerFactory.getLogger("AddressControllerLogger");

    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/address")
    public List<Address> addressList() {
        try {
            LOGGER.info("Returning the list of address.");
            return addressRepository.findAll();
        } catch (NoResultException e) {
            LOGGER.error("It was not possible to return the address list.");
            throw new NoResultException(e.getMessage());
        }
    }

    @GetMapping("/address/{id}")
    public Address address(@PathVariable(value = "id") long id) {
        checkIfTheAddressExists(id);

        try {
            LOGGER.info("Returning the address.");
            return addressRepository.findById(id);
        } catch (NoResultException e) {
            LOGGER.error("It was not possible to return the address.");
            throw new NoResultException(e.getMessage());
        }
    }

    @GetMapping("/address/{number}/{zipCode}")
    public Address addressByNumberAndZipCode(@PathVariable(value = "number") int number, @PathVariable(value = "zipCode") String zipCode) {
        try {
            LOGGER.info("Returning the address.");
            return addressRepository.findTopByNumberAndZipCode(number, zipCode);

        } catch (NoResultException e) {
            LOGGER.error("It was not possible to return the address.");
            throw new NoResultException(e.getMessage());
        }
    }

    @PostMapping("/address")
    public Address saveAddress(@RequestBody Address address) {
        try {
            LOGGER.info("Creating the address.");
            return addressRepository.save(address);
        } catch (IllegalArgumentException e) {
            LOGGER.error("It was not possible to create the address.");
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @DeleteMapping("/address")
    public void deleteAddress(@RequestBody Address address) {
        checkIfTheAddressExists(address.getId());

        try {
            LOGGER.info("Deleting the address.");
            addressRepository.delete(address);
        } catch (IllegalArgumentException e ) {
            LOGGER.error("It was not possible to delete the address.");
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @PutMapping("/address")
    public Address updateAddress(@RequestBody Address address) {

        try {
            LOGGER.info("Updating the address.");
            return addressRepository.save(address);
        } catch (IllegalArgumentException e) {
            LOGGER.error("It was not possible to update the address.");
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private Address checkIfTheAddressExists(long id) {
        Address existingAddress = addressRepository.findById(id);
        Preconditions.checkArgument(existingAddress != null, "Address not exists.");
        return existingAddress;
    }
}
