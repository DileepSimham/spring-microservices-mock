package com.infosys.authentication.aadhar.service;


import com.infosys.authentication.aadhar.dto.AadharDTO;
import com.infosys.authentication.aadhar.entity.AadharMaster;
import com.infosys.authentication.aadhar.exception.ExceptionConstants;
import com.infosys.authentication.aadhar.exception.ExternalServiceException;
import com.infosys.authentication.aadhar.repository.AadharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@SuppressWarnings("unused")
public class AadharServiceImpl implements AadharService {

    @Autowired
    private AadharServiceValidation aadharServiceValidation;

    @Autowired
    private AadharRepository aadharRepository;

    @Override
    public boolean isAadharValid(String aadharId, String firstName, String lastName) throws ExternalServiceException {
        Optional<AadharMaster> aadhar;
        boolean inputValid = aadharServiceValidation.isInputValid(aadharId, firstName, lastName);
        if (inputValid) {
            aadhar = aadharRepository.findById(aadharId);
            if(aadhar.isPresent()){
                return aadhar.get().getFirstName().equals(firstName) && aadhar.get().getLastName().equals(lastName);
            }

        }
        return false;
    }

    @Override
    public AadharDTO getAadharDetails(String phoneNo) {
        boolean phoneNoValid = aadharServiceValidation.isPhoneNoValid(phoneNo);
        if (!phoneNoValid) {
            throw new ExternalServiceException(ExceptionConstants.CUSTOMER_PHONE_LENGTH_INVALID.toString());
        }

        AadharMaster byPhoneNo = aadharRepository.getByPhoneNo(phoneNo);
        if (byPhoneNo == null) {
            throw new ExternalServiceException(ExceptionConstants.CUSTOMER_PHONE_INVALID.toString());
        }

        return AadharDTO.prepareDTO(byPhoneNo);

    }

    @Override
    public AadharDTO updateAddress(String aadharId, AadharDTO address) throws ExternalServiceException {
        Optional<AadharMaster> aadhar;

        boolean matches = aadharId.matches("[0-9]{12}");
        if (!matches) {
            throw new ExternalServiceException(ExceptionConstants.CUSTOMER_AADHAR_FORMAT_INVALID.toString());
        }
        System.out.println(address.getAddress());

        if (!aadharServiceValidation.isAddressValid(address.getAddress())) {
            throw new ExternalServiceException(ExceptionConstants.CUSTOMER_ADDRESS_INVALID.toString());

        }

        aadhar = aadharRepository.findById(aadharId);
        if (aadhar.isEmpty()) {
            throw new ExternalServiceException(ExceptionConstants.CUSTOMER_AADHAR_INVALID.toString());
        }

        aadhar.get().setAddress(address.getAddress());
        AadharMaster save = aadharRepository.save(aadhar.get());
        if (save == null) {
            throw new ExternalServiceException(ExceptionConstants.SERVER_ERROR.toString());

        }

        return AadharDTO.prepareDTO(aadhar.get());
    }



}
