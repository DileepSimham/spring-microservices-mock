package com.infosys.authentication.aadhar.service;

import com.infosys.authentication.aadhar.exception.ExceptionConstants;
import com.infosys.authentication.aadhar.exception.ExternalServiceException;
import org.springframework.stereotype.Service;

@Service
public class AadharServiceValidation {
    public boolean isInputValid(String aadharId, String firstName, String lastName) throws ExternalServiceException {
        if (!(aadharId.matches("[0-9]{12}")))
            throw new ExternalServiceException(ExceptionConstants.CUSTOMER_AADHAR_FORMAT_INVALID.toString());
        else if (firstName.isEmpty()) {
            throw new ExternalServiceException(ExceptionConstants.CUSTOMER_FIRSTNAME_INVALID.toString());
        } else if (lastName.isEmpty()) {
            throw new ExternalServiceException(ExceptionConstants.CUSTOMER_LASTNAME_INVALID.toString());
        } else
            return true;
    }



    //Given
    public boolean isPhoneNoValid(String phoneNo) throws ExternalServiceException{
        if(!(phoneNo.matches("[0-9]{10}")))
            throw new ExternalServiceException(ExceptionConstants.CUSTOMER_PHONE_LENGTH_INVALID.toString());

        return true;
    }

    public boolean isAddressValid(String address) throws ExternalServiceException{
        if(address.isEmpty())
            throw new ExternalServiceException(ExceptionConstants.CUSTOMER_ADDRESS_INVALID.toString());
        return true;
    }
}
