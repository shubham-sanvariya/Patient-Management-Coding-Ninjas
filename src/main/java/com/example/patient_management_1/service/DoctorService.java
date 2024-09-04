package com.example.patient_management_1.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_management_1.entity.Doctor;
import com.example.patient_management_1.entity.Patient;
import com.example.patient_management_1.repository.DoctorRepository;
import com.example.patient_management_1.repository.PatientRepository;

@Service
public class DoctorService {
    
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    public Doctor getDoctorById(Long id){
        Doctor doctor = doctorRepository.findById(id).get();
        if (doctor == null) {
            throw new NoSuchElementException("doctor not found by id: " + id);
        }

        return doctor;
    }

    public void saveDoctor(Long patientId,Doctor doctor){
        Patient patient = patientRepository.findById(patientId)
        .orElseThrow(() -> new NoSuchElementException("patient not found by id: " + patientId));

        Doctor dr = doctorRepository.findById(doctor.getId()).orElse(null);

        if (dr != null) {
            throw new NoSuchElementException("doctor already exists by id: " + doctor.getId());
        }
        
        doctorRepository.save(doctor);
        patient.setDoctor(doctor);
        patientRepository.save(patient);
    }

    public void updateDoctor(Doctor doctor){
        Doctor dr = doctorRepository.findById(doctor.getId()).get();
        if (dr == null) {
            throw new NoSuchElementException("doctor not found by id: " + doctor.getId());
        }
        doctorRepository.save(doctor);
    }

    public void deleteDoctorById(Long id){
        Doctor doctor = doctorRepository.findById(id).get();
        if (doctor == null) {
            throw new NoSuchElementException("doctor not found by id: " + id);
        }
        doctorRepository.deleteById(id);
    }
}
