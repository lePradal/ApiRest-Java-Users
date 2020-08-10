package com.apirest.users.dto;

import com.apirest.users.models.Address;
import com.apirest.users.models.User;

public class UserDTO {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private Address address;

    public UserDTO() {}
}
