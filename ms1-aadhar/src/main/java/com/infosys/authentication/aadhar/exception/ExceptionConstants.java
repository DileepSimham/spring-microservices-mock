package com.infosys.authentication.aadhar.exception;

public enum ExceptionConstants {

    CUSTOMER_FIRSTNAME_INVALID("customer.firstname.invalid"),

    CUSTOMER_LASTNAME_INVALID("customer.lastname.invalid"),

    CUSTOMER_PHONE_INVALID("customer.phone.invalid"),

    CUSTOMER_ADDRESS_INVALID("customer.address.invalid"),

    CUSTOMER_PHONE_LENGTH_INVALID("customer.phone.length.invalid"),

    CUSTOMER_AADHAR_FORMAT_INVALID("customer.aadhar.format.invalid"),

    CUSTOMER_AADHAR_INVALID("customer.aadhar.invalid"),

    VALIDATION_FAILED("validation.failed"),

    INPUT_PARM_MISSING("input.parameter.missing"),

    SERVER_ERROR("server.error"),

    CUSTOMER_IFSC_CODE_NOT_FOUND("customer.ifsc.code.not.found");

    private final String type;

    private ExceptionConstants(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
