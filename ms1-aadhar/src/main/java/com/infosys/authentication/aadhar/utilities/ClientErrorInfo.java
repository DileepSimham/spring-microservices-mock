package com.infosys.authentication.aadhar.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientErrorInfo  implements Serializable {

    String code;
    String message;
    private static final long serialVersionUID = 1L;


}
