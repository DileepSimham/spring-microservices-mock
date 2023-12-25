package com.infosys.authentication.aadhar.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ClientErrors implements Serializable {

    List<ClientErrorInfo> errors;
    private static final long serialVersionUID = 1L;

    public ClientErrors(String errorCode, String errorMessage) {
        super();
        errors = new ArrayList<ClientErrorInfo>();
        errors.add(new ClientErrorInfo(errorCode, errorMessage));
    }

    public void addError(String errorCode, String errorMessage) {
        if (errors == null) {
            errors = new ArrayList<ClientErrorInfo>();
        }

        errors.add(new ClientErrorInfo(errorCode, errorMessage));
    }

    public String toString() {
        return "ClientErrors [errors=" + errors + "]";
    }

}
