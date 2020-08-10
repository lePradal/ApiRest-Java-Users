package com.apirest.users.controller;

import com.apirest.users.dto.UserDTO;
import com.apirest.users.models.Address;
import com.apirest.users.models.User;
import com.apirest.users.repository.AddressRepository;
import com.apirest.users.repository.UserRepository;
import org.assertj.core.util.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.NoResultException;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    Logger LOGGER = LoggerFactory.getLogger("UserControllerLogger");

    @Autowired
    AddressController addressController;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/users")
    public List<User> userList() {
        try {
            LOGGER.info("Returning the list of users.");
            return userRepository.findAll();
        } catch (NoResultException e) {
            LOGGER.error("It was not possible to return the user list.");
            throw new NoResultException(e.getMessage());
        }
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable(value = "id") long id) {
        checkIfTheUserExists(id);

        try {
            LOGGER.info("Returning the user.");
            return userRepository.findById(id);
        } catch (NoResultException e) {
            LOGGER.error("It was not possible to return the user.");
            throw new NoResultException(e.getMessage());
        }
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody UserDTO userDTO) {
        Address addressEntity = SaveAddressIfNotExists(userDTO.getAddress());
        User user = userDTO.getUser();
        user.setAddressId(addressEntity.getId());
        try {
            LOGGER.info("Creating the user.");
            return userRepository.save(user);
        } catch (IllegalArgumentException e) {
            LOGGER.error("It was not possible to create the user.");
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private Address SaveAddressIfNotExists(Address address) {
        Boolean existingAddress = addressExists(address);
        if (!existingAddress) addressController.saveAddress(address);
        return getAddressBiNumberAndZipCode(address);
    }

    private boolean addressExists(Address address) {
        address = getAddressBiNumberAndZipCode(address);
        return address != null;
    }

    private Address getAddressBiNumberAndZipCode(Address address) {
        int number = address.getNumber();
        String zipCode = address.getZipCode();
        address = addressController.addressByNumberAndZipCode(number, zipCode);
        return address;
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestBody User user) {
        checkIfTheUserExists(user.getId());

        try {
            LOGGER.info("Deleting the user.");
            userRepository.delete(user);
        } catch (IllegalArgumentException e ) {
            LOGGER.error("It was not possible to delete the user.");
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {

        try {
            LOGGER.info("Updating the user.");
            return userRepository.save(user);
        } catch (IllegalArgumentException e) {
            LOGGER.error("It was not possible to update the user.");
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private User checkIfTheUserExists(long id) {
        User existingUser = userRepository.findById(id);
        Preconditions.checkArgument(existingUser != null, "User not exists.");
        return existingUser;
    }
}
