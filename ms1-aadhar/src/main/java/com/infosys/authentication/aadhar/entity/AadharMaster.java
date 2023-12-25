package com.infosys.authentication.aadhar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AadharMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 12, name = "aadharid")
    private String aadharId;

    @Column(length = 25, nullable = false, name = "firstname")
    private String firstName;

    @Column(length = 25, nullable = false, name = "lastname")
    private String lastName;

    @Column(length = 10, name = "phoneno")
    private String phoneNo;

    @Column(length = 50, nullable = false, name = "address")
    private String address;


    public int hashcode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((aadharId == null) ? 0 : aadharId.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AadharMaster other = (AadharMaster) obj;
        if (aadharId == null) {
            if (other.aadharId != null)
                return false;
        } else if (!aadharId.equals(other.aadharId)) {
            return false;
        }

        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address)) {
            return false;
        }

        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName)) {
            return false;
        }

        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName)) {
            return false;
        }

        if (phoneNo == null) {
            if (other.phoneNo != null)
                return false;
        } else if (!phoneNo.equals(other.phoneNo)) {
            return false;
        }

        return true;
    }


}
