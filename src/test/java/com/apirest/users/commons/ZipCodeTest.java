package com.apirest.users.commons;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ZipCodeTest {

    ZipCode zipCode;
    private final String FORMATTED_ZIPCODE = "12345-789";
    private final String ERROR_MSG = "Invalid ZipCode.";

    @Test
    public void testMustCreateAValidZipCodeWithTrace() {
        zipCode = new ZipCode(FORMATTED_ZIPCODE);

        assertThat(zipCode).isNotNull().isInstanceOf(ZipCode.class);
    }

    @Test
    public void testMustCreateAValidZipCodeWithNoTrace() {
        zipCode = new ZipCode("12345789");

        assertThat(zipCode).isNotNull().isInstanceOf(ZipCode.class);
    }

    @Test
    public void testMustReturnTheValueOfZipCode() {
        zipCode = new ZipCode("12345789");

        assertThat(zipCode.getValue()).isNotNull().isInstanceOf(String.class).isEqualTo(FORMATTED_ZIPCODE);
    }

    @Test
    public void testMustReturnAValidZipCode() {
        zipCode = ZipCode.of("12345789");

        assertThat(zipCode.getValue()).isNotNull().isInstanceOf(String.class).isEqualTo(FORMATTED_ZIPCODE);
    }

    @Test
    public void testMustReturnAValidZipCodeValue() {
        String zipCodeValue = ZipCode.valueOf("12345789");

        assertThat(zipCodeValue).isNotNull().isInstanceOf(String.class).isEqualTo(FORMATTED_ZIPCODE);
    }

    @Test
    public void testMustThrowAnExceptionWhenTryingToInstantiateAZipCodeWithTraceWithInvalidLength() {

        assertThatThrownBy(() -> {
            new ZipCode("1234-578"); }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MSG);
    }

    @Test
    public void testMustThrowAnExceptionWhenTryingToInstantiateAZipCodeWithNoTraceWithInvalidLength() {

        assertThatThrownBy(() -> {
            new ZipCode("1234578"); }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MSG);
    }

    @Test
    public void testMustThrowAnExceptionWhenTryingToInstantiateANonNumericZipCodeWithTrace() {

        assertThatThrownBy(() -> {
            new ZipCode("ABCDE-FGH"); }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MSG);
    }

    @Test
    public void testMustThrowAnExceptionWhenTryingToInstantiateANonNumericZipCodeWithNoTrace() {

        assertThatThrownBy(() -> {
            new ZipCode("ABCDEFGH"); }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MSG);
    }

}