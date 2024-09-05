package com.example.patient_management_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public Address getAddress(@PathVariable Long id) {
        return addressService.getAddress(id);
    }

    @PostMapping("/add/{patientId}")
    public Address createAddress(@PathVariable Long patientId, @RequestBody Address address) {
        return addressService.createAddress(patientId, address);
    }

    @PutMapping("/update")
    public Address updateAddress(@RequestBody Address address) {
        return addressService.updateAddress(address);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}
