package com.example.patient_management_1.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_management_1.entity.Doctor;
import com.example.patient_management_1.repository.DoctorRepository;

@Service
public class DoctorService {
    
    @Autowired
    DoctorRepository doctorRepository;

    public Doctor getDoctorById(Long id){
        Doctor doctor = doctorRepository.findById(id).get();
        if (doctor == null) {
            throw new NoSuchElementException("doctor not found by id: " + id);
        }

        return doctor;
    }
}
