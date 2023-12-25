package com.infosys.authentication.aadhar.controller;

import com.infosys.authentication.aadhar.dto.AadharDTO;
import com.infosys.authentication.aadhar.entity.AadharMaster;
import com.infosys.authentication.aadhar.repository.AadharRepository;
import com.infosys.authentication.aadhar.service.AadharServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aadhar")
public class AadharController {

    @Autowired
    private AadharServiceImpl aadharMaster;

    @GetMapping
    public ResponseEntity<Boolean> isAadharValid(@RequestParam("aadharId") String aadharId,
                                                 @RequestParam("firstName") String firstName,
                                                 @RequestParam("lastName") String lastName
    ) {
        boolean aadharValid = aadharMaster.isAadharValid(aadharId, firstName, lastName);


        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(aadharValid);

    }

    @PutMapping("/{aadharId}")
    public ResponseEntity<AadharDTO> updateAddress(@PathVariable("aadharId") String aadharId, @RequestBody AadharDTO address){

        System.out.println(aadharId);
        AadharDTO aadharDTO = aadharMaster.updateAddress(aadharId, address);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(aadharDTO);
    }

    @GetMapping("/{phoneNo}")
    public ResponseEntity<AadharDTO> getAadharDetails(@PathVariable String phoneNo){
        AadharDTO aadharDetails = aadharMaster.getAadharDetails(phoneNo);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(aadharDetails);
    }


    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }


}
