package com.apirest.users.commons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CPFTest {
    private final String FORMATTED_CPF = "448.664.488-30";
    private final String INVALID_CPF = "448.664.488-31";

    CPF cpf;

    @Test
    public void testMustCreateAValidCPFWithDotsAndTrace() {
        cpf = new CPF("448.664.488-30");
        assertThat(cpf.getValue()).isNotNull().isInstanceOf(String.class).isEqualTo(FORMATTED_CPF);
    }

    @Test
    public void testMustCreateAValidCPFWithDots() {
        cpf = new CPF("448.664.488.30");
        assertThat(cpf.getValue()).isNotNull().isInstanceOf(String.class).isEqualTo(FORMATTED_CPF);
    }

    @Test
    public void testMustCreateAValidCPFWithTraces() {
        cpf = new CPF("448-664-488-30");
        assertThat(cpf.getValue()).isNotNull().isInstanceOf(String.class).isEqualTo(FORMATTED_CPF);
    }

    @Test
    public void testMustCreateAValidCPFWithoutDotsAndTraces() {
        cpf = new CPF("44866448830");
        assertThat(cpf.getValue()).isNotNull().isInstanceOf(String.class).isEqualTo(FORMATTED_CPF);
    }

    @Test
    public void testMustThrownAnExceptionWithAnInvalidCPF() {

        assertThatThrownBy(() -> {
            new CPF(INVALID_CPF); }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("CPF is invalid.");
    }
}