package com.apirest.users.commons;

import org.assertj.core.util.Preconditions;

public class CPF {
    private String value;

    public CPF(String value) {
        String cpf = removeDotsAndTrace(value);
        Preconditions.checkArgument(checkCPFLength(cpf), "CPF is invalid.");
        Preconditions.checkArgument(isValid(cpf), "CPF is invalid.");
        this.value = formatted(cpf);
    }

    public static String valueOf(String cpf){
        return new CPF(cpf).getValue();
    }

    public String getValue() {
        return value;
    }

    private boolean checkCPFLength(String cpf) {
        return cpf.length() == 11;
    }

    private String removeDotsAndTrace(String cpf) {
        String pureCpf = cpf;

        if (pureCpf.contains("."))
            pureCpf = pureCpf.replaceAll("[\\.]", "");

        if(pureCpf.contains("-"))
            pureCpf = pureCpf.replaceAll("-", "");

        return pureCpf;
    }

    private String formatted(String cpf) {
        return String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6), cpf.substring(6,9), cpf.substring(9,11));
    }

    private boolean isValid(String cpf) {
        if (    cpf.equals("00000000000") || cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999")) {
            return(false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = (int)(cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48);

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
                return (true);
            } else {
                return(false);
            }
        } catch (IllegalArgumentException err) {
            return(false);
        }
    }

}
