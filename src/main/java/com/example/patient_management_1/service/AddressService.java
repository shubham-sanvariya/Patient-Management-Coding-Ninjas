package com.example.patient_management_1.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.AddressRepository;
import com.example.patient_management_1.repository.PatientRepository;

@Service
public class AddressService {
    
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PatientRepository patientRepository;

    public Address getAddressById(Long id){
        Address address = addressRepository.findById(id).get();
        if (address == null) {
            throw new NoSuchElementException("address not found by id: " + id);
        }

        return address;
    }

    public void saveAddress(Long patientId,Address address){
        Patient patient = patientRepository.findById(patientId)
        .orElseThrow(() -> new NoSuchElementException("patient not found by id: " + patientId));

        Address ad = addressRepository.findById(address.getId()).orElse(null);
        if (ad != null) {
            throw new NoSuchElementException("address not found by id: " + address.getId());
        }
        addressRepository.save(address);
        patient.setAddress(address);
        patientRepository.save(patient);
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
