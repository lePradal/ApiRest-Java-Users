package com.apirest.users.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddressTest {
    Address address;

    String street;
    int number;
    String city;
    String state;
    String country;
    String zipCode;

    @BeforeEach
    void setUp() {
        street = "street";
        number = 58;
        city = "city";
        state = "state";
        country = "country";
        zipCode = "12345-789";

        address = new Address();

        address.setStreet(street);
        address.setNumber(number);
        address.setCity(city);
        address.setState(state);
        address.setCountry(country);
        address.setZipCode(zipCode);
    }

    @Test
    void getSerialVersionUID() {
        assertThat(address.getSerialVersionUID()).isNotNull().isInstanceOf(Long.class);
    }

    @Test
    void getId() {
        assertThat(address.getId()).isNotNull().isInstanceOf(Long.class);
    }

    @Test
    void getStreet() {
        assertThat(address.getStreet()).isNotNull().isInstanceOf(String.class).isEqualTo(street);
    }

    @Test
    void setStreet() {
        address.setStreet(street);
        assertThat(address.getStreet()).isNotNull().isInstanceOf(String.class).isEqualTo(street);
    }

    @Test
    void getNumber() {
        assertThat(address.getNumber()).isNotNull().isInstanceOf(Integer.class).isEqualTo(number);
    }

    @Test
    void setNumber() {
        address.setNumber(number);
        assertThat(address.getNumber()).isNotNull().isInstanceOf(Integer.class).isEqualTo(number);
    }

    @Test
    void getCity() {
        assertThat(address.getCity()).isNotNull().isInstanceOf(String.class).isEqualTo(city);
    }

    @Test
    void setCity() {
        address.setCity(city);
        assertThat(address.getCity()).isNotNull().isInstanceOf(String.class).isEqualTo(city);
    }

    @Test
    void getState() {
        assertThat(address.getState()).isNotNull().isInstanceOf(String.class).isEqualTo(state);
    }

    @Test
    void setState() {
        address.setState(state);
        assertThat(address.getState()).isNotNull().isInstanceOf(String.class).isEqualTo(state);
    }

    @Test
    void getCountry() {
        assertThat(address.getCountry()).isNotNull().isInstanceOf(String.class).isEqualTo(country);
    }

    @Test
    void setCountry() {
        address.setCountry(country);
        assertThat(address.getCountry()).isNotNull().isInstanceOf(String.class).isEqualTo(country);
    }

    @Test
    void getZipCode() {
        assertThat(address.getZipCode()).isNotNull().isInstanceOf(String.class).isEqualTo(zipCode);
    }

    @Test
    void setZipCode() {
        address.setZipCode(zipCode);
        assertThat(address.getZipCode()).isNotNull().isInstanceOf(String.class).isEqualTo(zipCode);
    }
}