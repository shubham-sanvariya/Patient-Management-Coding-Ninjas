package com.example.patient_management_1.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_management_1.entity.Doctor;
import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.PatientRepository;

@Service
public class PatientService {
    
    @Autowired
    PatientRepository patientRepository;

    public Patient getPatientById(Long id){
        Patient patient = patientRepository.findById(id).get();
        if (patient == null) {
            throw new NoSuchElementException("patient not found by id: " + id);
        }

        return patient;
    }

    public void savePatient(Patient patient) {
        Patient pt = patientRepository.findById(patient.getId()).get();
        if (pt == null) {
            throw new NoSuchElementException("patient not found by id: " + patient.getId());
        }
        patientRepository.save(patient);
    }
}
