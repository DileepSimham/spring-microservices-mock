package com.infosys.authentication.aadhar.service;

import com.infosys.authentication.aadhar.dto.AadharDTO;
import com.infosys.authentication.aadhar.exception.ExternalServiceException;

public interface AadharService {

    public boolean isAadharValid(String aadharId,String firstName, String lastName) throws ExternalServiceException;
    public AadharDTO getAadharDetails(String phoneNo);

    public AadharDTO updateAddress(String aadharId, AadharDTO address) throws ExternalServiceException;
}
