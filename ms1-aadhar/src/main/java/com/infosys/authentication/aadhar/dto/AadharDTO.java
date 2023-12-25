package com.infosys.authentication.aadhar.dto;

import com.infosys.authentication.aadhar.entity.AadharMaster;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AadharDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String aadharId;

    private String firstName;

    private String lastName;

    private String phoneNo;

    private String address;

    public AadharMaster prepareEntity(AadharDTO dto){
        AadharMaster entity=new AadharMaster();
        entity.setAadharId(dto.getAadharId());
        entity.setAddress(dto.getAddress());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhoneNo(dto.getPhoneNo());

        return entity;
    }

    public static AadharDTO prepareDTO(AadharMaster entity){
        AadharDTO dto=new AadharDTO();
        dto.setAadharId(entity.getAadharId());
        dto.setAddress(entity.getAddress());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPhoneNo(entity.getPhoneNo());
        return dto;
    }
}
