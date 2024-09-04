package com.example.patient_management_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    @PostMapping("/add/{patientId}")
    public void saveAddressForPatient(@PathVariable Long patientId, @RequestBody Address address){
        addressService.saveAddress(patientId,address);
    }
}
