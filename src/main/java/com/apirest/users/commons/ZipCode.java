package com.apirest.users.commons;

import org.assertj.core.util.Preconditions;

public class ZipCode {
    private String value;

    public ZipCode(String zipCode) {
        Preconditions.checkArgument(zipCode != null, "The ZipCode could not be null");
        zipCode = removeTrace(zipCode);
        checkIfIsNumeric(zipCode);
        checkValidLength(zipCode);

        this.value = formatted(zipCode);
    }

    public static String valueOf(String zipCode) {
        return new ZipCode(zipCode).getValue();
    }

    public static ZipCode of(String zipCode) {
        return new ZipCode(zipCode);
    }

    public String getValue() {
        return value;
    }

    private void checkValidLength(String zipCode) {
        if(isInvalidLength(zipCode))
            throw new IllegalArgumentException("Invalid ZipCode.");
    }

    private boolean isInvalidLength(String zipCode) {
        return zipCode.length() != 8;
    }

    private void checkIfIsNumeric(String zipCode) {
        if(isNotNumeric(zipCode)) {
            throw new IllegalArgumentException("Invalid ZipCode.");
        }
    }

    private boolean isNotNumeric(String zipCode) {
        return !zipCode.matches("[0-9]*");
    }

    private String formatted(String zipCode) {
        return String.format("%s-%s", zipCode.substring(0, 5), zipCode.substring(5, 8));
    }

    private String removeTrace(String zipCode) {
        return zipCode.replaceAll("-","");
    }

}
