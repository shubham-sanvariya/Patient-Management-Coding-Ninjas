package com.example.patient_management_1.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.repository.AddressRepository;

@Service
public class AddressService {
    
    @Autowired
    AddressRepository addressRepository;

    public Address getAddressById(Long id){
        Address address = addressRepository.findById(id).get();
        if (address == null) {
            throw new NoSuchElementException("address not found by id: " + id);
        }

        return address;
    }

    public void saveAddress(Address address){
        Address ad = addressRepository.findById(address.getId()).get();
        if (ad == null) {
            throw new NoSuchElementException("address not found by id: " + address.getId());
        }
        addressRepository.save(address);
    }

    public void updateAddress(Address address) {
        Address ad = addressRepository.findById(address.getId()).get();
        if (ad == null) {
            throw new NoSuchElementException("address not found by id: " + address.getId());
        }
        addressRepository.save(address);
    }

    public void deleteAddressById(Long id) {
        Address address = addressRepository.findById(id).get();
        if (address == null) {
            throw new NoSuchElementException("address not found by id: " + id);
        }
        addressRepository.deleteById(id);
    }
}
