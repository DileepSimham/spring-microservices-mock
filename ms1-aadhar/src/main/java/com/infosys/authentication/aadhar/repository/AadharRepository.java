package com.infosys.authentication.aadhar.repository;

import com.infosys.authentication.aadhar.entity.AadharMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AadharRepository extends JpaRepository<AadharMaster,String> {
    AadharMaster getByPhoneNo(String phoneNo);
}
