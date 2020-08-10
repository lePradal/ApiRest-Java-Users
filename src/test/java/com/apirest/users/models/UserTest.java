package com.apirest.users.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    User user;

    String name;
    String email;
    long addressId;
    String phoneNumber;
    String cpf;
    Date birth;

    @BeforeEach
    void setUp() {
        name = "name";
        email = "email@g.com";
        addressId = 123;
        phoneNumber = "99999-9999";
        cpf = "448.664.488-30";
        birth = new Date();

        user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAddressId(addressId);
        user.setPhoneNumber(phoneNumber);
        user.setCpf(cpf);
        user.setBirth(birth);
    }

    @Test
    void getSerialVersionUID() {
        assertThat(User.getSerialVersionUID()).isNotNull().isInstanceOf(Long.class);
    }

    @Test
    void getId() {
        assertThat(user.getId()).isNotNull().isInstanceOf(Long.class);
    }

    @Test
    void getName() {
        assertThat(user.getName()).isNotNull().isInstanceOf(String.class).isEqualTo(name);
    }

    @Test
    void setName() {
        user.setName(name);
        assertThat(user.getName()).isNotNull().isInstanceOf(String.class).isEqualTo(name);
    }

    @Test
    void getEmail() {
        assertThat(user.getEmail()).isNotNull().isInstanceOf(String.class).isEqualTo(email);
    }

    @Test
    void setEmail() {
        user.setEmail(email);
        assertThat(user.getEmail()).isNotNull().isInstanceOf(String.class).isEqualTo(email);
    }

    @Test
    void getAddress() {
        assertThat(user.getAddressId()).isNotNull().isInstanceOf(Long.class).isEqualTo(addressId);
    }

    @Test
    void setAddress() {
        user.setAddressId(addressId);
        assertThat(user.getAddressId()).isNotNull().isInstanceOf(Long.class).isEqualTo(addressId);
    }

    @Test
    void getPhoneNumber() {
        assertThat(user.getPhoneNumber()).isNotNull().isInstanceOf(String.class).isEqualTo(phoneNumber);
    }

    @Test
    void setPhoneNumber() {
        user.setPhoneNumber(phoneNumber);
        assertThat(user.getPhoneNumber()).isNotNull().isInstanceOf(String.class).isEqualTo(phoneNumber);
    }

    @Test
    void getCpf() {
        assertThat(user.getCpf()).isNotNull().isInstanceOf(String.class).isEqualTo(cpf);
    }

    @Test
    void setCpf() {
        user.setCpf(cpf);
        assertThat(user.getCpf()).isNotNull().isInstanceOf(String.class).isEqualTo(cpf);
    }

    @Test
    void getBirth() {
        assertThat(user.getBirth()).isNotNull().isInstanceOf(Date.class).isEqualTo(birth);
    }

    @Test
    void setBirth() {
        user.setBirth(birth);
        assertThat(user.getBirth()).isNotNull().isInstanceOf(Date.class).isEqualTo(birth);
    }
}